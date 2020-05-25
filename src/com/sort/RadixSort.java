package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

	public static void main(String[] args) {
//		int arr[]= {53,3,542,748,14,214};
//		radixSort(arr);
		int arr8000[] = new int[80000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
		
		radixSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date2=new Date();
		SimpleDateFormat ss2=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time2=ss2.format(date2);
		System.out.println("当前时间为："+time2);
	}

	public static void radixSort(int [] arr) {
		
		int max=arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		
		int maxlength=(max+"").length();
		
		for (int m = 0,n=1; m < maxlength; m++,n*=10) {

			//定义一个二维数组，表示10个桶，每个桶就是一个一维数组
			//为防止在放入数据使，数据溢出，则将二维数组的列 定为 arr.length
			//基数排序是 用空间换时间的经典算法
			int [][] bucket=new int[10][arr.length];
			
			//表示记录每个桶中存放数据的个数   bucketElementCounts[0]表示bucket[0]桶中的数据的个数
			int[] bucketElementCounts=new int[10];
			
			for (int i = 0; i < arr.length; i++) {
				int ge=arr[i]/n  %10;
				bucket[ge][bucketElementCounts[ge]]=arr[i];
				bucketElementCounts[ge]++;
			
			}
			int index=0;
			for (int i = 0; i < bucketElementCounts.length; i++) {
				if (bucketElementCounts[i]!=0) {
					for (int j = 0; j < bucketElementCounts[i]; j++) {
						arr[index]=bucket[i][j];
						index++;
					}
				}
				bucketElementCounts[i]=0;
			}
//			System.out.println(Arrays.toString(arr));
		}
		
		
	
	}
	
}
