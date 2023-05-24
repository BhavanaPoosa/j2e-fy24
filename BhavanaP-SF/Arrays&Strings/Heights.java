/**Problem 2:
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
the i
th
line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. I
Example 2:
Input: height = [1,1]
Output: 1
 */
import java.util.*;
class Heights{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int  i=0,j=n-1;
        int h=0,max=0;
        while(j!=i){
            h=Math.min(arr[i],arr[j]);
            if(h*(j-i)>max){
                max=h*(j-i);
            }
            if(arr[i]<arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println(max);

    }
}