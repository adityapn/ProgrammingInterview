package solved;

public class Sqrt {
	//define method header
    
    public static void main(String... a){
          
          int sq = (int)sqrt(16);
          System.out.println("16 has "+sq);
    }
    public static double sqrt(double a){
        
	//firstly check if a is non-negative value
	if(a<0) 
            return -1;
	
        //also check if a==0 or a==1 because in these two cases sqrt(a) = a
	if(a==0 || a==1) 
            return a;
	
	//now start the core part of the code
	double precision = 0.00001;//define the precision, so we stop when precision is achieved
	double start = 0;
	double end = a;
	//we define these two start/end values because usually 0<sqrt(a)<a
	
        //however, if a<1; then 0<a<sqrt(a)
	if(a<1)
	    end = 1;
	
	//define a loop to continue if the precision is not yet achieved
	while(end - start > precision)
	{
		double mid = (start+end)/2;
		double midSqr = mid*mid;
                System.out.print("End "+end+" ");
                System.out.print("Start "+start+" ");
                System.out.print("mid "+mid+" ");
                System.out.println("mid sqrt "+midSqr);
                
                if(midSqr==a) 
                    return mid;//we find the exact sqrt value!
		else if(midSqr<a) 
                    start = mid;//we shift our focus to bigger half
		else 
                    end = mid;//shift focus to smaller half
	}
	
	//if we did not find exact sqrt value, we return the approxiated value with the defined precision
	return (start+end)/2;
     }
}