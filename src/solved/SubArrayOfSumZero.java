package solved;

public class SubArrayOfSumZero {
    
    static int arr[] = {1,7,2,3,-5,-8,1};
    public static void main(String ...s){                
        int start =0, end=0 , sum = 0;
        boolean flag= true;
        for(int i=0;i<arr.length&&flag;i++){
            sum = 0;
            for(int j=i;j<arr.length;j++){
                    sum += arr[j];
                    if(sum == 0){
                        start = i;
                        end = j;
                        subarray(start, end);
                        flag = false;		
                    }
            }            
        }
        System.out.println("");
        
    }
     static void subarray(int s , int e){
             
              for(int i = s;i<=e;i++)
                  System.out.print(" "+arr[i]);
        
     }
        
   }
   
