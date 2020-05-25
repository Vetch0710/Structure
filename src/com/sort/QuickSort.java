package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
//		int arr[] = { -9,78,0,23,-567,70 };
//		quickSort(arr,0,arr.length-1);
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
		
		quickSort(arr8000,0,arr8000.length-1);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);

	}

	public static void quickSort(int arr[], int left, int right) {
		int temp=0;
		int l = left;
		int r = right;
		int middle = arr[(left + right) / 2];
		while (l < r) {
			//找出左边大于中间元素的  元素
			while (arr[l] < middle) {
				l++;
			};
			//找出右边小于中间元素的  元素
			while (arr[r] > middle) {
				r--;
			};
			if (l>=r) {
				break;
			}
			//将找出的左右数据进行交换；
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			//为了使middle处于中间（正确）的位置和避免死循环
			if (arr[l]==middle) {
				r--;
			}
			//为了使middle处于中间（正确）的位置和避免死循环
			if (arr[r]==middle) {
				l++;
			}
		}
		if (r==l) {
			r--;
			l++;
		}
		//向左递归
		if (left<r) {
			quickSort(arr,left,r);
		}
		//像右递归
		if (l<right) {
			quickSort(arr,l,right);
		}
		
	}

}
