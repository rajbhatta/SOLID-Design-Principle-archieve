package solidpattern.liskov.good;

public abstract class Member implements BookingService, DatabaseService {

    public Member(String name) {
    }

    public abstract void makeBooking();

    public abstract void addToDatabase();
}
