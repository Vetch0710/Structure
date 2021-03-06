package com.test;

public class MiGong {

	public static void main(String[] args) {
		int map[][] = new int[8][7];
		// 上下
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = 1;
			map[map.length - 1][i] = 1;
		}
		// 左右
		for (int i = 0; i < map.length; i++) {
			map[i][0] = 1;
			map[i][map[0].length - 1] = 1;
		}

		map[3][1] = 1;
		map[3][2] = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("结果为：");
		setWay(map,1,1);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (setWay(map, i + 1, j)) {  
					//如果此点的下方可以走，则返回true ,此点值为2
					return true;
				} else if (setWay(map, i, j + 1)) {
					//如果此点的右方可以走，则返回true ,此点值为2
					return true;
				} else if (setWay(map, i - 1, j)) {
					//如果此点的上方可以走，则返回true ,此点值为2
					return true;
				} else if (setWay(map, i , j-1)) {
					//如果此点的左方可以走，则返回true ,此点值为2
					return true;
				}else {
					//说明此点不通
					map[i][j]=3;
					return false;
				}

			}else {
				return false;
			}

		}
	}

}
