package design.farm;


import java.util.ArrayList;
import java.util.Scanner;


public class FarmInterfaceImpl implements FarmInterface {

    private ArrayList<FarmLand> farmLandList = new ArrayList<>();

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. 查看所有农场");
        System.out.println("2. 新建农场");
        System.out.println("3. 返回");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    for(int i = 0; i< farmLandList.size(); ++i) {
                        System.out.println(
                                (i + 1) +
                                        ":" +
                                        farmLandList.get(i).stringify());
                    }
                    System.out.println("输入序号查看农场");
                    System.out.println("输入0返回");
                    System.out.println("请选择：");
                    while(scanner.hasNext()) {
                        String next = scanner.next();
                        try {
                            int cmd = Integer.parseInt(next);
                            if(cmd > farmLandList.size() || cmd < 0) {
                                throw new NumberFormatException();
                            }
                            if(cmd != 0){
                                farmLandList.get(cmd-1).exec();
                            }
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("输入有误，请重试。");
                        }
                    }
                    break;
                case "2":
                    System.out.println("输入1创建菜地，2创建牧场");
                    System.out.println("输入0返回");
                    System.out.println("请选择：");
                    if(scanner.hasNext()) {
                        FarmLand newFarmland;
                        switch (scanner.next()) {
                            case "1":
                                newFarmland = Field.creator.create();
                                break;
                            case "2":
                                newFarmland  = Farm.creator.create();
                                break;
                            case "0":
                                continue;
                            default:
                                System.out.println("输入有误");
                                continue;
                        }
                        newFarmland.farms = this;
                        farmLandList.add(newFarmland);
                        System.out.println("添加成功");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("1. 查看所有农场");
            System.out.println("2. 新建农场");
            System.out.println("3. 返回");
            System.out.println("请选择：");
        }
    }
}
