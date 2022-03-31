package solidpattern.liskov.badv2;

import java.util.ArrayList;
import java.util.List;

public class NexusController {
    public static void main(String [] args) throws Exception {

        List<Member> memberList = new ArrayList<>();
        memberList.add(new LifetimeMember("LIFETIME MEMBER"));
        memberList.add(new AnnualMember("ANNUAL MEMBER"));
        memberList.add(new Enquiry("A"));

        for (Member member:
             memberList) {
            member.addToDatabase();
        }

        /*
            Since we will be having issue because Enquiry.makeBooking throws error and making enquiry does mean to make booking.
            So this is violating principle of Liskov Substitution principle
         */
        for (Member member:
                memberList) {
            member.makeBooking();
        }

    }
}
