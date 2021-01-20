## 1. Single-Responsibility Principle ##
Single responsibility principle states that each class must have only one responsibility. 

### 1.1 Class design without single responsibility principle ###
<img src="img/Single-poor.png">
In this class design, we can see that Employee class is responsible for saveing employee to the database, printing report in XML and CSV and terminating an Employee. 
<br/>

- If the employee database implementation changes then all classes containing database code must be modified including the listed class.

- Requirement changes inside XML and CSV requires changes inside Employee class.

Thus, this class is not following the single responsibility principle

### 1.2 Class design with single responsibility principle ###
<img src="img/Single-good.png">
- In this design DatabaseManager is responsible for managing connection
- EmployeeDao is responsible for save and delete
- EmployeeReportFormatter is responsible for formatting report
- Employee class is normal POJO
<img src="img/Single-good-1.png">

## Example 1 ##
### Example 1.1 code without good single responsibility principle ###
```java
public class Employee{
  private String employeeId;
  private String name;
  private string address; 
  private Date dateOfJoining;
  public boolean isPromotionDueThisYear(){
    //promotion logic implementation
  }
  public Double calcIncomeTaxForCurrentYear(){
    //income tax logic implementation
  }
  //Getters & Setters for all the private attributes
}
```

### Example 1.2 code with good single responsibility principle ###

```java
public class HRPromotions{
  public boolean isPromotionDueThisYear(Employee emp){
    //promotion logic implementation using the employee information passed
  }
}
```

```java
public class FinITCalculations{
  public Double calcIncomeTaxForCurrentYear(Employee emp){
    //income tax logic implementation using the employee information passed
  }
}
```

```java
public class Employee{ 
  private String employeeId;
  private String name;
  private string address; 
  private Date dateOfJoining;
  //Getters & Setters for all the private attributes
}
```