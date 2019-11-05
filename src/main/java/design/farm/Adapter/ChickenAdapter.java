package design.farm.Adapter;

public class ChickenAdapter implements AnimalBuyer {
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