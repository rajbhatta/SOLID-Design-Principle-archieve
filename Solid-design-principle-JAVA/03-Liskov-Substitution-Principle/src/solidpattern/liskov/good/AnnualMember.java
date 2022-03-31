package solidpattern.liskov.good;

public class AnnualMember extends Member {

    public AnnualMember(String name) {
        super(name);
    }

    public void addToDatabase() {
        System.out.println("ADDING ANNUAL MEMBER TO DB");
    }

    public void makeBooking() {
        System.out.println("MAKING ANNUAL MEMBER BOOKING");
    }
}
