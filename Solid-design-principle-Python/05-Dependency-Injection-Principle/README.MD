# What dependency injection principle states? #
- Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.

# Bad design code #
```java
package com.solidpattern.bad;

public class MySQLConnection {

    public String connect()
    {
        // handle the database connection
        return "Database connection";
    }

}
```

```java
package com.solidpattern.bad;

public class PasswordReminder {

    private MySQLConnection mySQLConnection;

    public PasswordReminder(MySQLConnection mySQLConn) {
        this.mySQLConnection = mySQLConn;
    }
}
```

- First, the <b>MySQLConnection</b> is the low-level module while the <b>PasswordReminder</b> is high level, but according to the definition of <b>D</b> in <b>SOLID</b>, which states to depend on abstraction, not on concretions. This snippet above violates this principle as the <b>PasswordReminder</b> class is being forced to depend on the <b>MySQLConnection class</b>.

- Later, if you were to change the database engine, you would also have to edit the <b>PasswordReminder</b> class, and this would violate the open-close principle.

- The <b>PasswordReminder</b> class should not care what database your application uses. 

# Good design code #
```java
package com.solidpattern.good;

public interface DBConnectionInterface {
    public String connect();
}
```

```java
package com.solidpattern.good;

public class MySQLConnection implements DBConnectionInterface{
    @Override
    public String connect() {
        return "return database";
    }
}
```

```java
package com.solidpattern.good   ;

public class PasswordReminder {

    private DBConnectionInterface mySQLConnection;

    public PasswordReminder(MySQLConnection mySQLConn) {
        this.mySQLConnection = mySQLConn;
    }
}
```

- To address these issues, you can code to an interface since high-level and low-level modules should depend on abstraction.

- The interface has a connect method and the <b>MySQLConnection</b> class implements this interface. Also, instead of directly type-hinting <b>MySQLConnection</b> class in the constructor of the <b>PasswordReminder</b>, you instead type-hint the <b>DBConnectionInterface  and no matter the type of database your application uses, the PasswordReminder class can connect to the database without any problems and open-close principle is not violated.