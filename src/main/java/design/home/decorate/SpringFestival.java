package design.home.decorate;

public class SpringFestival extends Decoration {

    public SpringFestival(MyHomeInterface myHomeInterface){
        super(myHomeInterface);
    }

    @Override
    public void show() {
        setDecoration();
        super.show();
    }


    public void setDecoration(){
        ((OriginalHome) super.myHomeInterface).setName("春节气氛的家");
    }
}
