package StringProblems;

public class ReplaceWhiteSpace {
    
    public static void main(String ...a){
        StringBuffer name = new StringBuffer();
        name.append("about scalability article by aditya");        
        System.out.println(replaceWhiteSpace(name));
    }
    static String replaceWhiteSpace(StringBuffer str){
        
        int length = str.length();
        for(int i=0;i<length;i++){
           
            if(str.charAt(i)== ' '){                
                str.replace(i, i+1, "%20");
            }
        }
        System.out.println(str);
        return str.toString();
    }
    
}
