package nccu.jpetstore.domain.event;

public abstract class DomainEvent {
    private String entityType;
    private String eventType;
    private long timestamp;
    private String streamId;

    public DomainEvent(String streamId, String entityType, long timestamp) {
        this.entityType = entityType;
        this.timestamp = timestamp;
        this.streamId = streamId;
        this.eventType = this.getClass().getName();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }



    public String getStreamId() {
        return streamId;
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
