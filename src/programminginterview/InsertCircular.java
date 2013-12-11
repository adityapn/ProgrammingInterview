package programminginterview;

public class InsertCircular {
	public static void main(String[] args) {
		//test now
		//first null case
		CircularList myList = null;
		myList = insert(myList, 1);
		myList.printList();//expect 1
		myList.next = new CircularList(3);
		myList.next.next = new CircularList(5);
		myList.next.next.next = myList;//so expect list is 1>3>5
		
		myList = insert(myList, 2);
		myList.printList();//expect 1>2>3>5
		
		myList = insert(myList, 0);
		myList.printList();//expect 0>1>2>3>5
		
		myList = insert(myList, 6);
		myList.printList();//expect 0>1>2>3>5>6
	}
	
	//now let's define our method
	//firstly, please notice the return type must be a List type, otherwise for Null case, it cannot
	//successfully create the adding function!
	static CircularList insert(CircularList myList, int n) {
		//firstly if it is null
		if(myList == null) {
			return new CircularList(n);
		} else if(myList.next == myList) { //only one element
			//add this node
			myList.next = new CircularList(n);
			myList.next.next = myList;//the next's next reference points back to the head so forms a cycle
			return myList.value<n ? myList : myList.next; //we check value and return the smaller one as head
		} else if(n<myList.value) { //if it is the smallest element!
			//find tail and append!
			CircularList current = myList;
			while(current.next != myList)
				current = current.next;
			current.next = new CircularList(n);//add it after the tail
			current.next.next = myList;//set the appended node's next to original header
			return current.next;//because this is smallest value! And that's another reason we return List other than void
		}
		//otherwise, we either find a position when node.value<n and node.next.value>n or node.next==head (largest)
		CircularList current = myList;
		while(current.next!=myList && current.next.value<=n) {
			current = current.next;
		}
		CircularList currentNext = current.next;
		current.next = new CircularList(n);
		current.next.next = currentNext;//notice we made a copy of original next and assign it here
		return myList;//return header position is unchanged!
	}
}

//firstly, define our own circular linked list class
class CircularList {
	int value;
	CircularList next;
	public CircularList(int k) {
		value = k;
		next = this;//point to itself for creating a new instance, need manually adjust tail's next to head
	}
	//let's write a support method to print out elements in circular list
	public void printList() {
		if(this==null)
			return;
		//otherwise, we copy the current head reference, iterate the list until we meet the head
		CircularList current = this;
		do{
			System.out.print(current.value+",");
			current = current.next;
		} while(current!=this);
		System.out.println();//add a new line for formatting
	}
}
