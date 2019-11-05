package design.farm.Adapter;

public class ChickenAdapter implements AnimalBuyer {
    private static ChickenAdapter singleton;
    public static ChickenAdapter getInstance(){
        if(singleton == null)
            singleton = new ChickenAdapter();
        return singleton;
    }
    private ChickenBuyer chickenBuyer;
    public ChickenAdapter()
    {
        chickenBuyer=new ChickenBuyer();
    }
    public String buy()
    {
        return chickenBuyer.buyChicken();
    }
}