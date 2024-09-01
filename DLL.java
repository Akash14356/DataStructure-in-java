public class DLL {
    private Node head;


     

    
    public void insertfirst(int val)
    {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!= null)
        {
            head.prev = node;
        }
        head = node;
    }

    public void display()
    {
        Node node= head;
        while (node !=null) {
            System.out.print(node.val + "->");
            node = node.next;   
        }
        System.out.println("END");
    }


    private class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val)
        {
            this.val = val;

        }
        public Node(int val, Node next, Node prev)
        {
            this.val=val;
            this.next= next;
            this.prev= prev;
        }
    
    }


    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertfirst(3);
        list.insertfirst(2);
        list.insertfirst(8);
        list.insertfirst(17);
        list.display();
    } 
}
