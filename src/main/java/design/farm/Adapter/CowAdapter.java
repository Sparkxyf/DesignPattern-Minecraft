package design.farm.Adapter;

public class CowAdapter implements AnimalBuyer {
    private CowBuyer cowBuyer;
    public CowAdapter()
    {
        cowBuyer=new CowBuyer();
    }
    public String buy()
    {
        return cowBuyer.buyCow();
    }
}