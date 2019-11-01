package design.home.room;

public interface RoomVisitor {

    public void visit(Bedroom bedroom);
    public void visit(LivingRoom livingRoom);

}
