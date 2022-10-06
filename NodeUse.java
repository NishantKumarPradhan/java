package demo;
import java.util.Scanner;

public class NodeUse {
	
	public static Node<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer>  head = null, tail = null;
		
		while (data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
		      if (head == null) {
			     head = newNode;
			     tail = newNode;
			
		      }
		      else {
			      
			       tail.next = newNode;
			       
		      }
		      tail = newNode;
		      data = sc.nextInt();
		}
		return head;	
	}
	
	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
		System.out.println();
	}
 
	public static Node<Integer> insert(Node<Integer> head, int data, int pos){
		Node<Integer> newNode = new Node<Integer>(data);
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) {
			temp = temp.next;
			i++;
		}
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
		     newNode.next = temp.next;
		     temp.next = newNode;
		}
		return head;
	}
	
	public static Node<Integer> delete(Node<Integer> head, int pos){
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) {
			temp = temp.next;
			i++;
		}
		if (pos == 0) {
			head = head.next;
		}
		else {
			if (temp.next.next != null) {
				temp.next = temp.next.next;
			}
			else {
				temp.next = null;
			}
		}
		return head;
		
	}
	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		print(head);
		head = insert(head, 80, 3);
		print(head);
		head = delete(head, 2);
		print(head);
		
		
	

	}

}
