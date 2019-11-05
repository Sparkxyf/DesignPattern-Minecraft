package design.farm.SubcribePublish;
import java.util.Map;
public interface MessageSubscriber {
    public void onRecived(String message, String params);
}