## O — Open/closed principle ##
- In programming, the open/closed principle states that software entities (classes, modules, functions, etc.) should be open for extensions, but closed for modification.

- If you have a general understanding of OOP, you probably already know about polymorphism. 
We can make sure that our code is compliant with the open/closed principle by utilizing inheritance and/or implementing interfaces that enable classes to polymorphically substitute for each other.
This may sound confusing, so let’s do an example that will make it very clear what I mean.

```java
class Post
{
    void CreatePost(Database db, string postMessage)
    {
        if (postMessage.StartsWith("#"))
        {
            db.AddAsTag(postMessage);
        }
        else
        {
            db.Add(postMessage);
        }
    }
}
```

- In this code snippet we need to do something specific whenever a post starts with the character ‘#’.
However, the above implementation violates the open/closed principle in the way this code differs the behavior on the starting letter.
If we later wanted to also include mentions starting with ‘@’, we’d have to modify the class with an extra ‘else if’ in the CreatePost() method.

- Let’s try to make this code compliant with the open/closed principle by simply using inheritance.
```java
class Post
{
    void CreatePost(Database db, string postMessage)
    {
        db.Add(postMessage);
    }
}

class TagPost : Post
{
    override void CreatePost(Database db, string postMessage)
    {
        db.AddAsTag(postMessage);
    }
}
```

- By using inheritance, it is now much easier to create extended behavior to the Post object by overriding the CreatePost() method.
The evaluation of the first character ‘#’ will now be handled elsewhere (probably at a higher level) of our software, and the cool thing is, that if we want to change the way a postMessage is evaluated, we can change the code there, without affecting any of these underlying pieces of behavior
