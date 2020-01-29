package 算法之数组;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author czz
 *
 */
public class TwoSum {
	/**
	 * 方法一 最暴力：对于每个元素都去查找其他元素，看是否符合条件，时间复杂度O(n^2)
	 * @param arr
	 * @param target
	 * @return
	 */
  public  static int[] twoSum(int[] arr ,int target) {
	  int [] twoSum=new int[2];
	  for(int i=0;i<arr.length;i++) {
		  for(int j=i+1;j<arr.length;j++) {
			  if(arr[i]+arr[j]==target) {
				  twoSum[0]=i;
				  twoSum[1]=j;
			  }
		  }
	  }
	  return twoSum;
  }
  
  public static void main(String[] args) {
	System.out.println(Arrays.toString(twoSum(new int[] {1,2,3,4,5,6,8,12,23},20)));
}
}
