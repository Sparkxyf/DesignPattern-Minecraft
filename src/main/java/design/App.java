package design;


import java.util.*;
import design.auxiliary.*;
import design.farm.Clock;
import design.farm.FarmInterface;
import design.farm.FarmInterfaceImpl;

public class App {

    private static FarmInterface farm = new FarmInterfaceImpl();

    public static void main(String[] args) {

        //@init
        //请在下面写好每个模块必要的初始化函数
        (new HomeInit()).main();

        //到此为止
        App.menu();

    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("======= Welcome to Minecraft! ========");
        System.out.println("======================================");
        System.out.println("*          1. 查看背包物品             *");
        System.out.println("*          2. 进入矿区                 *");
        System.out.println("*          3. 进入农场                 *");
        System.out.println("*          4. 回家                     *");
        System.out.println("*          5. 进入熔炉室               *");
        System.out.println("*          6. 进入任务系统             *");
        System.out.println("*          7. 进入下一天               *");
        System.out.println("*          0. 退出                     *");
        System.out.println("======================================");
        System.out.println("请选择：");


        mainMenuLoop:
        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "0":
                    System.out.println("再见～");
                    break mainMenuLoop;
                case "1":
                    //查看背包物品逻辑
                    break;
                case "2":
                    //进入矿区逻辑
                    break;
                case "3":
                    farm.exec();
                    break;
                case "4":
                    (new SweetHome()).main();
                    break;
                case "5":
                    //熔炉室逻辑
                    break;
                case "6":
                    HomeInit.mission.operation();
                    //任务系统逻辑
                    break;
                case "7":
                    Clock.getInstance().updateState(1);
                    HomeInit.daily.updateState();
                    HomeInit.mission.setDaily();
                    break;
                default:
                    System.out.println("输入不合法，请重试");
//                    try{
//                        Thread.sleep(1000);
//                    }catch(Exception e){
//                        System.exit(0);//退出程序
//                    }
            }

            System.out.println("======================================");
            System.out.println("*          1. 查看背包物品             *");
            System.out.println("*          2. 进入矿区                 *");
            System.out.println("*          3. 进入农场                 *");
            System.out.println("*          4. 回家                     *");
            System.out.println("*          5. 进入熔炉室               *");
            System.out.println("*          6. 进入任务系统             *");
            System.out.println("*          7. 进入下一天               *");
            System.out.println("*          0. 退出                     *");
            System.out.println("======================================");
            System.out.println("请选择：");
        }

        scanner.close();
    }
}