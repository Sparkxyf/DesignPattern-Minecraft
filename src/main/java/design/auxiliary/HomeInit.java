package design.auxiliary;

public class HomeInit {
    public static FloorTiling floorTiling =new FloorTiling();
    public static HomeDecoration homeDecoration=new HomeDecoration();
    public static MemoBoard memoBoard=new MemoBoard();

    public static void main() {
        (new FloorTiling()).initialize();
        FloorTiling floorTiling =new FloorTiling();
        HomeDecoration homeDecoration=new HomeDecoration();

    }
}
