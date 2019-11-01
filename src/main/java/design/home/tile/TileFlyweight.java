package design.home.tile;

public class TileFlyweight implements TileFlyweightInterface {



    private Property property;

    TileFlyweight(Property property) {
        this.property = property;
        System.out.print("创建");
        property.show();
        System.out.println("地板");
    }

    /** {@inheritDoc} */
    @Override
    public void decorate(Tile tile) {
        System.out.println("在位置("
                + tile.getLocationX()+","+tile.getLocationY()+")"
                +"铺上"
                +property.getColor()+property.getTexture()
                +"的"+tile.getMaterial()+"地板"
        );
    }

    /** {@inheritDoc} */
    @Override
    public void show(Tile tile){

        if(this.property!=null) {
            System.out.print("位置("
                    + tile.getLocationX() + "," + tile.getLocationY() + ")"
                    + "是"
            );

            property.show();
            System.out.println(tile.getMaterial() + "地板");
        }else {
            System.out.println("位置("
                    + tile.getLocationX() + "," + tile.getLocationY() + ")"
                    + "是"
                    +tile.getMaterial() + "地板"
            );
        }
    }
}
