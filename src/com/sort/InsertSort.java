package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
//		int arr[] = {101,34,119,1,-1,89 };
//		insertSort(arr);

		int arr8000[] = new int[800000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
		
		insertSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);
		
		
		
		
		
		
	}

	public static void insertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp=arr[i]; 
			int index=i;
			//从小到大   为temp<arr[index-1]
			//从大到小   为temp>arr[index-1]
//			while (index>=1&&temp<arr[index-1]) {  
//				arr[index]=arr[index-1];           
//			index--;
//			}
			for (int j=index; j >=1; j--) {
				if (temp<arr[j-1]) {
					arr[j]=arr[j-1];
					index=j-1;
				}
				
			}
			if (index!=i) {
				arr[index]=temp;
			}
			
			//System.out.println("第"+(i)+"次插入"+Arrays.toString(arr));
		}
	}
}
