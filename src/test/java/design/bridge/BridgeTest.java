package design.bridge;

import design.mine.trolley.*;
import org.junit.Test;

public class BridgeTest {

    @Test
    public void testBigCopperTrolley(){
        Type type = new CopperType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testBigIronTrolley(){
        Type type = new IronType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testBigDiamondTrolley(){
        Type type = new DiamondType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testBigAluminumTrolley(){
        Type type = new AluminumType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testSmallCopperTrolley(){
        Type type = new CopperType();
        Trolley trolley = new SmallTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testSmallIronTrolley(){
        Type type = new IronType();
        Trolley trolley = new SmallTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testSmallDiamondTrolley(){
        Type type = new DiamondType();
        Trolley trolley = new SmallTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }

    @Test
    public void testSmallAluminumTrolley(){
        Type type = new AluminumType();
        Trolley trolley = new SmallTrolley();
        trolley.setType(type);
        String name = trolley.getSize();
        System.out.println("当前玩家选择的矿车为：");
        System.out.println(name);
    }
}
