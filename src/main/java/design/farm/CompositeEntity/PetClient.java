package design.farm.CompositeEntity;

public class PetClient {
    private CompositeEntity compositeEntity = new CompositeEntity();

    public void printPetsName(){
        for (int i = 0; i < compositeEntity.getPetsName().length; i++) {
            if(i==0){
                System.out.println("狗狗"+compositeEntity.getPetsName()[i]+"转头看了看你，不想理你。");
            }
            else{
                System.out.println("猫猫"+compositeEntity.getPetsName()[i]+"甚至不转头看你。");
            }
        }
    }

    public void setPetsName(String data1, String data2){
        compositeEntity.setPetsName(data1, data2);
    }
}

