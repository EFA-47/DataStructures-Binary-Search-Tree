import java.util.Random;
import java.util.Arrays;

public class HW1 {
	
	// This is the method that returns the count of 'a' chars in the matrix
	// Feel free to add a helper method for the recursive part of the algorithm
	public static int acount(char[][] mat) {
		int result = 0;
		// Your code goes here 
		for(int i=0;i<mat.length;i++) {
			int left=0;
			int right=mat.length-1;
			result+=help(mat, left, right, i);
		}
		return result;
	}
	public static int help(char [][] arr,int left,int right,int i) {
		int result=0;
		int mid=(left+right)/2;
		if(right==0) {
			return 0;
		}
		else if(arr[i][mid]=='a'&&arr[i][mid+1]=='b') {
			result=mid+1;
			
		}else if(arr[i][mid]=='a') {
			left=mid;
			 result=help(arr, left, right, i);
		}else {
			right=mid;
			result=help(arr, left, right, i);
		}
		return result;
	}

	public static void main(String[] args) {
		// This method creates a test case for you
		int n = 5;
		Random rand = new Random();
		char[][] input = new char[n][n];
		for (int i = 0; i < n; i++) {
			int a_num = rand.nextInt(n);
			for (int j = 0; j < a_num; j++) {
				input[i][j] = 'a';
			}
			for (int j = a_num; j < n; j++) {
				input[i][j] = 'b';
			}
		}
		// Here you can see the matrix row by row 
		System.out.println(Arrays.deepToString(input));
		// Here you can see the result of your function
		System.out.println(acount(input));
	}

}
