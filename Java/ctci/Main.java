package ctci;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[]){
	/*	int items[] = {1,5,3,5,1};
		Node a = createLL(items);

		System.out.println(palindrome(a));
	}
	
	public static void printLL(Node head){
		Node ptr = head;
		
		String s = "[";
		while(ptr != null){
			s = s+Integer.toString(ptr.data)+',';
			ptr = ptr.next;
		}
		s = s.substring(0, s.length()-1) + ']';
		
		System.out.println(s);*/
	
	}

	//PROBLEM 2.1
	public static void RemoveDuplicate(Node head){
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		boolean stay = false;
		Node ptr = head;
		//if this is an empty Linked List, then just end;
		if (ptr == null){
			return;
		}
		//add the first element as an entry in the map;
		map.put(ptr.data,true);
		
		//check every node after the first for duplicates.
		while(ptr.next != null){
			if(map.containsKey(ptr.next.data)){
				//we just saw a duplicate
				ptr.next = ptr.next.next;
				stay = true;
			}else{
				//first time we see item
				map.put(ptr.next.data,true);
			}
		if(!stay){
			ptr = ptr.next;
		}
		stay = false;
		}
	}
	
	//PROBLEM 2.1 FOLLOWUP
	public static void RemoveDuplicate2(Node head){
		if(head == null) return;
		if(head.next == null) return;
		
		Node ptr1 = head;
		Node ptr2 = head;
		
		boolean stay = false;
		while(ptr1.next != null){
			while(ptr2.next != null){
				if(ptr2.next.data == ptr1.data){
					ptr2.next = ptr2.next.next;
					stay = true;
				}
				if (!stay) ptr2 = ptr2.next;
				stay = false;
			}
			if(ptr1.next != null){
				ptr1 = ptr1.next;
				ptr2 = ptr1;
			}
		}
	}
	
	//PROBLEM 2.2
	public static int KthItem(Node head, int k) throws Throwable{
		Node ptr1 = head;
		Node ptr2 = head;
		
		for(int i = 0; i < k; i++){
			if(ptr2.next != null){
				ptr2 = ptr2.next;
			}else{
				throw new Throwable();
			}
		}
		
		while(ptr2.next != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		return ptr1.data;
	}
	
	//PROBLEM 2.3
	public static void deleteNodeInLL(Node midNode){
		//since node is a middle node, node.next != null
		
		//copy data from next node.
		midNode.data = midNode.next.data;
		//remove next node.
		midNode.next = midNode.next.next;
	}
	
	//PROBLEM 2.4
	public static Node partition(Node head, int value){
		Node LT = null;
		Node GT = null;
		Node ptr;
		if(head != null){
			ptr = head;
		}else{
			return null;
		}
		
		while(ptr != null){
			if (ptr.data < value){
				if (LT == null){
					LT = new Node(ptr.data);
				}else{
					LT.appendToTail(ptr.data);
				}
			}else{
				if(GT == null){
					GT = new Node(ptr.data);
				}else{
					GT.appendToTail(ptr.data);
				}
			}
			ptr = ptr.next;
		}
		
		ptr = LT;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		
		ptr.next = GT;
		
		return LT;
	}
	
	//PROBLEM 2.5
	public static Node add(Node a, Node b){
		int Carry = 0;
		Node result = null;
		
		Node ptr1 = a;
		Node ptr2 = b;
		
		while(ptr1 != null && ptr2 != null){
			int sum = ptr1.data + ptr2.data + Carry;
			if(result == null){
				result = new Node(sum%10);
			}else{
				result.appendToTail(sum%10);
			}
			Carry = (sum - sum%10)/10;
			
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		while(ptr1 != null){
			int sum = ptr1.data + Carry;
			result.appendToTail(sum%10);
			Carry = (sum - sum%10)/10;
			ptr1 = ptr1.next;
		}
		
		while(ptr2 != null){
			int sum = ptr2.data + Carry;
			result.appendToTail(sum%10);
			Carry = (sum - sum%10)/10;
			ptr2 = ptr2.next;
		}
		
		if (Carry != 0){
			result.appendToTail(Carry);
		}
		
		return result;
		
		
	}
	
	
	//PROBLEM 2.6
	
	public static int circularhead(Node head){
		//keep track of what I have seen
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		
		Node ptr = head;
		
		while(true){
			if(map.containsKey(ptr.data)){
				return ptr.data;
			}else{
				map.put(ptr.data,true);
			}
			ptr = ptr.next;
		}
	}
	
	//PROBLEM 2.7
	public static boolean palindrome(Node head){
		Node ptr = head;
		Node reverse = null;
		
		if (head == null)
			return true;
		//make a reverse linked list;
		while(ptr != null){
			Node newnode = new Node(ptr.data);
			newnode.next = reverse;
			reverse = newnode;
			ptr = ptr.next;
		}
		
		ptr = head;
		Node ptr2 = reverse;
		
		while(ptr!= null){
			if(ptr.data != ptr2.data) return false;
			ptr = ptr.next;
			ptr2 = ptr2.next;
		}
		
		return true;
	}
	
	
	//FUNCTION I MADE TO QUICKLY MAKE LINKED LISTS GIVEN AN ARRAY
	public static Node createLL(int[] data){
		Node t;
		if(data.length>0){
			t = new Node(data[0]);
		}else{
			return null;
		}
		for(int i = 1; i <data.length;i++){
			t.appendToTail(data[i]);
		}
		
		return t;
	}
}