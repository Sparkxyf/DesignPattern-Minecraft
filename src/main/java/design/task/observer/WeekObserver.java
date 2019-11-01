package design.task.observer;

public class WeekObserver  extends Observer{

    public WeekObserver(Daily daily){
        this.daily =daily;
        this.daily.attach(this);
    }


    //测试
    @Override
    public void show() {
        int week =daily.getState()%7;
        switch (week) {
            case 0:
                System.out.println("星期天");
                break;
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
        }

    }
    public String returnDay() {
        int week = daily.getState() % 7;
        switch (week) {
            case 0:
                return ("星期天");
            case 1:
                return ("星期一");
            case 2:
                return ("星期二");
            case 3:
                return ("星期三");
            case 4:
                return ("星期四");
            case 5:
                return ("星期五");
            case 6:
                return ("星期六");
            default:
                return("星期一");
        }

    }
}
