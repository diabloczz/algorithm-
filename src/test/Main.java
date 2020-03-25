package test;

import java.util.Arrays;

public class Main {
  public static  void change(int a,int b) {
	  a=a+100;
	  b=b+1000;
  }
  public static void main(String[] args) {
//	int a=10,b=20;
//	change(a,b);
//	System.out.println(a+","+b);
	//  int[] a= {1,2,3,4,5,6,7,8};
//	  int[] a= {1,2,3};
	  int[] a= {1,2};
	  int[] b=Arrays.copyOfRange(a, 0, a.length>>1);
	  int[] c=Arrays.copyOfRange(a,(a.length>>1)+1,a.length);
	  System.out.println(Arrays.toString(b));
	  System.out.println(Arrays.toString(c));
}
}
