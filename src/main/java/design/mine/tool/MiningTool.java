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

    public void show(){
        System.out.println("该工具的名称被设置为：" + name);
        System.out.println("该工具的耐久度被设置为：" + durability);
    }
}
