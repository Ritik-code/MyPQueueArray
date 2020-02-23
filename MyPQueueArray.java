package stark;

class Element
{
    int data;
    int priority;

    public Element(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}
public class MyPQueueArray {
    int front;
    int rear;
    Element []arr;

    public MyPQueueArray(int size)
    {
        front = -1;
        rear = -1;
        arr = new Element[size];
    }
    public boolean isEmpty()
    {
        return front == -1;
    }
    public boolean isFull()
    {
        return  rear == arr.length-1;
    }
    public void enqueue(Element newelement)
    {
        int i;
        if(arr == null)
        {
            System.out.println("Queue not created.");
            return;
        }
        if(!isFull())
        {
            if(!isEmpty())
            {
                for(i=rear; i>=front; i--)
                {
                    if(newelement.priority < arr[i].priority)
                    {
                        arr[i+1] = arr[i];
                    }
                    else
                    {
                        break;
                    }
                }
                arr[++i]  = newelement;
                System.out.println("Element Inserted.");
                rear++;
            }
            else
            {
                front++;
                rear++;
                arr[rear] = newelement;
                System.out.println("Element Inserted.");
            }
        }
        else
        {
            System.out.println("Queue Overflow.");
        }
    }
    public void dequeue()
    {
        if(!isEmpty())
        {
            System.out.println("Element "+arr[front].data+" deleted.");
            front++;
            if(front>rear)
            {
                front = -1;
                rear = -1;
            }
        }
        else
        {
            System.out.println("Queue Underflow.");
        }
    }
}

class MyPQueueArrayMain
{
    public static void main(String[] args) {
        Element e1 = new Element(10,5);
        Element e2 = new Element(20,4);
        Element e3 = new Element(30,3);
        Element e4 = new Element(40,1);
        Element e5 = new Element(50,2);
        MyPQueueArray obj1 = new MyPQueueArray(10);
        System.out.println(obj1.isEmpty());
        System.out.println(obj1.isFull());
        obj1.enqueue(e1);
        obj1.enqueue(e2);
        obj1.enqueue(e3);
        obj1.enqueue(e4);
        obj1.enqueue(e5);
        System.out.println(obj1.isEmpty());
        System.out.println(obj1.isFull());
        obj1.enqueue(e5);
        obj1.dequeue();
        obj1.dequeue();
    }
}

