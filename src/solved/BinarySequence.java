/*
 * Given a binary string of length n, find a string of length at least L whose density is maximum. 
 * ie. string with maximum number of one's.
 * and open the template in the editor.
 */

package solved;

public class BinarySequence {
    
    public static void main(String s[]){
    
        String seq = "10111110000111111111111111000000000000000";
        int i=0;
        float count =0;
        float pre =0;
        String temp = "",store="";
            
        while(i<seq.length()){
             
            if(seq.charAt(i) == '1'){
                    count++;
                    temp+=seq.charAt(i);
                    
                    if( ((i+1)<seq.length()) && (seq.charAt(i+1) == '0' || i+1 == seq.length()-1) ){
                            if(count>=pre){
                               if(i+1 == seq.length()-1 && seq.charAt(i+1) == '1') {
                                  store = temp;
                                  store+='1';
                               }
                               else{
                                   store = temp;
                                   temp = "";
                                   pre = count;                                 
                                   count = 0;
                              }  
                         }
                    }
            }else if(seq.charAt(i) == '0'){
                count = 0;
            }
            i++;
        }
        System.out.println("Max density "+store);
    
    }
    public static boolean density(float count,float pre,float len){
        
        float current = (count)/len;
        
        if(pre<=current){
            return true;
        }
        
        return false;
    }
    
}
