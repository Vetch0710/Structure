package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
		// 冒泡排序
//		int arr[] = { 3, 9, -1, 10, 11 };
//		bubbleSort(arr);

		// 测试 80000个数据 的冒泡排序的速度   ---------11s 左右
		int arr8000[] = new int[80000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		System.out.println(new java.util.Date(System.currentTimeMillis()));
		bubbleSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
		
		
		
	}

	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean isChange = false; // 判断在全部排序执行完前，已经排好序
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					isChange = true; // 发生了交换
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			if (!isChange) { // 如果在新的一次排序中，没有发生交换，则跳出，不执行下次排序
				break;
			} else {
				isChange = false;
			}
		}

	}

}
