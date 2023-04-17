package nccu.jpetstore.domain.event;

import java.util.HashMap;
import java.util.Map;

public class EntityUpdatedEvent<T> extends DomainEvent<T> {

    private Map<String, Object> updates;

    public EntityUpdatedEvent(T entity, long timestamp) {
        super(entity, timestamp);
        updates = new HashMap<>();
    }

    public void updateAttribute(String attributeName, Object newValue) {
        updates.put(attributeName, newValue);
    }

    public Map<String, Object> getUpdates() {
        return updates;
    }



}
