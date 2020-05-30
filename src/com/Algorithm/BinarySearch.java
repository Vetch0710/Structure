package com.Algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[]= {1,3,8,10,11,68,100};
		int index=binarySearch(arr,11);
		System.out.println(index);

	}
	
	public static int binarySearch(int []arr,int target) {
		int left=0;
		int right=arr.length-1;
		int middle;
		while(left<=right) {
			 middle=(left+right)/2;
			if (arr[middle]==target) {
				return middle;
			}else if (arr[middle]>target) {
				//向左查找
				right=middle-1;
			}else {
				//向右查找
				left=middle+1;
			}
		}
		return -1;
	}
	
	

}
