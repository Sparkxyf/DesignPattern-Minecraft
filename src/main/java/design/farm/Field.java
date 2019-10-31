package design.farm;

import java.util.ArrayList;
import java.util.Scanner;

class Field extends FarmLand implements Cloneable {

    private ArrayList<Plant> plants = new ArrayList<>();

    private static Field proto = new Field();

    @Override
    String stringify() {
        return "有"+plants.size()+"株作物的菜地";
    }

    @Override
    void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. 查看所有作物");
        System.out.println("2. 添加作物");
        System.out.println("3. 返回");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    for(int i = 0; i< plants.size(); ++i) {
                        System.out.println(
                                (i + 1) +
                                        ":" +
                                        plants.get(i).stringify());
                    }
                    System.out.println("输入序号查看作物");
                    System.out.println("输入0返回");
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
                    System.out.println("暂时无法添加作物");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("1. 查看所有作物");
            System.out.println("2. 添加作物");
            System.out.println("3. 返回");
            System.out.println("请选择：");
        }
    }

    static Creator creator = () -> {
        try {
            return (Field)proto.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    };

}
