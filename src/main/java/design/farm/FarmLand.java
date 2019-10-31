package design.farm;


abstract class FarmLand {
    FarmInterfaceImpl farms;

    abstract void exec();

    abstract String stringify();

    public interface Creator {
        FarmLand create();
    }

}
