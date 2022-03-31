package solidpattern.liskov.badv2;

public abstract class Member {

    public Member(String name) {
    }

    public abstract void addToDatabase();

    public  abstract void makeBooking() throws Exception;
}
