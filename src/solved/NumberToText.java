package solved;

public class NumberToText {
    
    public static void main(String s[]){
 
           String number = "1321";
           String nums[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
           String afterten[] = {"ten","eleven","twele","thirteen","fourteen","fifteen","sexteen","seventeen","eightteen","nineteen"};
           String doubleDg[] = {"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eightty","ninety"};
           String big[] = {"thousand","hundreden"};
           int len = number.length();
           String digit = "";
           int count = 0;
           while(len>=0){
               
               if(len == 4){
                    digit += nums[Integer.parseInt(""+number.charAt(count))]+" "+big[0]+" ";
                    count++;                   
               }else if(len == 3){
                    digit += nums[Integer.parseInt(""+number.charAt(count))]+" "+big[1]+" ";
                    count++;
               }else if(len == 2){                   
                   if(Integer.parseInt(number.charAt(1)+""+number.charAt(0))>9&&Integer.parseInt(number.charAt(1)+""+number.charAt(0))<20){
                     digit += afterten[Integer.parseInt(""+number.charAt(len))-1];
                     count++;
                     len = 0;
                   }else{
                     digit += doubleDg[Integer.parseInt(""+number.charAt(len))]+" "+nums[Integer.parseInt(""+number.charAt(count+1))];
                     count++;                        
                   }
                    
               }
               len--;
           }
           System.out.println("Digit :  "+digit);
           
    }
    
}
