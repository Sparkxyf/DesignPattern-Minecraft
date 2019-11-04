package design.farm;

public class Cow extends Animal {
    @Override
    public String stringify() {
        if(this.state instanceof GrownState) {
            return "成年牛";
        }
        return "小牛";
    }

    @Override
    protected void init() {
        grownAge = 5;
        super.init();
    }
}
