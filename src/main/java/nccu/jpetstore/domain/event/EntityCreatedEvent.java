package nccu.jpetstore.domain.event;

public class EntityCreatedEvent<S> extends DomainEvent<S> {

    public EntityCreatedEvent(S entity, long timestamp) {
        super(entity, timestamp);
    }


    public String toString() {
        return "EntityCreatedEvent{" +
                "entity=" + this.getEntity() +
                ", timestamp=" + this.getTimestamp() +
                '}';
    }

}