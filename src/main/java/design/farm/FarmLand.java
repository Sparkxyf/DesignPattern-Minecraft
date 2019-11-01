package design.farm;


public abstract class FarmLand {
    FarmInterfaceImpl farms;

    abstract void exec();

    public abstract String stringify();

    public interface Creator {
        FarmLand create();
    }

}
