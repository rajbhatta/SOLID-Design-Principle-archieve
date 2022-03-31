package solidpattern.liskov.badv2;

public class LifetimeMember extends Member {

    public LifetimeMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING LIFETIME MEMBER TO DATABASE");
    }

    @Override
    public void makeBooking() {

    }
}
