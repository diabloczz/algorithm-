package 算法之数组;
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1

 * @author czz
 *
 */
public class SearchInsert {
	  public static int searchInsert(int[] nums, int target) {
		  int a=0;
	         for(int i=0;i<nums.length;i++) {
	        	 if(nums[i]==target) {
	        		 a= i;
		        	 break;
	        	 } 
	        	 if(i<nums.length-1 && nums[i+1]!=target) {
	        		 a=i+1;
	        	 }
	        		
	        	 if(i=nums.length-1 && nums[i+1]!=target) {
	        		 a=i+1;
	        	 }
	        	
	        		
	         }
	    }
}
