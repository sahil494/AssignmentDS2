class Node
{
  int data;
  Node next;
  Node(int data)
  {
    this.data=data;
    this.next=null;
  }
}

class LinkedList
{
  Node head;
  public void insertBegin(int data)
  {
    Node node = new Node(data);
    if (head==null)
    {
      head=node;
    }
    else 
    {
      node.next=head;
      head=node;
    }
  }
  public void insertAtPosition(int data,int pos)
  {
    Node node = new Node(data);
    int n = count(head);
    System.out.println(n);
    if(head==null)
    {
      head=node;
    }
    else if(pos>n)
    {
      System.out.println("Position is greater than the list Size");
    }
    else if(head.next==null)
    {
       head.next=node;
    }
    else if(pos==n) 
    {
       Node temp=head;
       Node temp1=temp;
       while(temp1!=null)
       {
         temp=temp.next;
         temp1 = temp.next;
       }
       node.next = temp1;
       temp.next = node;
    }
    else if(pos==1)
    {
      insertBegin(data);
    }
    else 
    {
      int c=2;
      if(c==pos)
      {
        node.next=head.next.next;
        head.next=node;
      }
      else{
      Node pre=head;
      Node cur = pre;
      while(cur!=null)
      {
         if(c==pos)
         {
           node.next = cur;
           pre.next=node;
           break;
         }
         else 
         {
           pre=pre.next;
           cur=pre.next;
           c++;
         }
      }
      }
    }
  }
 public int count(Node head)
  {
    if (head==null)
    {
      return 0;
    }
    int count=0;
    Node current=head;
    while(current!=null)
    {
      count++;
      current=current.next;
    }
    return count;
  }
  public void deleteBegin()
  {
     if(head==null)
    {
      System.out.println("List Empty");
    }
    else if(head.next==null)
    {
      head=null;
    }
    else 
    {
      head=head.next;
    }
  }
  public void deletePos(int position) 
    { 
        if (head == null) 
        {
          System.out.println("List Empty");
        }
        Node temp = head;  
        if (position == 0) 
        { 
            head = temp.next;   
        } 
        if(position == 1)
        {
          deleteBegin();
        }
        else{
        for (int i=1; temp!=null && i<position-1; i++) 
        {
            temp = temp.next; 
        }
       
        if (temp == null || temp.next == null) 
          {
            System.out.println("Position is greater than size");
          } 
         Node next = temp.next.next; 
         temp.next = next;
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
      while (current!=null)
      {
        System.out.println(current.data);
        current=current.next;
      }
    }
  }
}

class SinglyLinkedList
{
  public static void main(String[] args)
  {
    LinkedList ll = new LinkedList();
    System.out.println("elements are");
    ll.insertBegin(10);
    ll.insertBegin(20);
    ll.insertBegin(30);
    ll.insertBegin(40);
    ll.traverse();
    System.out.println("after inserting at position");
    ll.insertAtPosition(50,3);
    ll.traverse();
    ll.deletePos(2);
    System.out.println("after deleting at position");
    ll.traverse();
  }
}