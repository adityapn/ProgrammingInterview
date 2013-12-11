package StringProblems;

import java.util.Arrays;

public class anagramsORnot {
    
    public static void main(String ...a){
        char string1[] = {'T','A','C'};
        char string2[] = {'C','A','T'};        
        System.out.println("Yes or not "+anagramsornot(string1,string2));
    }
    
    static boolean anagramsornot(char a[] , char b[]){                        
        if(a.length != b.length){
            return false;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        boolean flag = true;
        for(int i = 0;i<a.length;i++){
                if(a[i] != b[i]){
                    flag = false;
                }
            
        }
        return flag;
    }
    
}
