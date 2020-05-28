package com.tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
//		int arr[]= {4,6,8,5,9,-1,90,89,56,-999};
//		heapSort(arr);
		int arr8000[] = new int[8000000];
		for (int i = 0; i < arr8000.length; i++) {
			arr8000[i] = (int) (Math.random() * 80000);// 随机产生一个0-80000的数字
		}
		//输出当前时间
		System.out.println(new java.util.Date(System.currentTimeMillis()));
		heapSort(arr8000);
		//System.out.println(new java.util.Date(System.currentTimeMillis()));
		
		Date date=new Date();
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=ss.format(date);
		System.out.println("当前时间为："+time);
//		System.out.println(Arrays.toString(arr8000));
	}


	public static void  heapSort(int arr[]){
		int temp=0;
		//第一次遍历成大顶堆 ，从下至上遍历。因为假如从上至下遍历的话，左右两边无法全都调整好
		//（如：右节点大于左节点大于根节点，右节点与根节点交换，接着往下调整右节点，然后结束，这样无法调整到左节点）
		for (int i = arr.length/2-1;i>=0 ;i--) { 
			adjustheapSort(arr,i,arr.length);
		}
		
		for (int i = arr.length-1;i>0 ;i--) {
			temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			//这里从上至下遍历，因为只交换了堆顶元素和最末尾元素，其他元素的顺序不变，所以只需调整堆顶的元素的顺序即可
			adjustheapSort(arr,0,i);
		}
		
	}
	
	/**
	 * 
	 * @param arr 待调整的数组
	 * @param i  表示非叶子节点再数组中的索引
	 * @param length 表示对多少个元素继续调整
	 */
	public static void  adjustheapSort(int arr[],int i,int length){
		int temp=arr[i];
		for (int k=i*2+1;k<length;k=k*2+1) { //k表示i的左子节点
			if (k+1<length&&arr[k]<arr[k+1]) {//左子节点小于右子节点       k+1<length：提高效率
				k++; //k指向右子节点
			}
			if (arr[k]>temp) {
				arr[i]=arr[k];
				i=k;
			}else {
				break; 
			}
		}
		arr[i]=temp;
	}
	
	
	
}


