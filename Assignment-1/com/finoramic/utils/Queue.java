package com.finoramic.utils;
public class Queue<T> {
	private class Node{
		T data;
		Node next;
		
//		Node(){
//			this(null, null);
//		}
//		
//		Node(T data){
//			this.data = data;
//		}
		
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public T front() {//throws QueueEmptyException{
		if(this.isEmpty()){
			System.out.println("Queue is empty!");
			return null;
			//throw new QueueEmptyException();
		}
		
		return this.head.data;	
	}
	
	public T dequeue() {//throws QueueEmptyException{
		if(this.isEmpty()){
			System.out.println("Queue is empty!");
			return null;
			//throw new QueueEmptyException();
		}
		
		T retVal = this.head.data;
		
		if(this.size == 1){
			this.head = this.tail = null;
		}
		else{
			this.head = this.head.next;
		}
		
		this.size--;
		
		return retVal;
	}
	
	public void enqueue(T data){
		Node temp = new Node(data, null);
		
		if(this.isEmpty()){
			this.head = temp;
			this.tail = temp;
		}
		else{
			this.tail.next = temp;
			this.tail = temp;
		}
		
		this.size++;
	}
	
	public String toString(){
		String retVal = "";
		
		Node temp = this.head;
		
		while(temp != null){
			retVal += temp.data.toString() + " => ";
			temp = temp.next;
		}
		
		retVal += "Null";
		
		return retVal;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public void reverse(){
		if(this.isEmpty()){
			return;
		}
		
		Node curr = this.head, next = curr.next;
		
		while(curr != null && next != null){
			Node tempCurr = curr;
			Node tempNext = next;
			
			curr = next;
			next = next.next;
			
			tempNext.next = tempCurr;
		}
		
		this.head.next = null;
		
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}
}
