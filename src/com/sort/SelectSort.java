package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
//		int arr[] = {101,34,119,1 };
//		selectSort(arr);

		int arr8000[] = new int[800000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
		
		selectSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);
		
		
		
		
		
		
	}

	public static void selectSort(int[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			
			int index=i; //记录遍历时最小的元素 的位置
			int temp=arr[i]; //辅助变量  假设为最小
			for (int j = i+1; j < arr.length; j++) {
				if(temp>arr[j]) {
					temp=arr[j];
					index=j;  //记录该最小点的位置
				}
			}
			if (index!=i) {
				arr[index]=arr[i];
				arr[i]=temp;
			}
			//System.out.println("第"+(i+1)+"次排序"+Arrays.toString(arr));
		}
	}
}
