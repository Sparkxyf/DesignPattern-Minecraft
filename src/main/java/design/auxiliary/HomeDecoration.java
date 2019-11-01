package design.auxiliary;

import design.home.decorate.*;
import design.home.tile.Property;
import design.home.tile.Tile;
import design.home.tile.TileFlyweightInterface;

import java.util.Scanner;

public class HomeDecoration {
    private MyHomeInterface MyHome=new OriginalHome();
    public void operation()
    {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("=============请选择操作===============");
        System.out.println("======================================");
        System.out.println("*            1. 查看当前的装饰状态           *");
        System.out.println("*            2. 进行圣诞节主题的装修           *");
        System.out.println("*            3. 进行春节主题的装修            *");
        System.out.println("*            4. 恢复为原始状态               *");
        System.out.println("*            5. 退出               *");
        System.out.println("======================================");

        while(scanner1.hasNext()){
            switch(scanner1.next()){
                case "1":
                    MyHome.show();
                    break;
                case "2":
                    MyHome=new OriginalHome();
                    MyHome= new Christmas(MyHome);
                    System.out.println("装修完成");
                    break;
                case "3":
                    MyHome=new OriginalHome();
                    MyHome=new SpringFestival(MyHome);
                    System.out.println("装修完成");
                    break ;
                case "4":
                    MyHome=new OriginalHome();
                    System.out.println("恢复初始状态完成");
                    break;
                case "5":
                    System.out.println("退出");
                    SweetHome sweetHome=new SweetHome();
                    sweetHome.main();
                    break ;
            }
            System.out.println("======================================");
            System.out.println("=============请选择操作===============");
            System.out.println("======================================");
            System.out.println("*            1. 查看当前的装饰状态           *");
            System.out.println("*            2. 进行圣诞节主题的装修           *");
            System.out.println("*            3. 进行春节主题的装修            *");
            System.out.println("*            4. 恢复为原始状态               *");
            System.out.println("*            5. 退出               *");
            System.out.println("======================================");
        }
        scanner1.close();
    }
}
