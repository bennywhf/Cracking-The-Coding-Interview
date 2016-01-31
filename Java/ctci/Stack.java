package ctci;

public class Stack {
	Node top;

	public Stack(){
		top = null;
	}
	public int pop() throws Throwable{
		if(top != null){
			int item = top.data;
			top = top.next;
			return item;
		}
		throw new Throwable();
	}
	
	public void push(int item){
		Node newtop = new Node(item);
		newtop.next = top;
		top = newtop;
	}
	
	public int peek(){
		return top.data;
	}
	
	public boolean empty(){
		if (top == null) return true;
		return false;
	}
}