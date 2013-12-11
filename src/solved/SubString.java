package solved;
// Find the longest substring from a given string
import java.util.*;

public class SubString {
    
    public static void main(String ...s){
        
        String main = "abcdefghaxyzpbnlwi";
        HashMap substr = new HashMap();        
        int len = main.length();
        int i = -1,j=0;
        String temp = "";        
        String sub = "";
         
        while(j < len){                     
            if(substr.get(main.charAt(j)) == null){
                 substr.put(main.charAt(j), 0);
                 temp += main.charAt(j);                                 
            }else{
                if(sub.length() <= temp.length()){
                    sub = temp;                     
                    temp = "";
                    i++;
                    j = i;
                    substr.clear();
                }else{
                    temp = "";                    
                }
            }            
            j++;                                    
        }        
        System.out.println("Biggest String is : "+sub+" and hashcode is "+substr.hashCode());
    
    }
    
}
