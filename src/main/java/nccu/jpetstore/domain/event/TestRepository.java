package nccu.jpetstore.domain.event;

public class TestRepository {

    private final static EventStore eventStore = new EventStore("esdb://127.0.0.1:2113?tls=false&keepAliveTimeout=10000&keepAliveInterval=10000");
    private final static EventSourcedCategoryRepository repository = new EventSourcedCategoryRepository(eventStore);

    public static void main(String[] args){
        //testFindBy();
        //testCreate();
        //testAppend();
    }

    private static void testAppend() {
        Category category = repository.findBy("7791cbe9-a726-4991-a6c5-bfbc554d0e73");
        category.setName("Dog-updated-1");
        category.setDescription("This is a dog category-updated-1");
        System.out.println(repository.save(category));
    }

    private static void testFindBy() {
        Category category = repository.findBy("7791cbe9-a726-4991-a6c5-bfbc554d0e73");
        System.out.println(category);
    }

    private static void testCreate() {
        Category category = new Category();
        category.setName("Dog");
        category.setDescription("This is a dog category");
        System.out.println(repository.save(category));
    }


}
