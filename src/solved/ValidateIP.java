package solved;

public class ValidateIP {
    
    public static void main(String ...s){
              validate("172.14.8.0");    
              validate("sljhjhfasj");
              validate("172.a.8.0");
              validate("a.172.8.0");
              validate("172.14.a.0");
              validate("172.1.8.a");
    }
    static void validate(String ip){
        
        int len = ip.length();
        int c = 0,p=0;
        String t = "";
        int[] block = new int[4];
        boolean flag = true;
        
        while(c<len){
            
            if((ip.charAt(c)+"").equals(".") && p<4){               
                 if(t.matches(".*\\d.*")){
                     block[p] = Integer.parseInt(t);
                     t = "";
                     p++;
                     c++;
                 }else{
                     break;
                 }                                
            }else if(p == 4) {
                System.out.println("Not an ip address");
                flag = false;
                break;
            }
            else{
                t += ip.charAt(c);
                c++;
            }
        }
        if(p < 3){
            System.out.println("not an ip");
        }else
            System.out.println("an ip");
    
    }
    
}
