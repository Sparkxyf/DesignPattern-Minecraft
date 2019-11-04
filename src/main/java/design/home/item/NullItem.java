package design.home.item;

public class NullItem extends AbstractItem {

    @Override
    public String getName() {
        return "指定的家具序号无效！";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
