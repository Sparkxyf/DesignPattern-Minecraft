package design.farm;


import java.util.ArrayList;
import java.util.Scanner;


public class FarmInterfaceImpl implements FarmInterface {

    private ArrayList<FarmLand> farmLandList = new ArrayList<>();

    @Override
    public void exec() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("*          1. 查看所有农场            *");
        System.out.println("*            2. 新建农场              *");
        System.out.println("*              3. 退出                *");
        System.out.println("======================================");
        System.out.println("请选择：");

        while(scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":
                    System.out.println("======================================");
                    if(farmLandList.size()==0){
                        System.out.println("*         你的土地上没有农场          *");
                    }
                    else{
                        for(int i = 0; i< farmLandList.size(); ++i) {
                            System.out.println("*          "+
                                    (i + 1) +
                                            ":" +
                                            farmLandList.get(i).stringify()+"          *");
                        }
                    }

                    System.out.println("======================================");
                    System.out.println("*          输入序号查看农场           *");
                    System.out.println("*              输入0退出              *");
                    System.out.println("======================================");
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

                    System.out.println("======================================");
                    System.out.println("*            1. 创建菜地              *");
                    System.out.println("*            2. 创建牧场              *");
                    System.out.println("*              3. 退出                *");
                    System.out.println("======================================");
                    System.out.println("请选择：");
                    if(scanner.hasNext()) {
                        FarmLand newFarmland;
                        switch (scanner.next()) {
                            case "1":
                                newFarmland = FarmlandAbstractFactory.getFactory(Field.class).createFarmland();
                                newFarmland.farms = this;
                                farmLandList.add(newFarmland);
                                System.out.println("添加成功");
                                break;
                            case "2":
                                newFarmland = FarmlandAbstractFactory.getFactory(Farm.class).createFarmland();
                                newFarmland.farms = this;
                                farmLandList.add(newFarmland);
                                System.out.println("添加成功");
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("输入有误");
                                continue;
                        }

                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入有误，请重试。");
            }
            System.out.println("======================================");
            System.out.println("*          1. 查看所有农场            *");
            System.out.println("*            2. 新建农场              *");
            System.out.println("*              3. 退出                *");
            System.out.println("======================================");
            System.out.println("请选择：");
        }
    }
}
