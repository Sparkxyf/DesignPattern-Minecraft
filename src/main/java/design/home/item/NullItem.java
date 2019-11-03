package design.home.item;

public class NullItem extends AbstractItem {

    @Override
    public String getName() {
        return "请先建立家具模板";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
