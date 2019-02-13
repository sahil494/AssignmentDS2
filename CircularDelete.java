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
    public void deleteBeg()
    {
      if (head==null)
      {
        System.out.println("list is empty");
      }
      else if (head==tail) 
      {
        head=null;
        tail=null;
      }
      else
      {
        head=head.next;
        head.prev=tail;
        tail.next=head;
      } 
    }
    public void deleteEnd()
    {
      if (head==null)
      {
        System.out.println("list is empty");
      }
      else if (head==tail)
      {
        head=null;
        tail=null;
      }
      else
      {
        tail=tail.prev;
        tail.next=head;
        head.prev=tail;
      } 
    }
 public void deleteAtPos(int pos)
  {
    boolean f=false;
    int count=1;
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else
    {
      if(pos==1)
      {
        deleteBeg();
        f=true;
      }
      else
      {
        Node temp=head.next;
        count++;
        while(temp.next!=head)
        {
          if(pos==count)
          {
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            f=true;
          }
          temp=temp.next;
          count++;
        }
        if(pos==count && f==false)
        {
            deleteEnd();
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
class Main
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
    cl.deleteAtPos(3);
    System.out.println("elements after deleting: ");
    cl.traverse();
  }
}