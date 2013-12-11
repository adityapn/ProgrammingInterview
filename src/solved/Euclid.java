package solved;

public class Euclid {

    public static void main(String[] args) {
    
        int r = euclid(36,48);
        System.out.println(""+r);
    }
    
  static int euclid(int m,int n){

    while(n%m != 0){
        int r = n%m;
        n=m;
        m=r;
    }
    return m;
}

}
