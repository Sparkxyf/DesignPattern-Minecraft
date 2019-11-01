package design.home.decorate;

public class Christmas extends Decoration {

    public Christmas(MyHomeInterface myHomeInterface){
        super(myHomeInterface);
    }

    @Override
    public void show() {
        setDecoration();
        super.show();
    }


    public void setDecoration(){
        ((OriginalHome) super.myHomeInterface).setName("圣诞节气氛的家");
    }
}
