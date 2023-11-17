public class Node
{
    private int data;
    private Node next;

    public Node()
    {
        this(0);
    }
    public Node(int d)
    {
        data=d; 
        next=null;
    }
    // -------------------------------
    public int getData()
    {
        return data;
    }
    public void setData(int i)
    {
        data = i;
    }
    // ------------------------
    public Node getNext()
    {
        return next;
    }  
    public void setNext(Node n)
    {
        next=n;
    }
    
    
}  // Node

