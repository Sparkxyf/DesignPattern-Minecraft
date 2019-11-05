package design.farm.Adapter;

//目标：买动物
public interface AnimalBuyer
{
    public String buy();
}

//适配者1：买鸡
class ChickenBuyer
{
    public String buyChicken()
    {
        return "chicken";
    }
}
//适配者2：买牛
class CowBuyer
{
    public String buyCow()
    {
        return "cow";
    }
}
