package design.auxiliary;

import java.util.Scanner;

public class Mission {
    private String[] missionSet={"给房间铺上木地板","进行圣诞节风格的装修","进行春节风格的装修"};
    private int mission=1;
    private static String[] weatherSet={"晴朗","多云","下雨"};
    private  String weather ="晴朗";
    private  String weekdays="星期一";
    private String description="";
    private String festival="";


    public void setDaily(){
       weather=weatherSet[getRandom(3)];
       mission =getRandom(missionSet.length) ;
    }
    public void operation(){
        weekdays=HomeInit.weekObserver.returnDay();//打印当前日期

        description=weather+"的"+weekdays;
        //System.out.println(description);
        if(HomeInit.taskDetail.free(description)){
            System.out.println("今日任务："+missionSet[mission]);
            System.out.println("是否进行今日任务？ （Y/N)");
            Scanner scanner=new Scanner(System.in);
            if(scanner.next().equals("Y")){
                switch (mission){
                    case 0:
                        HomeInit.floorTiling.operation();
                    case 1:
                        HomeInit.homeDecoration.operation();
                    case 2:
                        HomeInit.homeDecoration.operation();
                }
            }
        }
    }


    private int getRandom(int num){
        final long l = System.currentTimeMillis();
        return (int)(l%num);
    }
}
