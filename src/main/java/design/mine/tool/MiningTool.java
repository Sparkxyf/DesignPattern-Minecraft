package design.mine.tool;

public class MiningTool {
    private String name;
    private int durability;

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int d){
        durability = d;
    }
}
