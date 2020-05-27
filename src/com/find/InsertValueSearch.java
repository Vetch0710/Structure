package com.find;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
//		int [] arr=new int [100];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i]=i+1;
//		}
		int [] arr= {2,3,6,8,9,10,47,95};
		int index=insertValueSearch(arr,0,arr.length-1,600);
		System.out.println(index);
//		System.out.println(Arrays.toString(arr));
	}
	
	
	public static int insertValueSearch(int [] arr,int left,int right,int findValue) {
		System.out.println("1111111");
		if (left>=right || findValue<arr[0] ||findValue >arr[arr.length-1]) {
			if (findValue==arr[right]) {
				return right;
			}
			return -1;
		}
		int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
//		int mid=(right+left)/2;
		int midval=arr[mid];
		if (findValue >midval) {
			//向右递归查找
			return insertValueSearch(arr,mid+1,right,findValue);
		}else if(findValue<midval) {
			//向左递归查找
			return insertValueSearch(arr,left,mid-1,findValue);
		}else {
			return mid;
		}
		
	}

}
