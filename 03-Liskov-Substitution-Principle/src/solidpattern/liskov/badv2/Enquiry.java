package solidpattern.liskov.badv2;

public class Enquiry extends Member {

    public Enquiry(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING solidpattern.liskov.bad.Enquiry TO DB");
    }

    @Override
    public void makeBooking() throws Exception{
        throw new Exception("CAN NOT DO BOOKING WHILE MAKING ENQUIRY");
    }
}
