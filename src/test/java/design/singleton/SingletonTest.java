package design.singleton;
import design.farm.*;
import design.farm.Adapter.ChickenAdapter;
import design.farm.Adapter.CowAdapter;
import design.farm.SubcribePublish.MessagePublisher;
import design.farm.SubcribePublish.NewsSubscriber;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void ClockTest() {
        System.out.println("======Testing Singleton======");
        Clock clock1 = Clock.getInstance();
        Clock clock2 = Clock.getInstance();
        if (clock1 == clock2) {
            System.out.println("clock1 and clock2 are the same instance.");
        } else {
            System.out.println("clock1 and clock2 are not the same instance.");
        }
    }
    @Test
    public void MessagePublisherTest() {
        System.out.println("======Testing Singleton======");
        MessagePublisher publisher1 = MessagePublisher.instance();
        MessagePublisher publisher2 = MessagePublisher.instance();
        if (publisher1 == publisher2) {
            System.out.println("publisher1 and publisher2 are the same instance.");
        } else {
            System.out.println("publisher1 and publisher2 are not the same instance.");
        }
    }
    @Test
    public void ChickenAdaptorTest() {
        System.out.println("======Testing Singleton======");
        ChickenAdapter chickenAdapter1 = ChickenAdapter.getInstance();
        ChickenAdapter chickenAdapter2 = ChickenAdapter.getInstance();
        if (chickenAdapter1 == chickenAdapter2) {
            System.out.println("chickenAdapter1 and chickenAdapter2 are the same instance.");
        } else {
            System.out.println("chickenAdapter1 and chickenAdapter2 are not the same instance.");
        }
    }
    @Test
    public void CowAdaptorTest() {
        System.out.println("======Testing Singleton======");
        CowAdapter cowAdapter1 = CowAdapter.getInstance();
        CowAdapter cowAdapter2 = CowAdapter.getInstance();
        if (cowAdapter1 == cowAdapter2) {
            System.out.println("cowAdapter1 and cowAdapter2 are the same instance.");
        } else {
            System.out.println("cowAdapter1 and cowAdapter2 are not the same instance.");
        }
    }
}
