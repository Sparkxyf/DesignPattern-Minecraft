package design.auxiliary;
import design.home.furniture.*;
import design.home.item.*;
import design.home.tile.TileFlyweightFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Furnituring {
    //private static String[] nameSet={"桌子","椅子","书柜","板凳"};
    private static String[] textureSet={"横纹","波纹","光滑"};
    private static String[] typeSet={"木质","铁质","塑料"};
    private static int choice=0;
    private static String furniture="",texture="",type="";
    private static List<Furniture> furnitureList=new ArrayList<>();
    public static ItemFactory itemFactory =new ItemFactory();
    public static FurnitureData furnitureData =new FurnitureData();
    public void operation(){
        TileFlyweightFactory factory =new TileFlyweightFactory();//后面会用到
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("=============请选择操作===============");
        System.out.println("======================================");
        System.out.println("*         1. 自由添加家具             *");
        System.out.println("*            2. 查看家具              *");
        System.out.println("*         3. 显示创建记录             *");
        System.out.println("*    4. 从创建记录为模板新建家具       *");
        System.out.println("*             5. 退出                 *");
        System.out.println("======================================");

        while(scanner1.hasNext()){
            switch(scanner1.next()){
                case "1":
                    Scanner temp=new Scanner(System.in);
                    System.out.println("请输入要加入的家具(桌子/椅子/书柜/板凳)：");
                    String tempStr=temp.next();
                    AbstractItem item1 = itemFactory.getItem(tempStr);

                    if(item1.getName().equals(tempStr)){
                        furniture=tempStr;
                    }
                    else{
                        System.out.println("创建失败！");
                        break;
                    }
                    System.out.println("请选择"+furniture+"的花纹");
                    System.out.println("横纹:0 波纹:1 光滑:2");
                    choice=Integer.parseInt(temp.next());
                    if(checkInArray(choice,new int[]{0,1,2})){
                        texture=textureSet[choice];
                    }
                    else{
                        System.out.println("创建失败！");
                        break;
                    }
                    System.out.println("请选择"+furniture+"的材质");
                    System.out.println("木质:0 铁质:1 塑料:2");
                    choice=Integer.parseInt(temp.next());
                    if(checkInArray(choice,new int[]{0,1,2})){
                        type=typeSet[choice];
                    }
                    else{
                        System.out.println("创建失败！");
                        break;
                    }

                    furnitureList.add(new Furniture(type,texture,furniture));
                    furnitureData.addFurniture(new Furniture(type,texture,furniture));
                    System.out.println("创建了"+type+"的"+texture+furniture);
                    break;
                case "2"://查询
                    temp=new Scanner(System.in);
                    System.out.println("请输入需要查询的关键字(花纹/材质)");
                    String feature=temp.next();
                    Criteria type1 =new CriteriaTypeImpl();
                    if(type1.furnitureList(furnitureList,feature).size()==0){System.out.println("无对应家具！");}
                    else {
                        System.out.println("现有：");
                        for (Furniture furniture1 : type1.furnitureList(furnitureList, feature)) {
                            System.out.println(furniture1.getType() + furniture1.getTexture() + furniture1.getName());
                        }
                    }
                    break;
                case "3":
                    int count=0;
                    for(Furniture furniture: furnitureData.getFurnitureList()){
                        System.out.println(count+":"+furniture.getType()+furniture.getTexture()+furniture.getName());
                        count++;
                    }
                    break;
                case "4":
                    Scanner temp1=new Scanner(System.in);
                    System.out.println("选择要删除的历史记录的编号");
                    try {
                        furnitureData.deleteFurniture(temp1.nextInt());
                    }catch(Exception e){
                        System.out.println("操作失败！");
                    }
                    break;
                 default:
                     SweetHome sweetHome=new SweetHome();
                     sweetHome.main();
            }
            System.out.println("======================================");
            System.out.println("=============请选择操作===============");
            System.out.println("======================================");
            System.out.println("*            1. 新增家具             *");
            System.out.println("*            2. 查看家具             *");
            System.out.println("*         3. 显示创建记录             *");
            System.out.println("*    4. 从创建记录为模板新建家具       *");
            System.out.println("*             5. 退出                 *");
            System.out.println("======================================");
        }
        scanner1.close();
    }

    private boolean checkInArray(int i, int[] arr ){
        for (int k: arr){
            if(i==k) return true;
        }
        return false;
    }
}
