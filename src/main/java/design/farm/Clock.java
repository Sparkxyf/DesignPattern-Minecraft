package design.farm;

public class Clock extends Observed<Integer> {
    private static Clock instance = new Clock();

    private Clock() {
        state = 0;
    }

    public static Clock getInstance() {
        return instance;
    }

    @Override
    public <K> boolean updateState(K change) {
        if(change instanceof Integer) {
            Integer intChange = (Integer)change;
            state += intChange;
            return true;
        }
        return false;
    }
}
