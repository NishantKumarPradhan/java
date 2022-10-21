package linkedList;

public class GenericLLBest<T> {
	
	private class Node<T> {
		T data;
		Node<T> next;
		
		Node (T data){
			this.data = data;
			next = null;		
		}
	 }
	 private Node<T> head;
	 private Node<T> tail;
	 private int size;
	 
	 public int size() {
		 return this.size;
	 }
	 
	 //O(n)
	 public void print() {
		 print(this.head);
	 }
	 private void print(Node<T> head) {
		 while (head != null) { 
			 System.out.print(head.data + " ");
			 head = head.next;
		}
			System.out.println();
	 }
	 
	 //O(1)
	 public T getFirst() throws Exception {
		 if (this.size == 0) {
			 throw new Exception("LL is Empty");
		 }
		 return this.head.data; 
	 }
	 
	 //O(1)
	 public T getLast() throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is Empty");
		 }
		 return this.tail.data;
	 }
	 
	 //O(n)
	 public T get(int index) throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is Empty");
		 }
		 if (index < 0 || index >= this.size) {
			 throw new Exception("invalid Index");
		 }
		 
		 Node<T> temp = this.head;
		 for (int  i = 1; i <= index; i++) {
			 temp = temp.next;
		 }
		 return temp.data;
	 }
	 
	 //O(1)
	 public void addFirst(T data) {
		 Node<T> newNode = new Node<>(data);
		 if (size == 0) {
			this.head = newNode;
			this.tail = newNode;
		 }
		 else {
			 newNode.next = this.head;
			 this.head = newNode; 
		 }
		 this.size++;
		 
	 }
	 
	 //O(1)
	 public void addLast(T data) {
		 Node<T> newNode = new Node<>(data);
		 if (size == 0) {
			this.head = newNode;
			this.tail = newNode;
		 }
		 else {
			 tail.next = newNode;
			 tail = newNode;
		 }
		 this.size++;	
	 }
	 
	 //O(n)
	 public void add(int index, T data) throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is empty");
		 }
		 if (index > this.size || index < 0) {
			 throw new Exception("invalid index");
		 }
		 
		 if (index == 0) {
			 addFirst(data);
		 }
		 else if (index == this.size) {
			 addLast(data);
		 }
		 else {
			 Node<T> newNode = new Node<>(data);
			 Node<T> temp = this.head;
			 for (int i = 0; i < index - 1; i++) {
				 temp = temp.next;
			 }
			 newNode.next = temp.next;
			 temp.next = newNode;
			 this.size++;
			 }
	 }
	 
	 //O(1)
	 public T removeFirst() throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is Empty");
		 }
		 T rr = this.head.data;
		 if (size == 1) {
			 this.head = null;
			 this.tail = null;
		 }
		 else {
			 this.head = this.head.next;
		 }
		 this.size--; 
		 return rr;
	 }
	 
	 //O(n)
	 public T removeLast() throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is empty");
		 }
		 T rr = this.tail.data;
		 if (size == 1) {
			 this.head = this.tail = null;
		 }
		 else {
			 Node<T> temp = this.head;
			 for (int i = 0; i < this.size - 2; i++) {
				 temp = temp.next;
			 }
			 temp.next = null;
			 this.tail = temp;
		 }
		 this.size--;
		 return rr;
	 }
	 
	 //O(n)
	 public T removeAt(int index) throws Exception{
		 if (this.size == 0) {
			 throw new Exception("LL is empty");
		 }
		 if (index < 0 || index >= this.size) {
			 throw new Exception("Invalid Index");
		 }
		 
		 if (index == 0) {
			 return removeFirst();
		 }
		 else if (index == this.size - 1) {
			 return removeLast();
		 }
		 else {
			 Node<T> temp = this.head; 
			 for (int i = 0; i < index - 1; i++) {
				 temp = temp.next;
			 }
			 T rr = temp.next.data;
			 temp.next = temp.next.next;
			 this.size--;
			 return rr;
		 }
	 }
  
		  
	  
	 



}
