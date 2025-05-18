package aps.leetcode.grind75;

//Constraints
//m == image.length
//		n == image[i].length
//		1 <= m, n <= 50
//		0 <= image[i][j], color < 216
//		0 <= sr < m
//0 <= sc < n

//todo : 구현중
public class Easy_733_Flood_Fill {

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

		System.out.println(sr+ ", " + sc);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j]);
			}
		}
		System.out.println("");

//		if(image[sr][sc] == color){
//			return image;
//		}

		int oldColor = image[sr][sc];
		System.out.println("old "+ oldColor);

		if (sr - 1 >= 0 && image[sr-1][sc] == oldColor) {
			System.out.println("c1");
			image[sr-1][sc] = color;
			return floodFill(image, sr - 1, sc, color);
		}
		if (sr + 1 < image.length && image[sr+1][sc] == oldColor) {
			System.out.println("c2");
			image[sr+1][sc] = color;
			return floodFill(image, sr + 1, sc, color);
		}
		if (sc - 1 >= 0 && image[sr][sc-1] == oldColor) {
			System.out.println("c3");
			image[sr][sc-1] = color;
			return floodFill(image, sr, sc - 1, color);
		}
		if (sc + 1 < image[0].length && image[sr][sc+1] == oldColor) {
			System.out.println("c4");
			image[sr][sc+1] = color;
			return floodFill(image, sr, sc + 1, color);
		}

		return image;
	}

	public static void main(String[] args) {

		int[][] image = {{1, 1, 1,}, {1, 1, 0}, {1, 0, 1}};
		int sr = 1;
		int sc = 1;
		int color = 2;

//		[[1,2,1],[1,2,0],[1,0,1]]

		int[][] result = floodFill(image, sr, sc, color);
		System.out.println("result");


		System.out.println(sr+ ", " + sc);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
		}

//		Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//		Output: [[2,2,2],[2,2,0],[2,0,1]]

	}

}


