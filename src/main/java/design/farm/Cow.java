package design.farm;

public class Cow extends Animal {
    @Override
    String stringify() {
        if(this.state instanceof GrownState) {
            return "成年牛";
        }
        return "小牛";
    }

    @Override
    protected void init() {
        grownAge = 3;
        super.init();
    }
}
