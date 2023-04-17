package nccu.jpetstore.domain.event;

public abstract class DomainEvent<T> {
    private String entity;
    private long timestamp;

    public DomainEvent(T entity, long timestamp) {
        this.entity = entity.getClass().getName();
        this.timestamp = timestamp;
    }

    public String getEntity() {
        return entity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public java.lang.String toString() {
        return "DomainEvent{" +
                "entity=" + entity +
                ", timestamp=" + timestamp +
                '}';
    }

}
