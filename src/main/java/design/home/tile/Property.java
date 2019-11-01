package design.home.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Property {

    @Getter @Setter
    private String texture;

    @Getter @Setter
    private String color;

    //不换行输出
    public void show(){
        if(this.getColor()!=null&&this.getTexture()!=null){
            System.out.print(this.getColor()+this.getTexture());
        }
    }
}
