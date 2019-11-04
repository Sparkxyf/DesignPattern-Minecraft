package design.farm;

import lombok.Getter;
import lombok.Setter;

public abstract class Plant {
    Plant() {
        init();
    }

    @Setter
    @Getter
    protected FarmLand belongTo = null;

    public abstract String stringify();

    private Integer birthDate = Clock.getInstance().getState();

    Integer grownAge = Integer.MAX_VALUE;

    protected State state = new SeedlingState();

    protected void init() {
        Clock.getInstance().addOnUpdateObserver(observed -> {
            Integer time = (Integer)observed.getState();
            if((state instanceof SeedlingState) && (time - birthDate > grownAge)) {
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

    static class SeedlingState extends Plant.State {
        @Override
        void exec() {

        }
    }

    static class GrownState extends Plant.State {
        @Override
        void exec() {

        }
    }
}
