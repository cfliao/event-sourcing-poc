package nccu.jpetstore.domain.event;

import java.util.HashMap;
import java.util.Map;

public class EntityUpdatedEvent extends DomainEvent {

    private Map<String, Object> updates;

    public EntityUpdatedEvent(String uuid, String entity, long timestamp) {
        super(uuid, entity, timestamp);
        updates = new HashMap<>();
    }

    public void updateAttribute(String attributeName, Object newValue) {
        updates.put(attributeName, newValue);
    }

    public Map<String, Object> getUpdates() {
        return updates;
    }



}
