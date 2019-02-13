class Node 
{
  int data;
  Node pre;
  Node next;
  Node(int data)
  {
    this.data = data;
    this.pre=null;
    this.next=null;
  }
}
class DoubleList 
{
  Node head;
  Node tail;
  public void insertBegin(int data)
  {
    Node newnode = new Node(data);
     if(head==null)
     {
       head=newnode;
       tail=newnode;
     }
     else 
     {
       head.pre=newnode;
       newnode.next = head;
       head=newnode;
       
     }
  }
  public void insertEnd(int data)
  {
    Node newnode = new Node(data);
     if(head==null)
     {
       head=newnode;
       tail=newnode;
     }
     else 
     {
       tail.next = newnode;
       newnode.pre=tail;
       tail=newnode;
     }
  }
  public void traverse()
  {
     if(head==null)
     {
       System.out.println("List Empty");
     }
     else 
     {
       Node temp = head;
       while(temp!=null)
       {
         System.out.println(temp.data);
         temp=temp.next;
       }
     }
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
       tail=null;
     }
     else 
     {
       head= head.next;
       head.next.pre=null;
     }
  }
  public void deleteEnd()
  {
    if(head==null)
     {
       System.out.println("List Empty");
     }
     else if(head.next==null)
     {
       head=null;
       tail=null;
     }
     else 
     {
       tail.pre.next=null;
       tail=tail.pre;
     }
  }
  public void insertPos(int data,int pos)
  {
    Node newnode = new Node(data);
    
    int n = count(head);
    
    if(head==null)
    {
      head=newnode;
    }
    else if(pos==1)
    {
      insertBegin(data);
    }
    else if(pos==(n+1))
    {
      insertEnd(data);
    }
    else if(pos==n)
    {
      tail.pre = newnode;
      newnode.next = tail;
      newnode.pre = tail.pre;
      tail.pre.next = newnode;
      
    }
    else if(pos>n)
    {
      System.out.println("Position is greater than size");
    }
    else 
    {
      int c=2;
     Node temp1 = head;
     Node temp2 = temp1.next;
       while(temp2.next!=null)
       {
          if(c==pos)
          {
            temp2.pre = newnode;
            newnode.next = temp2;
            
            newnode.pre = temp1;
            temp1.next = newnode;
             break;
          }
          else 
          {
            temp1= temp1.next;
            temp2=temp2.next;
            c++;
          }
       }
    }
  }
  public int count(Node head)
  {
    int c=0;
    Node temp = head;
    while(temp!=null)
    {
      c++;
      temp=temp.next;
    }
    return c;
  }
  public void deletePos(int pos)
  {
    int size= count(head);
     if(head==null)
     {
       System.out.println  ("List Empty");
     }
     else if(head.next==null)
     {
       head=null;
       tail=null;
     }
     else if(pos==1)
     {
       deleteBegin();
     }
     else if(pos==size)
     {
       deleteEnd();
     }
     else 
     {
       Node temp=head;
       for (int i=1; temp!=null && i<pos-1; i++) 
        {
            temp = temp.next; 
        }
       
        if (temp == null || temp.next == null) 
          {
            System.out.println("Position is greater than size");
          } 
         Node n = temp.next.next; 
         temp.next = n.next;
         n.next.pre = temp;
     }
  }
}
class Main 
{
  public static void main(String args[])
  {
         DoubleList d = new DoubleList();
         System.out.println("Insert At Begin");
         d.insertBegin(10);
         d.insertBegin(20);
         d.insertBegin(30);
          d.insertBegin(40);
           d.insertBegin(50);
         d.traverse();
         System.out.println();
          System.out.println("Insert At Any Position : ");
          d.insertPos(5,3);
          d.traverse();
          System.out.println();
          System.out.println("Delete from any position :");
          d.deletePos(8);
          d.traverse();
  }
}