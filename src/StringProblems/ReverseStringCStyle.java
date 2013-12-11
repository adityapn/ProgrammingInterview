/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProblems;

/**
 *
 * @author Metallica
 */
public class ReverseStringCStyle {
    
    public static void main(String ...a){
        String string = "np aytida";
        int length = string.length();
        for(int i = length-1;i>-1;i--){
            System.out.print(string.charAt(i));
        }
        
    }
    
}
