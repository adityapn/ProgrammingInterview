/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solved;

/**
 *
 * @author Aditya
 */
public class CyclicLL {
    
    class Node{
                Node link;
		int data;
        }	
	int count = 0;
	Node node;
	
        public CyclicLL(){
		node = null;
	}
	
	public void append(int da){
		Node temp,two;
		
		if(node == null){
			node = new Node();
			node.link = null;
			node.data = da;
			return ;
		}
		two = node;
		while(two.link!=null)
			two = two.link;	
	
                temp = new Node();
		temp.link = null;
		temp.data = da;
		two.link = temp;	
                count++;
	}
	
	public void display(){
		
		Node t;
		t = node;
		while(t!=null){
			System.out.println(t.data);
			t = t.link;
		}
	}
	public boolean cyclicORacyclic(){
        
            Node fast = node;
            Node slow = node;
            
            for(int i=1;;i++){
                fast = fast.link;
                if(i%2==0){
                    slow = slow.link;
                }
                if(fast == null){
                        return true;
                }
                if(fast == slow)
                    break;
            }
            
            return false;
        }
        
	public static void main(String args[]){
		CyclicLL list = new CyclicLL();
		list.append(12);
		list.append(87);
		list.append(78);
                list.append(58);
                list.append(48);
         
                if(list.cyclicORacyclic())
                    System.out.println("Acyclic");
                else
                   System.out.println("Cyclic");
		list.display();
		
	}

}
