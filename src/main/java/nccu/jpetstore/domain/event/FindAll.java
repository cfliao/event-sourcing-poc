package nccu.jpetstore.domain.event;

import com.eventstore.dbclient.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class FindAll {
    public static void main(String[] args) throws Exception {
        EventStoreDBClientSettings settings = EventStoreDBConnectionString.parse("esdb://127.0.0.1:2113?tls=false&keepAliveTimeout=10000&keepAliveInterval=10000");
        EventStoreDBClient client = EventStoreDBClient.create(settings);

        ReadStreamOptions options = ReadStreamOptions.get().fromEnd().backwards().maxCount(2);
        ReadResult result = client.readStream("$streams",options).get();

        List<ResolvedEvent> events = result.getEvents();
        for (ResolvedEvent e : events) {
            RecordedEvent recordedEvent = e.getEvent();
            byte[] data = recordedEvent.getEventData();
//            ObjectMapper mapper = new ObjectMapper();
//            System.out.println(mapper.readValue(data, Object.class));
            System.out.println(new String(data));
            System.out.println(recordedEvent.getContentType());
        }


    }
}
