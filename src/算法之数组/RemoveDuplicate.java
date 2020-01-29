package 算法之数组;
/**
 * 给定一个有序的数组，要求去除数组中的重复项，并返回新数组的长度。
 * 要求根据新长度遍历数组时，得到的元素就是数组中所有不重复元素的有序排列。
 * @author czz
 */
public class RemoveDuplicate {
    
	/**
	 * 解题思路 ：双指针
	 *  一个指针p指向数组起始位置，一个数组q指向第二个位置，比较其实两个元素是否相等，不等的话将q的元素赋值给p，同时p和q同时向后移动一位
	 *  如果p和q所在元素相等，q元素向后移位
	 * @param arr
	 * @return
	 */
	public static int removeDuplicate(int[] arr) {
		if(arr.length<2) {
			return arr.length;
		}
		int curr=0;
		int point=1;
		while(point<arr.length) {
			if(arr[curr]!=arr[point]) {
				arr[++curr]=arr[point];
			}
			point++;
		}
		System.out.println(curr);
		System.out.println(point);
		return ++curr;
	}
	public static void main(String[] args) {
		int[] a=new int[] {1,1,1,1,2,4,4,4,4,6,6,66,77};
		int newLength=removeDuplicate(a);
		System.out.println("newLength:"+newLength);
		for(int i=0;i<newLength;i++) {
			System.out.println(a[i]);
		}
	}
}
