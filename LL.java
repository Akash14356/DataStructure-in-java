// package DSA.akash;
public class LL {

    private Node head;
    private Node tail;
    private int size;


    public LL()
    {
        this.size = 0;
    }

    public void insertfirst(int val)
    {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail==null)
        {
            tail = head;
        }
        size+=1;
    }

    public void insertLast(int val)
    {
        if(tail == null)
        {
            insertfirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next =node;
        tail = node;
        size++;
    }

    public void insert(int val, int index)
    {
        if(index==0){
            insertfirst(val);
            return;
        }
        if (index==size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;   
        }
        Node node = new Node( val , temp.next);
        temp.next = node;
        size++;
    }



    public void insertRec(int val, int index)
    {
        head = insertRec(val, index, head);   
    }
    private Node insertRec(int val, int index,Node node)
    {
        if(index ==0)
        {
            Node temp =new Node(val,node);
            size++;
            return temp;
        }

        node.next=insertRec(val, index--, node);
        return node;
        
    }



    public int deletefirst()
    {
        int val = head.value;
        head = head.next;
        if(head == null)
        {
            tail = null;
        }
        size--;
        return val;

    }

    public int deleteLast()
    {
        if(size <=1)
        {
            return deletefirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
         
        tail = secondLast;
        secondLast.next = null;


         return val;
    }

    public int delete(int index)
    {
        if(index == 0)
        {
            return deletefirst();

        }
        if(index == size -1)
        {
            return deleteLast();
        }

        Node prev = get(index -1);
        
        int val  =  prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value)
    {

        Node node = head;
        while (node != null) {
            if(node.value == value)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    public Node get(int index)
    {
        Node node = head;
        for(int i =0;i<index;i++)
        {
            node = node.next;
        }
        return node;
    }

    public void display()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("end");
    }


    private  class  Node{
        private  int value;
        private Node next;

        public Node(int value)
        {  
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(34);


        LL list = new LL();
        list.insertfirst(3);
        list.insertfirst(2);
        list.insertfirst(8);
        list.insertfirst(17);
        list.insertLast(99);
        list.insert(39,2 );
        System.out.println(list.deletefirst());
        list.display();

        System.out.println(list.deleteLast());
        list.display();

        System.out.println(list.delete(2));
        list.display();

        System.out.println(list.find(3));
    }
}
