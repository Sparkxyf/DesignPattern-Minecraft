package design.publishsubscriber;

import design.farm.Farm;
import design.farm.FarmLand;
import design.farm.FarmlandAbstractFactory;
import design.farm.Field;
import design.farm.SubcribePublish.MessagePublisher;
import design.farm.SubcribePublish.NewsSubscriber;
import org.junit.Test;

public class PublishSubscriberTest {
    @Test
    public void test(){
        System.out.println("=====Publish Subscriber Test=====");
        NewsSubscriber subscriber1 = new NewsSubscriber();
        NewsSubscriber subscriber2 = new NewsSubscriber();
        MessagePublisher.instance().register("新闻", subscriber1);
        MessagePublisher.instance().register("新闻", subscriber2);
        MessagePublisher.instance().register("天气", subscriber1);
        MessagePublisher.instance().publish("新闻", "这是一个1和2都能收到的新闻");
        MessagePublisher.instance().publish("天气", "这是一个只有2能收到的天气");
    }
}
