package solidpattern.liskov.good;

import java.util.ArrayList;
import java.util.List;

public class NexusController {
    public static void main(String [] args) throws Exception {

        List<DatabaseService> databaseMemberList = new ArrayList<>();
        databaseMemberList.add(new LifetimeMember("LIFETIME MEMBER"));
        databaseMemberList.add(new AnnualMember("ANNUAL MEMBER"));
        databaseMemberList.add(new Enquiry());

        for (DatabaseService member:
                databaseMemberList) {
            member.addToDatabase();
        }

        /*
            Since we will be having issue because Enquiry.makeBooking throws error and making enquiry does mean to make booking.
            So this is violating principle of Liskov Substitution principle
         */
        List<Member> memberList = new ArrayList<>();
        memberList.add(new LifetimeMember("LIFETIME MEMBER"));
        memberList.add(new AnnualMember("ANNUAL MEMBER"));
        for (Member member:
                memberList) {
            member.makeBooking();
        }

    }
}
