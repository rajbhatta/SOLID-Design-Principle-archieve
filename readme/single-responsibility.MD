## S — Single responsibility principle ##
- Single Responsibility Principle states that every module or class should have responsibility over a single part of the functionality provided by the software.

- Let’s do an example of how to write a piece of code that violates this principle.
```java
class User
{
    void CreatePost(Database db, string postMessage)
    {
        try
        {
            db.Add(postMessage);
        }
        catch (Exception ex)
        {
            db.LogError("An error occured: ", ex.ToString());
            File.WriteAllText("\LocalErrors.txt", ex.ToString());
        }
    }
}
```

- We notice how the CreatePost() method has too much responsibility, given that it can both create a new post, log an error in the database, and log an error in a local file.
This violates the single responsibility principle.

```java
class Post
{
    private ErrorLogger errorLogger = new ErrorLogger();

    void CreatePost(Database db, string postMessage)
    {
        try
        {
            db.Add(postMessage);
        }
        catch (Exception ex)
        {
            errorLogger.log(ex.ToString())
        }
    }
}

class ErrorLogger
{
    void log(string error)
    {
      db.LogError("An error occured: ", error);
      File.WriteAllText("\LocalErrors.txt", error);
    }
}
```

- By abstracting the functionality that handles the error logging, we no longer violate the single responsibility principle and we have two classes that each has one responsibility; to create a post and to log an error, respectively.



