/**Problem 7:
Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104 */
import java.io.*;
import java.util.*;
 
class MaxSubSum {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxSubArraySum(arr,n));
    }
 
    static int maxSubArraySum(int a[],int n)
    {
        int max = Integer.MIN_VALUE;
        int maxend = 0;
 
        for (int i=0;i<n;i++) {
            maxend+=a[i];
            if (max < maxend)
                max = maxend;
            if (maxend< 0)
                maxend = 0;
        }
        return max;
    }
}