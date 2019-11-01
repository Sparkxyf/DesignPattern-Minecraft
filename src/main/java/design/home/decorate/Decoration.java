package design.home.decorate;

public class Decoration implements MyHomeInterface {
    MyHomeInterface myHomeInterface;

    public Decoration(MyHomeInterface myHomeInterface){
        this.myHomeInterface = myHomeInterface;
    }

    @Override
    public void show() {
        myHomeInterface.show();
    }
}
