package nccu.jpetstore.domain.event;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 載入串流;特定版本
// 做event store

public class Category {
    private String categoryId;
    private String name;
    private String description;

    private List<DomainEvent<Category>> eventStore;

    public Category() {
        eventStore = new ArrayList<>();
        cause(new EntityCreatedEvent(this, new Date().getTime()));
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        AttributeUpdatedEvent<Category> event =
                new AttributeUpdatedEvent<>(this, new AbstractMap.SimpleEntry<>("categoryId", categoryId), new Date().getTime());
        cause(event);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        AttributeUpdatedEvent<Category> event =
                new AttributeUpdatedEvent<>(this, new AbstractMap.SimpleEntry<>("name", name), new Date().getTime());
        cause(event);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        AttributeUpdatedEvent<Category> event =
                new AttributeUpdatedEvent<>(this, new AbstractMap.SimpleEntry<>("description", description), new Date().getTime());
       cause(event);
    }

    private void cause(DomainEvent<Category> event) {
        mutate(event);
        eventStore.add(event);
    }

    private void mutate(DomainEvent<Category> event) {
        if (event instanceof EntityCreatedEvent) {
            // applyCreatedEvent((EntityCreatedEvent<Category>) event);
        } else if (event instanceof AttributeUpdatedEvent) {
            applyUpdatedEvent((AttributeUpdatedEvent<Category>) event);
        } else throw new IllegalArgumentException();

    }

//    private void applyCreatedEvent(EntityCreatedEvent<Category> event) {
//        this.categoryId = event.getEntity().getCategoryId();
//        this.name = event.getEntity().getName();
//        this.description = event.getEntity().getDescription();
//    }

    private void applyUpdatedEvent(AttributeUpdatedEvent<Category> event) {
        switch (event.getUpdate().getKey()) {
            case "categoryId":
                this.categoryId = (String) event.getUpdate().getValue();
                break;
            case "name":
                this.name = (String) event.getUpdate().getValue();
                break;
            case "description":
                this.description = (String) event.getUpdate().getValue();
                break;
        }
    }

//    public void addEvent(DomainEvent<Category> event) {
//        eventStore.add(event);
//        applyEvent(event);
//    }

    public void reset() {
        eventStore.clear();
    }

    public List<DomainEvent<Category>> getEvents() {
        return eventStore;
    }


    @Override
    public String toString() {
        return String.format("Category{categoryId='%s', name='%s', description='%s'}",
                categoryId, name, description);
    }

}
