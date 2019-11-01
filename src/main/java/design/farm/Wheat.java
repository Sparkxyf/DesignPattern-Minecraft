package design.farm;

public class Wheat extends Plant {
    @Override
    public String stringify() {
        if(this.state instanceof GrownState) {
            return "成熟的小麦";
        }
        return "刚种下的小麦";
    }

    @Override
    protected void init() {
        grownAge = 1;
        super.init();
    }
}
