package OnArrayStackQueue;
/*
 * Maintain an 2 extra arrays with min and max valus 
 * 
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class MinAndMaxOfStackInConstantTime {
	
	List<Integer> stack = null;
	List<Integer> minList = null;
	List<Integer> maxList = null;
	int count = -1;
	public void push(int data){
		if(stack == null && minList == null && maxList == null){
			stack = new Stack<Integer>();
			minList = new ArrayList<Integer>();
			maxList = new ArrayList<Integer>();
			stack.add(data);
			minList.add(data);
			maxList.add(data);
			count++;
			return;
		}
		// Add stuff to the min list
		if(data < minList.get(count)){			
			minList.add(data);
		}else{
			minList.add(minList.get(minList.size()-1));
		}
		// Add stuff for the max list
		if(data > maxList.get(count)){
			maxList.add(data);
		}else{		
			maxList.add(maxList.get(maxList.size()-1));
		}
		count++;
		stack.add(data);
		
	}
	public Integer pop(){
		Integer temp = stack.remove(count);
		minList.remove(count);
		maxList.remove(count);
		count--;
		return temp;
	}
	
	public Integer min(){
		Integer temp = null;
		if(count > -1){			
			temp = minList.get(count);
			if(temp > stack.get(count)){
				temp = stack.get(count);
			}
		}
		return temp;
	}
	public Integer max(){
		Integer temp = null;
		if(count > -1){
			temp = maxList.get(count);
			if(temp < stack.get(count)){
				temp = stack.get(count);
			}
		}
		return temp;
	}
	
	public static void main(String ...a){
		MinAndMaxOfStackInConstantTime stack = new MinAndMaxOfStackInConstantTime();
		int numbers[] = {18,19,29,15,16};
		for(int i=0;i<numbers.length;i++){
			stack.push(numbers[i]);
		}
		for(int i=0;i<numbers.length;i++){
			System.out.println("Max "+stack.max()+" Min "+stack.min()+" Pop "+stack.pop());
		}
	}

}
