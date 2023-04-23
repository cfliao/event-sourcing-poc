package nccu.jpetstore.domain.event;

public class EntityCreatedEvent extends DomainEvent {

    public EntityCreatedEvent(String id, String entityType, long timestamp) {
        super(id, entityType, timestamp);
    }

//
//    public void setData(Object data) throws JsonProcessingException {
//        //ObjectMapper mapper = new ObjectMapper();
//        this.data = data; //mapper.writeValueAsString(data);
//    }

//    public String toString() {
//        return "EntityCreatedEvent{" +
//                "entity=" + this.getEntityType() +
//                ", timestamp=" + this.getTimestamp() +
//                '}';
//    }

}