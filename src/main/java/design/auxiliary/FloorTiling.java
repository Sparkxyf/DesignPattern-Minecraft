package design.auxiliary;
import design.home.tile.*;

import java.util.*;
public class FloorTiling {
    private static String[] color_set={"红色","橙色","黄色","绿色","蓝色","紫色","棕色","白色","黑色","粉色"};
    private static String[] texture_set={"横纹","波纹","光滑"};
    private static String[] material_set={"桦木","松木","樟木","瓷砖"};
    private static int houseSize=3;
    int[][] floor_arr = new int[houseSize][houseSize]; //默认初值0
    public void operation(){
        TileFlyweightFactory factory =new TileFlyweightFactory();//后面会用到
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("=============请选择操作===============");
        System.out.println("======================================");
        System.out.println("*            1. 铺设地板             *");
        System.out.println("*          2. 查看所有地板           *");
        System.out.println("*           3. 查看留言版            *");
        System.out.println("*              4. 退出               *");
        System.out.println("======================================");
        floorLoop:
        while(scanner1.hasNext()){
            switch(scanner1.next()){
                case "1":
                    Scanner temp=new Scanner(System.in);
                    System.out.println("选择要铺设地板的坐标(当前房屋大小:"+houseSize+"*"+houseSize+",请输入0~"+houseSize+"间的值)");
                    int floor_x=temp.nextInt();
                    int floor_y=temp.nextInt();
                    if(floor_x >= houseSize || floor_y >= houseSize){
                        System.out.println("超出了当前房间的大小！");
                        break;
                    }
                    if(floor_arr[floor_x][floor_y]==1){
                        System.out.println("("+floor_x+","+floor_y+")的位置已经有地板了。要新建一块地板覆盖它吗？(Y/N)");
                        if(temp.next().equals("N")) {
                            break;
                        }
                    }
                    floor_arr[floor_x][floor_y]=1;//标记已经被使用
                    System.out.println("选择地板的材质：");
                    System.out.println("桦木:0 松木:1 樟木:2 瓷砖:3");
                    int material=temp.nextInt();

                    Tile curr_tile=new Tile(material_set[material],floor_x,floor_y);

                    System.out.println("选择地板的颜色：");
                    System.out.println("红色:0 橙色:1 黄色:2 绿色:3 蓝色:4");
                    System.out.println("紫色:5 棕色:6 白色:7 黑色:8 粉色:9");
                    int color=temp.nextInt();
                    System.out.println("选择地板的花纹：");
                    System.out.println("横纹:0 波纹:1 光滑:2");
                    int texture=temp.nextInt();

                    Property new_property = new Property(texture_set[texture],color_set[color]);
                    TileFlyweightInterface flyweight =factory.getTile(new_property);
                    flyweight.decorate(curr_tile);
                    flyweight.show(curr_tile);
                    break;
                case "2"://打印地板
                    System.out.println("装饰屋子");
                    break;
                case "3":
                    System.out.println("查看留言版");
                    //查看当前-以前
                    break;
                case "4":
                    System.out.println("退出");
                    SweetHome sweetHome=new SweetHome();
                    sweetHome.main();
                    break;
            }
            System.out.println("======================================");
            System.out.println("=============请选择操作===============");
            System.out.println("======================================");
            System.out.println("*            1. 铺设地板             *");
            System.out.println("*          2. 查看所有地板           *");
            System.out.println("*           3. 查看留言版            *");
            System.out.println("*              4. 退出               *");
            System.out.println("======================================");
        }
        scanner1.close();
    }
    public void initialize(){
        //初始化地板



        // System.out.println();

    }
}
