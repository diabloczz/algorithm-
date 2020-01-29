package 算法之数组;

import java.util.Arrays;

/**
 * 
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。

 * @author CZZ
 *
 */
public class RemoveElement {
	/**
	 * 解题思路：又是一道双指针题，起始值a=0,i=0,i是遍历的数组下标
	 * 首先要遍历数组，当元素与给定值不等时，起始值arr[a]=arr[i],并且增1
	 * @param arr
	 * @param e
	 * @return
	 */
      public static int removeElement(int[] arr,int e) {
    	  int a=0;
    	  for(int i=0;i<arr.length;i++) {
    		 if( arr[i]!=e) {
    			 arr[a++]=arr[i];
    		 }
    	  }
    	  return a;
      }
      
      public static void main(String[] args) {
    	  int[] arr=new int[] {1,2,3,5,6,7,2,4,88,1,2,2,5,4,2,3};
	     int index=removeElement(arr,2);
	     for(int i=0;i<index;i++) {
	    	 System.out.println(arr[i]);
	     }
	}
}
