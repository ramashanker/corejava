package datastructure.linkedlist;
//https://www.geeksforgeeks.org/linked-list-set-1-introduction/
public class SimpleLinkedList {
  Node head; // head of list

  /* Linked list Node.  This inner class is made static so that
     main() can access it */
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static void main(String[] args) {
    SimpleLinkedList list= new SimpleLinkedList();
    list.head=new Node(1);
    Node second= new Node(2);
    Node third= new Node(3);
    list.head.next=second;
    second.next=third;
    list.printList();

  }

  public void printList(){
    Node n=head;
    while(n!=null){
      System.out.print(n.data+"-->");
      n=n.next;
    }
  }

}

