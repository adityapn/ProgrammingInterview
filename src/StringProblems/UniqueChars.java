package StringProblems;

import java.util.Hashtable;

public class UniqueChars {
    
    public static void main(String args[]){
        Hashtable<Character,Character> unique = new Hashtable<Character, Character>();
        String name = "adittya";
        String uniq = "";
        for(int i=0;i<name.length();i++){
            if(!unique.contains(name.charAt(i))){
                unique.put(name.charAt(i), name.charAt(i));
                uniq += name.charAt(i);
            }
        }
        System.out.println(uniq);
    }
    
}
