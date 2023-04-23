package nccu.jpetstore.domain.event;

public class AttributeUpdatedEvent extends DomainEvent {
    // private Map.Entry<String, Object> entry;

    private String name;
    private Object value;

    public AttributeUpdatedEvent(String id, String entityType, long timestamp) {
        super(id, entityType, timestamp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return "EntityUpdatedEvent{" +
                "entity=" + this.getEntityType() +
                ", timestamp=" + this.getTimestamp() +
                ", name=" + this.getName() +
                ", value=" + this.getValue() +
                '}';
    }

}
