package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {

	public static void main(String[] args) {
//		int arr[]= {8,4,5,7,1,3,6,2};
//		int temp[]=new int [arr.length];
//		mergeSort(arr,0,arr.length-1,temp);
//		System.out.println(Arrays.toString(arr));
		
		
		int arr8000[] = new int[8000000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);

		int temp[]=new int [arr8000.length];
		mergeSort(arr8000,0,arr8000.length-1,temp);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);
	}
	
	
	public static void mergeSort(int arr[],int left,int right,int temp[]) {
		if(left<right) {
			int middle=(left+right)/2;
			//左分
			mergeSort(arr,left,middle,temp);
			//右分
			mergeSort(arr,middle+1,right,temp);
			//合并
			merge(arr,left,middle,right,temp);
		}
	}
	
	
	public static void merge(int arr[],int left,int middle,int right,int temp[]) {
		int li=left; //左边序列开始的终点
		int ri=middle+1;  //右边序列开始的起点
		int t=0; //temp数组的索引
		
		
		//比较左右两个序列，并放入temp数组中
		while(li<=middle &&ri<=right) {
			//左边序列的当前元素小于 右边序列的当前元素
			if (arr[li]<=arr[ri]) {
				temp[t]=arr[li];
				li++;
				t++;
			}else {
				temp[t]=arr[ri];
				ri++;
				t++;
			}
		}
		
		//如果左边序列有剩余元素 则一次放入temp数组中
		while(li<=middle) {
			temp[t]=arr[li];
			t++;
			li++;
		}
		//如果右边序列有剩余元素 则一次放入temp数组中
		while(ri<=right) {
			temp[t]=arr[ri];
			t++;
			ri++;
		}
		
		//将temp数组的元素拷贝到arr中
		t=0;
		int tempLeft=left;
		while(tempLeft<=right) {
			arr[tempLeft]=temp[t];
			t++;
			tempLeft++;
		}
		
	}
}
