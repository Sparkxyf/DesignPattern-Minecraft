package design.home.room;

public class RoomVisitorImpl  implements RoomVisitor{
    @Override
    public void visit(Bedroom bedroom) {
        bedroom.show();
    }

    @Override
    public void visit(LivingRoom livingRoom) {
        livingRoom.show();
    }
}
