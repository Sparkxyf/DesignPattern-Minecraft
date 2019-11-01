package design.farm;

public class Eggplant extends Plant {
    @Override
    public String stringify() {
        if(this.state instanceof GrownState) {
            return "大茄子";
        }
        return "小茄子";
    }

    @Override
    protected void init() {
        grownAge = 2;
        super.init();
    }
}
