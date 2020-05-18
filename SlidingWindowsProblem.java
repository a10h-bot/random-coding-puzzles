
//Sliding window problem 
//Source : https://www.youtube.com/watch?v=MK-NZ4hN7rs
//Input Array = [4,2,1,7,8,1,2,8,1,0]
//find the maximum subarray with length 3


public class SlidingWindowsProblem{
    public static void main(String[] args) {
      int [] a =  {4,2,1,7,8,1,2,8,1,0};
     System.out.println(findMaxSubArray(a,3));

    }

    private static int findMaxSubArray(int [] arr, int k) {
             int maxValue =Integer.MIN_VALUE;
             int currentRunningSum =0;
             int n=arr.length;
             for(int i=0;i<n;i++){
                 currentRunningSum +=arr[i];
                 if(i>=k-1){
                     maxValue =Math.max(maxValue,currentRunningSum);
                     currentRunningSum-=arr[i-(k-1)];
                 }
             }
             return maxValue;
    }
}