package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
//		int arr[] = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
//		shelMovelSort(arr);
	
		
		
		
		int arr8000[] = new int[8000000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
		
		shelMovelSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);

	}

//交换法
	public static void shellChangelSort(int[] arr) {
		int temp = 0;
		// 求出增量 如：第一次为5
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 按增量划分 如：第一次分5组

			for (int i = gap; i < arr.length; i++) {
				// 遍历按增量划分后的数据
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j + gap];
						arr[j + gap] = arr[j];
						arr[j] = temp;
					}
				}
			}
//			System.out.println(gap);
//			 System.out.println(Arrays.toString(arr));
		}
	}

	// 移动法
	public static void shelMovelSort(int[] arr) {

		// 求出增量 如：第一次为5
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 按增量划分 如：第一次分5组
			for (int i = gap; i < arr.length; i++) {
				// 遍历按增量划分后的数据
				int temp = arr[i];
				int index = i;
				if (arr[index] < arr[index - gap]) {
					while (index - gap >= 0 && temp < arr[index - gap]) {
						arr[index] = arr[index - gap];
						index = index - gap;
					}
					arr[index] = temp;
				}

			}
			 //System.out.println(Arrays.toString(arr));
		}
	}

}
