/**Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to
target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4],
target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:
Input: nums = [0,0,0],
target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0). */
import java.util.*;
class Triplet{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        System.out.println(solve(arr,x));
    }
    static int solve(int arr[],int x){
        Arrays.sort(arr);
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-2;i++){
            int p1=i+1,p2=arr.length-1;
            while(p1<p2){
                int csum=arr[i]+arr[p1]+arr[p2];
                if(Math.abs(x-csum)<Math.abs(x-sum)){
                    sum=csum;
                }
                if(csum>x){
                    p2--;
                }
                else    p1++;
            }
        }
        return sum;
    }
}