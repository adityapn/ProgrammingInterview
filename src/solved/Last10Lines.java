package solved;

public class Last10Lines {
    
    public static void main(String ...s){
        
        String str = "\n1So let \n2it be written\n3So let \n"
           + "4it be done\n5I'm sent here \n6by the \n7chosen one\n"
           + "8So let it be written\n9So let \n10it be done\n11To kill the first born\n"
           + "12master\n13of puppets\n14Die by my hand\n15I creep across "
           + "16the land\n17Killing first-born man\n18Die by \n19my hand"
           + "\n20I creep across \n21the land\n22Killing \n23first-born man"
                + "\n24djhfjdshf\n25lkdhfs";

        occur(str,5);
    }
    static void occur(String s , int line){        
        if(line < 0)
            return ;
        
        int c = 0;
        int occurences = numberOfOccurences(s, "\n")-10;
        System.out.println(" "+occurences);
         for(int i=0;i<s.length();i++){            
            if((s.charAt(i)+"").equals("\n")){
                  c++;  
            }
            if(c > occurences){
                System.out.print(""+s.charAt(i));
            }
        }                  
    }
    static int numberOfOccurences(String s, String patt){
        int count = 0;        
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)+"").equals(patt)){
                  count++;  
            }
        }
        
        return count;
    }
}
