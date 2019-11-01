package design.farm;

import lombok.Getter;
import lombok.Setter;

public abstract class Animal {

    Animal() {
        init();
    }

    public abstract String stringify();

    @Setter @Getter
    protected FarmLand belongTo = null;

    @Getter
    private Integer birthDate = Clock.getInstance().getState();

    @Getter
    Integer grownAge = Integer.MAX_VALUE;

    protected State state = new CubState();

    protected void init() {
        Clock.getInstance().addOnUpdateObserver(observed -> {
            Integer time = (Integer)observed.getState();
            if((state instanceof CubState) && (time - birthDate > grownAge)) {
                state = new GrownState();
            }
        });
    }

    void exec() {
        state.exec();
    }

    abstract static class State {
        abstract void exec();
    }

    static class CubState extends State {
        @Override
        void exec() {
            System.out.println("这是一只幼崽");
        }
    }

    static class GrownState extends State {
        @Override
        void exec() {
            System.out.println("这是一只成年动物");
        }
    }

}
