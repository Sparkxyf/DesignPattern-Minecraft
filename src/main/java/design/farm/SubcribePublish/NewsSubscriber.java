package design.farm.SubcribePublish;

import java.util.Map;

public class NewsSubscriber implements MessageSubscriber {
    public boolean newsSub = false;
    public boolean reportSub = false;
    public void onRecived(String message, String params){
        System.out.println("今日"+message+":"+params);
    }
}
