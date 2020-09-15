## I — Interface segregation principle ##
- Do not add additional functionality to an existing interface by adding new methods. Instead, create a new interface and let your class implement multiple interfaces if needed.

- Let’s look at an example of how to violate the interface segregation principle.
```js
interface IPost
{
    void CreatePost();
}

interface IPostNew
{
    void CreatePost();
    void ReadPost();
}
```

- In this example, let’s pretend that I first have an IPost interface with the signature of a CreatePost() method. 
Later on, I modify this interface by adding a new method ReadPost(), so it becomes like the IPostNew interface.
This is where we violate the interface segregation principle.
Instead, simply create a new interface.

```js
interface IPostCreate
{
    void CreatePost();
}

interface IPostRead
{
    void ReadPost();
}
```

- If any class might need both the CreatePost() method and the ReadPost() method, it will implement both interfaces.
