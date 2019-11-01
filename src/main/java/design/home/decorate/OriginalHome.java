package design.home.decorate;

public class OriginalHome extends MyHome implements MyHomeInterface {

    public OriginalHome(){
        super("家");
    }


    @Override
    public void show() {
        System.out.println(this.getName());
    }
}
