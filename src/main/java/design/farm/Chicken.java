package design.farm;

public class Chicken extends Animal {
    @Override
    public String stringify() {
        if(this.state instanceof GrownState) {
            return "成年鸡";
        }
        return "小鸡";
    }
    @Override
    protected void init() {
        grownAge = 3;
        super.init();
    }
}
