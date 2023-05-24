import java.util.*;
import java.io.*;
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maximumArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int shorterLine = Math.min(height[left], height[right]);
            maximumArea = Math.max(maximumArea, shorterLine * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
    }

    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	int n=sc.nextInt();
    	int height[]=new int[n];
    	for(int i = 0;i<n;i++){
    	   height[i]=sc.nextInt();
    	}
    	System.out.println(maxArea(height));
    }
}