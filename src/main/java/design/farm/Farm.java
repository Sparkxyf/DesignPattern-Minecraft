package design.farm;

import java.util.ArrayList;
import java.util.Scanner;

class Farm extends FarmLand implements Cloneable {

    private ArrayList<Animal> animals = new ArrayList<>();

    private static Farm proto = new Farm();

    @Override
    String stringify() {
        return "有"+animals.size()+"只动物的牧场";
    }

    @Override
    void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. 查看所有动物");
        System.out.println("2. 添加动物");
        System.out.println("3. 返回");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    for(int i = 0; i< animals.size(); ++i) {
                        System.out.println(
                                (i + 1) +
                                        ":" +
                                        animals.get(i).stringify());
                    }
                    System.out.println("输入序号查看动物");
                    System.out.println("输入0返回");
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
                    System.out.println("输入1购买鸡，2购买牛");
                    System.out.println("输入0返回");
                    System.out.println("请选择：");
                    if(scanner.hasNext()) {
                        Animal newAnimal;
                        try {
                            switch (scanner.next()) {
                                case "1":
                                    newAnimal = AbstractFactory.getFactory(Chicken.class).createAnimal(Chicken.class);
                                    break;
                                case "2":
                                    newAnimal = AbstractFactory.getFactory(Cow.class).createAnimal(Cow.class);
                                    break;
                                case "0":
                                    continue;
                                default:
                                    System.out.println("输入有误");
                                    continue;
                            }
                            newAnimal.setBelongTo(this);
                            animals.add(newAnimal);
                            System.out.println("购买成功");
                        }
                        catch (NullPointerException e) {
                            System.out.println("购买失败");
                        }
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("1. 查看所有动物");
            System.out.println("2. 添加动物");
            System.out.println("3. 返回");
            System.out.println("请选择：");
        }
    }

    static Creator creator = () -> {
        try {
            return (Farm)proto.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    };

}
