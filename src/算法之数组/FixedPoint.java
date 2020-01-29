package 算法之数组;
/**
 * 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。

 

示例 1：

输入：[-10,-5,0,3,7]
输出：3
解释：
对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fixed-point
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author czz
 *
 */
public class FixedPoint {
	
	/**
	 * 这种方法简单的不想解释，但是遍历全部元素，效率貌似不是很高
	 * @param A
	 * @return
	 */
	    public int fixedPoint(int[] A) {
	        for(int i=0;i<A.length;i++){
	            if(A[i]==i)
	               return i;
	        }
	        return -1;
	    }
	    
	   /**
	    * 二分查找
	    * @param A
	    * @return
	    */
	    public int fixedPoint2(int[] A) {
	           int start=0;
	           int end=A.length-1;
	           while(start<end) {
	        	   int mid=start+(end-start)/2;
	        	   if(A[mid]>=mid) {
	        		   end=mid;
	        	   }else {
	        		   start=mid+1;
	        	   }
	           }
	           if (start == A.length) return -1;
	           return start == A[start] ? start : -1;
	    }
	
}
