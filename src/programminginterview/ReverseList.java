package programminginterview;

class ReverseList {
	//let's test our code using a simple example 1>2>3>4
	public static void main(String[] args) {
		RLList myList = new RLList(1);
		myList.next = new RLList(2);
		myList.next.next = new RLList(3);
		myList.next.next.next = new RLList(4);
		System.out.println("Original List: "+myList.tostring());
		//now reverse it
		myList = Reverse(myList);
		System.out.println("Reversed List: "+myList.tostring());
	}

	//now let's define the reverse method based on our proposed method
	static RLList Reverse(RLList L) {
		//firstly check if L is empty or only has one element then return
		if(L==null || L.next==null)
			return L;
		//otherwise, we can use our recursive method
		RLList remainingReverse = Reverse(L.next);
		//next we have two step steps, firstly we need update the tail of remaining reverse as our head L
		L.next.next = L;//this (L.next) is the key to get te tail in constant time!
		//Very important, we need set L.next to NULL after that! Otherwise it's causing cycles in list
		L.next = null;
		//finally we return the reverse List
		return remainingReverse;
	}
}
//we firstly define our List class
class RLList {
	int value;
	RLList next;
	//constructor
	public RLList(int k) {
		value = k;
	}
	//we also define a tostring method to easy output
	public String tostring() {
		RLList current = this;
		String output = "";
		while(current!=null) {
			output += current.value+"->";
			current = current.next;//do not forget to increment the pointer index current
		}
		return output+"NULL";
	}
}
