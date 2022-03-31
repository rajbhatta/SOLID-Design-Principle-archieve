package solidpattern.liskov.bad;

import java.util.ArrayList;
import java.util.List;

public class NexusController {
    public static void main(String [] args){

        List<Member> memberList = new ArrayList<>();
        memberList.add(new LifetimeMember("LIFETIME MEMBER"));
        memberList.add(new AnnualMember("ANNUAL MEMBER"));
        memberList.add(new Enquiry("A"));

        for (Member member:
             memberList) {
            member.addToDatabase();
        }

    }
}
