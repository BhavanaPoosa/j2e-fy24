/**Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
// A Java program for merging overlapping intervals
import java.util.Arrays;
import java.util.*;
import java.util.Comparator;
import java.util.Stack;
public class Overlap {
	public static void mergeIntervals(Interval arr[])
	{
		if (arr.length <= 0)
			return;
		Stack<Interval> stack=new Stack<>();

		Arrays.sort(arr,new Comparator<Interval>(){
			public int compare(Interval i1,Interval i2)
			{
				return i1.start-i2.start;
			}
		});
		stack.push(arr[0]);
		for (int i = 1 ; i < arr.length; i++)
		{
			Interval top = stack.peek();
			if (top.end < arr[i].start)
				stack.push(arr[i]);

			else if (top.end < arr[i].end)
			{
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}
		}
		while (!stack.isEmpty())
		{
			Interval t = stack.pop();
			System.out.print("["+t.start+","+t.end+"] ");
		}
	}

	public static void main(String args[]) {
	    Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Interval arr[] = new Interval[n];
        for (int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            arr[i] = new Interval(start, end);
        }
        input.close();
        mergeIntervals(arr);
	}
}

class Interval
{
	int start,end;
	Interval(int start, int end)
	{
		this.start=start;
		this.end=end;
	}
}
