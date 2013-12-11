package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncresingSubSequence {
    
    public static void main(String ...a){
        int numbers[] = {1,3,2,4,5,8,6,10,11,2,12,23,45,65,88,99,1,2,3,4,5,6,7,8,9,10,11,12,13};
        
        System.out.println(longest(numbers));
    }
    
    static List<Integer> longest(int numbers[]){
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        int len = numbers.length;
        
        for(int i=0;i<len-1;i++){            
            if(numbers[i] < numbers[i+1]){                
                temp.add(numbers[i]);
            }else{
                if(result.size() <= temp.size()){                        
                    temp.add(numbers[i]);                 
                    result.clear();
                    result.addAll(temp);
                    temp.clear();                    
                }else{
                    temp.clear();
                }                
            }
            if(i == len-2){
                if(result.size() <= temp.size()){                        
                    temp.add(numbers[i]);                 
                    result.clear();
                    result.addAll(temp);
                    temp.clear();                    
                }
            }
        }        
        return result;
    }    
}
