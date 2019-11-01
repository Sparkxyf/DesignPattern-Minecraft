package design.home.room;

public class Bedroom implements Room{



    @Override
    public String get() {
        return "卧室";
    }

    @Override
    public void show() {

        System.out.println("您现在在卧室里");
    }
}
