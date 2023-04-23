package nccu.jpetstore.domain.event;

public abstract class DomainEvent {
    private String entityType;
    private long timestamp;
    private String id;

    public DomainEvent(String id, String entityType, long timestamp) {
        this.entityType = entityType;
        this.timestamp = timestamp;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEntityType() {
        return entityType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public java.lang.String toString() {
        return "DomainEvent{" +
                "entity=" + entityType +
                ", timestamp=" + timestamp +
                '}';
    }

}
