# What is Liskov Substitution Principle #
- Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

- This means that every subclass or derived class should be substitutable for their base or parent class. To be clear: if a program is referencing base class then reference to a base class can be replaced with a dervied class without affecting the functionality of the program.

# Example #
## 1.1 Code at the initial stage ##
```java
package solidpattern.liskov.bad;

public abstract class Member {

    public Member(String name) {
    }

    public abstract void addToDatabase();
}
```

```java
package solidpattern.liskov.bad;

public class AnnualMember extends Member{

    public AnnualMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING ANNUAL MEMBER TO DB");
    }
}
```

```java
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
```

```java
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
```

```java
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
```

## what will happen if we decided to add one more method ? ##

```java
package solidpattern.liskov.badv2;

public abstract class Member {

    public Member(String name) {
    }

    public abstract void addToDatabase();

    public  abstract void makeBooking() throws Exception;
}
```

```java
package solidpattern.liskov.badv2;

public class LifetimeMember extends Member {

    public LifetimeMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING LIFETIME MEMBER TO DATABASE");
    }

    @Override
    public void makeBooking() {

    }
}
```

```java
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
```

```java
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
```

```java
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
```

# Solution #
## Code when Liskov Substituion principle is obyed ##
```java
package solidpattern.liskov.good;

public interface BookingService {
    public void makeBooking();
}
```

```java
package solidpattern.liskov.good;

public interface DatabaseService {
    public void addToDatabase();
}
```

```java
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
```

```java
package solidpattern.liskov.good;

public class LifetimeMember extends Member {

    public LifetimeMember(String name) {
        super(name);
    }

    @Override
    public void addToDatabase() {
        System.out.println("ADDING LIFETIME MEMBER TO DATABASE");
    }

    @Override
    public void makeBooking() {
        System.out.println("MAKING LIFETIME MEMBER BOOKING");
    }
}
```

```java
package solidpattern.liskov.good;

import javax.xml.crypto.Data;

public class Enquiry implements DatabaseService {

    @Override
    public void addToDatabase() {
        System.out.println("ADDING solidpattern.liskov.bad.Enquiry TO DB");
    }
}
```

```java
package solidpattern.liskov.good;

public abstract class Member implements BookingService, DatabaseService {

    public Member(String name) {
    }

    public abstract void makeBooking();

    public abstract void addToDatabase();
}
```

```java
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
```