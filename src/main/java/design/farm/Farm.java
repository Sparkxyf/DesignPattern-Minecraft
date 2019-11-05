package design.farm;

import design.farm.Adapter.AnimalBuyer;
import design.farm.Adapter.ChickenAdapter;
import design.farm.Adapter.CowAdapter;

import java.util.ArrayList;
import java.util.Scanner;
public class Farm extends FarmLand implements Cloneable {

    public ArrayList<Animal> animals = new ArrayList<>();

    private static Farm proto = new Farm();

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public AnimalBuyer animalBuyer;

    public void setBuyer(String animal){
        if(animal.equals("chicken")){
            animalBuyer = ChickenAdapter.getInstance();
        }
        else{
            animalBuyer = CowAdapter.getInstance();
        }
    }

    @Override
    public String stringify() {
        return "有"+animals.size()+"只动物的牧场";
    }

    @Override
    void exec() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("======================================");
        System.out.println("*          1. 查看所有动物            *");
        System.out.println("*            2. 添加动物              *");
        System.out.println("*              3. 退出                *");
        System.out.println("======================================");
        System.out.println("请选择：");


        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    System.out.println("======================================");
                    for(int i = 0; i< animals.size(); ++i) {
                        System.out.println("*                "+
                                (i + 1) +
                                        ":" +
                                        animals.get(i).stringify()+"                *");
                    }
                    System.out.println("======================================");
                    System.out.println("*          输入序号查看动物           *");
                    System.out.println("*              输入0返回              *");
                    System.out.println("======================================");
                    System.out.println("请选择：");

                    while(scanner.hasNext()) {
                        String next = scanner.next();
                        try {
                            int cmd = Integer.parseInt(next);
                            if(cmd > animals.size() || cmd < 0) {
                                throw new NumberFormatException();
                            }
                            if(cmd != 0){
                                animals.get(cmd-1).exec();
                            }
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("输入有误，请重试。");
                        }
                    }
                    break;
                case "2":
                    if(animalBuyer.buy().equals("chicken")){
                        Animal newAnimal = AbstractFactory.getFactory(Chicken.class).createAnimal(Chicken.class);
                        newAnimal.setBelongTo(this);
                        animals.add(newAnimal);
                        System.out.println("购买成功");
                    }
                    else{
                        Animal newAnimal = AbstractFactory.getFactory(Cow.class).createAnimal(Cow.class);
                        newAnimal.setBelongTo(this);
                        animals.add(newAnimal);
                        System.out.println("购买成功");
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("======================================");
            System.out.println("*          1. 查看所有动物            *");
            System.out.println("*            2. 添加动物              *");
            System.out.println("*              3. 退出                *");
            System.out.println("======================================");
            System.out.println("请选择：");
        }
    }

    static Creator creator = () -> {
        try {
            Farm newFarm = (Farm)proto.clone();
            ArrayList<Animal> newAnimals = new ArrayList<>();
            newFarm.setAnimals(newAnimals);
            return newFarm;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    };

}
