package design.auxiliary;

import design.farm.Clock;
import design.home.room.LivingRoom;

import java.util.Scanner;
import design.home.tile.interceptor.*;
import java.util.*;

public class BedRoom {
    public static void operation(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("是否睡觉并结束今天？(Y/N)");
        if(scanner.next().equals("Y")){
            Business proxy = (Business) JdkProxyExample.bind(new BusinessImpl(), "design.home.tile.interceptor.InterceptorImpl");
            proxy.doBusiness();
        }
        else {
            System.out.println("是否回到客厅？(Y/N)");
            if (scanner.next().equals("Y")) {
                HomeInit.roomVisitor.visit(new LivingRoom());
            } else {
                System.out.println("没有其他操作了，即将强制返回客厅");
                HomeInit.roomVisitor.visit(new LivingRoom());
            }
        }

    }
}
