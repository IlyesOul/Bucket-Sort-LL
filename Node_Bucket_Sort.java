 import java.util.*;

class Node_Bucket_Sort
{
    static Scanner console = new Scanner(System.in);
    static Node head, tail= null;
    static Node buckets[ ] = new Node[10];
    static int NUM_COUNT = 0;
    public static void main()
    {
        Node buckets[ ] = new Node[10];   
        int n = 0, j =1;

        for (int i=0;  i < buckets.length;  i++)
            buckets[i] = new Node(i);

        //Create while-loop
        do
        {
            System.out.println("Enter a number to add to the linked list (Enter -1 to quit):");
            n = console.nextInt();
            if(n == -1)
            {
                break;
            }
            Node current=new Node(n);

            if(head == null)
            {
                head = current;
                tail = current;
            }else
            {
                tail.setNext(current);
                tail = current;
            }
            NUM_COUNT++;
        }while(n!=-1);
        boolean allFull = false;
        int count = 0;

        while(count!=NUM_COUNT)
        {
            //Distribution pass
            Node current = head;
            int target = -1;
            while(current!=null)
            {
                target = current.getData()%( (int)Math.pow(10, j));
                if(j!=1)
                    target/=(int) Math.pow(10,j-1);

                Node current2 = buckets[target];
                //If it's the first node of the array-element
                if(current2.getNext() == null)
                {
                    current2.setNext(new Node(current.getData()));
                    current2 = current2.getNext();
                }else
                {
                    //If there's already a number in this list
                    while(current2.getNext()!=null)
                    {
                        current2 = current2.getNext();
                    }
                    current2.setNext(new Node(current.getData()));
                }
                current = current.getNext();
            }

            if(target == 0)
                count++;
            //Moving the values from the bucket to the linked-list
            Node current2 = head; 
            int i =0;
            while(i!=buckets.length)
            {
                //We only want to add to the list if this node isn't the first one in it's list (isn't 1-9)
                if(buckets[i].getNext()!=null)
                {
                    current = buckets[i].getNext();
                    while(current!=null)
                    {
                        current2.setData(current.getData());
                        current2 = current2.getNext();
                        current = current.getNext();
                    }
                }
                i++;
            }
            //Printing bucket
            for(i = 0; i<buckets.length; i++)
            {
                current = buckets[i];
                while(current!=null)
                {
                    current = current.getNext();
                }
            }
            //Removing nodes from bucket
            for(i = 0; i<buckets.length; i++)
            {
                current = buckets[i];
                current.setNext(null);
            }
            j++;
        }
        Node current = head;
        while(current!=null)
        {
            System.out.print(current.getData() + " ");
            current=current.getNext();
        }
    }
}