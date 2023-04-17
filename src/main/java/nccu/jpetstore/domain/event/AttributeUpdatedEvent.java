package nccu.jpetstore.domain.event;

import java.util.Map;

public class AttributeUpdatedEvent<T> extends DomainEvent<T>  {

    private Map.Entry<String, Object> entry;

    public AttributeUpdatedEvent(T entity, Map.Entry<String, Object> update, long timestamp) {
        super(entity, timestamp);
        entry = update;
    }

    public Map.Entry<String, Object> getUpdate() {
        return entry;
    }


    public String toString() {
        return "EntityUpdatedEvent{" +
                "entity=" + this.getEntity() +
                ", timestamp=" + this.getTimestamp() +
                ", update=" + this.getUpdate() +
                '}';
    }

}
