package design.farm;

import java.util.ArrayList;
import java.util.Scanner;

public class Field extends FarmLand implements Cloneable {

    private ArrayList<Plant> plants = new ArrayList<>();

    private static Field proto = new Field();
    @Override
    public String stringify() {
        return "有"+plants.size()+"株作物的菜地";
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    @Override
    void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("*          1. 查看所有作物            *");
        System.out.println("*            2. 添加作物              *");
        System.out.println("*              3. 退出                *");
        System.out.println("======================================");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    System.out.println("======================================");
                    for(int i = 0; i< plants.size(); ++i) {
                        System.out.println("*               "+
                                (i + 1) +
                                        ":" +
                                        plants.get(i).stringify()+"               *");
                    }
                    System.out.println("======================================");
                    System.out.println("*          输入序号查看作物           *");
                    System.out.println("*              输入0返回              *");
                    System.out.println("======================================");
                    System.out.println("请选择：");
                    while(scanner.hasNext()) {
                        String next = scanner.next();
                        try {
                            int cmd = Integer.parseInt(next);
                            if(cmd > plants.size() || cmd < 0) {
                                throw new NumberFormatException();
                            }
                            if(cmd != 0){
                                plants.get(cmd-1).exec();
                            }
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("输入有误，请重试。");
                        }
                    }
                    break;
                case "2":
                    System.out.println("======================================");
                    System.out.println("*             1. 种茄子               *");
                    System.out.println("*             2. 种小麦               *");
                    System.out.println("*              3. 返回                *");
                    System.out.println("======================================");
                    System.out.println("请选择：");
                    if(scanner.hasNext()) {
                        Plant newPlant;
                        try {
                            switch (scanner.next()) {
                                case "1":
                                    newPlant = AbstractFactory.getFactory(Eggplant.class).createPlant(Eggplant.class);
                                    newPlant.setBelongTo(this);
                                    plants.add(newPlant);
                                    System.out.println("购买成功");
                                    break;
                                case "2":
                                    newPlant = AbstractFactory.getFactory(Wheat.class).createPlant(Wheat.class);
                                    newPlant.setBelongTo(this);
                                    plants.add(newPlant);
                                    System.out.println("购买成功");
                                    break;
                                case "3":
                                    break;
                                default:
                                    System.out.println("输入有误");
                                    continue;
                            }

                        }
                        catch (NullPointerException e) {
                            System.out.println("购买失败");
                        }
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("======================================");
            System.out.println("*          1. 查看所有作物            *");
            System.out.println("*            2. 添加作物              *");
            System.out.println("*              3. 退出                *");
            System.out.println("======================================");
            System.out.println("请选择：");
        }
    }

    static Creator creator = () -> {
        try {
            Field newFarm = (Field)proto.clone();
            ArrayList<Plant> newPlants = new ArrayList<>();
            newFarm.setPlants(newPlants);
            return newFarm;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    };
    public Field Clone(){
        try {
            Field newFarm = (Field)proto.clone();
            ArrayList<Plant> newPlants = new ArrayList<>();
            newFarm.setPlants(newPlants);
            return newFarm;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
