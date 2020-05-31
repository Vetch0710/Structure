package com.Algorithm;

import java.util.Arrays;

public class KMP {
	public static void main(String[] args) {
		String str = "BBC ABCDAB ABABCDABDE";
//		String str2 = "ABCDABD";
		String str2 = "ABAB";
		int[] a = kmpNext(str2);
		System.out.println(Arrays.toString(a));
		int index = kmp(str, str2, a);
		System.out.println(index);
	}

	// kmp算法
	public static int kmp(String str1, String str2, int[] next) {
		for (int i = 0, j = 0; i < str1.length(); i++) {

			while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}

			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

//获取到一个字符串的部分匹配值表   前缀后缀的公共元素的最大长度值
	public static int[] kmpNext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < dest.length(); i++) {
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}
