package design.farm.SubcribePublish;

import design.farm.Clock;

import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Random;

public class MessagePublisher {
    private static MessagePublisher singleton;
    private static Map<String, ArrayList<MessageSubscriber>> subscribers;

    private MessagePublisher(){}

    public static MessagePublisher instance(){
        if(singleton == null)
            singleton = new MessagePublisher();
        return singleton;
    }
    public void daily(){
        publish("新闻", "今天是你来到这个村子的第"+
                Clock.getInstance().getState()+"天！听说今天村长出门摔了一跤！");
        if(Math.random()<0.9){
            publish("天气", "第"+Clock.getInstance().getState()+"天：晴");
        }
        else{
            publish("天气", "第"+Clock.getInstance().getState()+"天：雨");
        }
    }
    public void register(String message, MessageSubscriber subscriber){
        if(subscriber == null)
            return;
        if(subscribers == null)
            subscribers = new LinkedHashMap<String, ArrayList<MessageSubscriber>>();
        ArrayList<MessageSubscriber> subscriberList = subscribers.get(message);
        if(subscriberList == null){
            subscriberList = new ArrayList<MessageSubscriber>();
            subscribers.put(message, subscriberList);
        }
        subscriberList.add(subscriber);
    }

    public void publish(String message, String params){
        if(subscribers == null)
            return;
        ArrayList<MessageSubscriber> subscriberList = subscribers.get(message);
        if(subscriberList == null || subscriberList.isEmpty())
            return;
        for (MessageSubscriber topicSubscriber : subscriberList)
            topicSubscriber.onRecived(message, params);
    }
}