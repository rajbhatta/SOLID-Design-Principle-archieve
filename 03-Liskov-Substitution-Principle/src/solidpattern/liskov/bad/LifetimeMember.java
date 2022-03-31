package solidpattern.liskov.bad;

public class LifetimeMember extends Member{

    public LifetimeMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING LIFETIME MEMBER TO DATABASE");
    }
}
