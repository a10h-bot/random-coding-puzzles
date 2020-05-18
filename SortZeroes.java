
import Java.util.Arrays;
public class SortZeroes{
    public static void main(String[] args) {
     int [] A = {0,1,1,0,1,0,1};
     helper(A);    
    }
    private  static void  helper(int [] A){
         Arrays.sort(A);
         for(int e : A){
             System.out.println(e+ " ");
         }
    } 
} 