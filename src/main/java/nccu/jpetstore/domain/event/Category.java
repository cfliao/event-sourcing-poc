package nccu.jpetstore.domain.event;

import java.util.*;

// 載入串流;特定版本
// 做event store

public class Category {
    private String categoryId;
    private String name;
    private String description;

    private List<DomainEvent> eventCache;

    public Category() {
        eventCache = new ArrayList<>();
        categoryId = UUID.randomUUID().toString();
        cause(new EntityCreatedEvent(getStreamId(), Category.class.getName(), new Date().getTime()));
    }

    public String getCategoryId() {
        return categoryId;
    }

//    public void setCategoryId(String categoryId) {
//        AttributeUpdatedEvent event = generateAttributeUpdatedEvent("categoryId", categoryId);
//        cause(event);
//    }

    private AttributeUpdatedEvent generateAttributeUpdatedEvent(String key, Object value) {
        AttributeUpdatedEvent event =
                new AttributeUpdatedEvent(getStreamId(), Category.class.getName(), new Date().getTime());
        event.setName(key);
        event.setValue(value);
        return event;
    }

    private String getStreamId() {
        return Category.class.getName() + "." + categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        AttributeUpdatedEvent event = generateAttributeUpdatedEvent("name", name);
        cause(event);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        AttributeUpdatedEvent event = generateAttributeUpdatedEvent("description", description);
        cause(event);
    }

    private void cause(DomainEvent event) {
        mutate(event);
        eventCache.add(event);
    }

    public void mutate(DomainEvent event) {
        if (event instanceof EntityCreatedEvent) {
            // applyCreatedEvent((EntityCreatedEvent<Category>) event);
        } else if (event instanceof AttributeUpdatedEvent) {
            applyUpdatedEvent((AttributeUpdatedEvent) event);
        } else throw new IllegalArgumentException();

    }

//    private void applyCreatedEvent(EntityCreatedEvent<Category> event) {
//        this.categoryId = event.getEntity().getCategoryId();
//        this.name = event.getEntity().getName();
//        this.description = event.getEntity().getDescription();
//    }

    private void applyUpdatedEvent(AttributeUpdatedEvent event) {
        switch (event.getName()) {
            case "name":
                this.name = (String) event.getValue();
                break;
            case "description":
                this.description = (String) event.getValue();
                break;
        }
    }

//    public void addEvent(DomainEvent<Category> event) {
//        eventStore.add(event);
//        applyEvent(event);
//    }

    public void reset() {
        eventCache.clear();
    }

    public List<DomainEvent> getEvents() {
        return eventCache;
    }


    @Override
    public String toString() {
        return String.format("Category{categoryId='%s', name='%s', description='%s'}",
                categoryId, name, description);
    }

}
