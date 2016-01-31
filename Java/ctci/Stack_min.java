package ctci;

public class Stack_min {

	Stack data;
	Stack min;
	public Stack_min(){
		data = null;
		min = null;
	}
	
	public void push(int item){
		if(data.empty()){
			data.push(item);
			min.push(item);
		}else{
			data.push(item);
			if(min.peek() <= item){
				min.push(item);
			}
		}
	}
	
	public int pop() throws Throwable{
		if (data.empty()){
			throw new Throwable();
		}
		
		int temp = data.pop();
		if(temp == min.peek()){
			min.pop();
		}
		
		return temp;
	}
}
