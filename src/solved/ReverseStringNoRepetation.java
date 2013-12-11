package solved;

/*
 * Given a string, say “GEEKS FOR GEEKS”, print it in reverse manner 
 * eliminating the repeated characters.
 */

import java.util.*;

public class ReverseStringNoRepetation {
    
    public static void main(String ...s){
        
        String str = "GEEKS FOR GEEKS";
        int c = str.length()-1;
        HashMap set = new HashMap();
        
        while(c>-1){
            if(!set.containsKey(str.charAt(c))){
                set.put(str.charAt(c), true);
                System.out.print(""+str.charAt(c));
                c--;
            }else{
                c--;
            }
        }
        System.out.println("");
    }    
}
