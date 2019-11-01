package design.home.room;

public class LivingRoom implements Room {
    @Override
    public void show() {

        System.out.println("您现在在客厅里");
    }

    @Override
    public String get() {
        return "客厅";
    }
}
