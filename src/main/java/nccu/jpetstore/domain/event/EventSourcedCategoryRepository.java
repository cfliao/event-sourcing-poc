package nccu.jpetstore.domain.event;

import java.util.List;

public class EventSourcedCategoryRepository {

    public EventSourcedCategoryRepository(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    private EventStore eventStore;

    public String save(Category category) {
        String streamId = null;
        for (DomainEvent e : category.getEvents()) {
            try {
                streamId = e.getStreamId();
                eventStore.appendToStream(streamId,e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return streamId;
    }

    public Category findBy(String categoryId) {
        String streamId = Category.class.getName() + "." + categoryId;
        List<DomainEvent> events = eventStore.getStream(streamId);
        Category category = new Category(categoryId);

        for (DomainEvent event : events) {
           // System.out.println("Mutate because of the event: " + event);
            category.mutate(event);
            //System.out.println("Object states after the mutate: " + category);
        }
        return category;
    }

    public static void main(String[] args) {
//        EventStore eventStore = new EventStore("esdb://127.0.0.1:2113?tls=false&keepAliveTimeout=10000&keepAliveInterval=10000");
//        EventSourcedCategoryRepository repository = new EventSourcedCategoryRepository(eventStore);
//        Category category = repository.findBy("863d988c-bdd8-4206-9a38-fdda1a443a9c");
//        System.out.println(category);
    }

}
