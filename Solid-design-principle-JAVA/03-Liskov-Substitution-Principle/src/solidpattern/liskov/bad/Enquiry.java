package solidpattern.liskov.bad;

public class Enquiry extends Member{

    public Enquiry(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING solidpattern.liskov.bad.Enquiry TO DB");
    }
}
