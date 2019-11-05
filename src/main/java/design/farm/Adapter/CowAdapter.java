package design.farm.Adapter;

public class CowAdapter implements AnimalBuyer {
    private static CowAdapter singleton;
    public static CowAdapter getInstance(){
        if(singleton == null)
            singleton = new CowAdapter();
        return singleton;
    }
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