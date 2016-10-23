package dbo.oqp;

public class Link  {
    public Person Data;
    public Link next;
    public Link prev;
    public Link(Person human) { Data = human; }
}