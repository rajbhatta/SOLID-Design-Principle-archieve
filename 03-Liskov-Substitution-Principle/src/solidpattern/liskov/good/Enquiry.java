package solidpattern.liskov.good;

import javax.xml.crypto.Data;

public class Enquiry implements DatabaseService {

    @Override
    public void addToDatabase() {
        System.out.println("ADDING solidpattern.liskov.bad.Enquiry TO DB");
    }
}
