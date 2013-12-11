package DynamicProgramming;

public class MaximumSubSequenceSum {
    
    public static void main(String ...a){
        int numbers[] = {-2,-3,4,-1,5,-3};
        System.out.println("Max sum "+maxSum(numbers));
    }   
    
    static int maxSum(int numbers[]){
        int sum = 0;        
        int length = numbers.length;
        if(numbers.length > 0){
            int temp = 0;
            sum = numbers[0];
            for(int i=0;i<length;i++){
                temp = sum + numbers[i];
                if(temp > sum){                    
                    sum = temp;
                }
            }
        }        
        return sum;
    }
}
