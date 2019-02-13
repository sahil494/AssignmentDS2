class Node 
{
  int data;
  Node prev;
  Node next;
  Node(int data)
  {
    this.data=data;
    this.prev=null;
    this.next=null;
  }
}
class CircularLinkedList
{
  Node head;
  Node tail;
  public void insertEnd(int data)
  {
    Node node = new Node(data);
    if (head==null)  
      {
        node.next=node;
        node.prev=node;
        head=node;
        tail=node;
      }
      else
      {
        tail.next=node;
        node.prev=tail;
        node.next=head;
        head.prev=node;
        tail=node;
      } 
  }
  void insertAtPos(int pos,int data)
  {
    Node node=new Node(data);
    boolean f=false;
    int count=1;
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else{
      if(pos==1)
      {
        node.next=head;
        head.prev=node;
        node.prev=tail;
        head=node;
        tail.next=head;
        f=true;
      }
      else
      {
        count++;
        Node temp=head;
        temp=temp.next;
        while(temp.next!=head)
        {
          if(pos==count)
          {
            temp.prev.next=node;
            node.next=temp;
            f=true;
          }
          temp=temp.next;
          count++;
        }
        if(pos==count && f==false)
        {
            temp.prev.next=node;
            node.next=temp;
            f=true;
            count++;
        }
      }
    }
  }
  public void traverse()
    {
      if (head==null)
      {
        System.out.println("list is empty");
      }
      else 
      {
        Node current=head;
        while (current.next!=head)
        {
          System.out.println(current.data);
          current = current.next;
        }
        System.out.println(current.data);
      }
    }
}
class CircularInsert
{
  public static void main(String[] args)
  {
    CircularLinkedList cl = new CircularLinkedList();
    cl.insertEnd(10);
    cl.insertEnd(20);
    cl.insertEnd(30);
    cl.insertEnd(40);
    cl.insertEnd(50);
    System.out.println("elements are: ");
    cl.traverse();
    cl.insertAtPos(4,35);
    System.out.println("elements after inserting: ");
    cl.traverse();
  }
}