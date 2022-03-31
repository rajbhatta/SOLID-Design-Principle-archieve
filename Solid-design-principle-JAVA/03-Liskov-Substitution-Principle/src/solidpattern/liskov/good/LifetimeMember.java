package solidpattern.liskov.good;

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
        System.out.println("MAKING LIFETIME MEMBER BOOKING");
    }
}
