package nccu.jpetstore.domain.event;

import com.eventstore.dbclient.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryEventStoreTest {

    public static void main(String[] args) throws Exception {
        EventStoreDBClientSettings settings = EventStoreDBConnectionString.parse("esdb://127.0.0.1:2113?tls=false&keepAliveTimeout=10000&keepAliveInterval=10000");
        EventStoreDBClient client = EventStoreDBClient.create(settings);

        //EntityCreatedEvent event = new EntityCreatedEvent(UUID.randomUUID().toString(), Category.class.getName(), new Date().getTime());

        Category category = new Category();

        //category.setCategoryId("123");
        category.setName("456");
        category.setDescription("789");

        //event.setData(category);

        for (DomainEvent e : category.getEvents()) {
            EventData eventData = EventData
                    .builderAsJson(e.getClass().getName(), e)
                    .build();
            //System.out.println(e.getId());
            client.appendToStream(e.getStreamId(), eventData).get();
            //System.out.println(eventData);
        }


        ReadStreamOptions options = ReadStreamOptions.get().fromEnd().backwards().maxCount(1);

        ReadResult result = client.readStream(category.getEvents().get(0).getStreamId(), options)
                .get();

        RecordedEvent e = result.getEvents().get(0).getOriginalEvent();
        byte[] data = e.getEventData();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(data, Object.class));

//        List<ResolvedEvent> events = result.getEvents();
//        for (ResolvedEvent e : events) {
//            RecordedEvent recordedEvent = e.getOriginalEvent();
//        }

    }
}
