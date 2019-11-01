package design.home.tile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter @Setter
public class Tile {

    private String material;

    private int locationX;

    private int locationY;
}
