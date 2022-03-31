package solidpattern.liskov.badv2;

public class AnnualMember extends Member {

    public AnnualMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING ANNUAL MEMBER TO DB");
    }

    @Override
    public void makeBooking() {

    }
}
