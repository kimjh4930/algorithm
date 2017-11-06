package solution;

import java.util.Scanner;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		for (int test_case = 0; test_case < 10; test_case++) {
			//가장 큰 수를 찾아냄.
			int length = Integer.parseInt(sc.nextLine());
			String input = sc.nextLine();
			
			int[] height = stringToInt(length, input);
			int max = bigNumber(height);
			int[][] buildings = presentBuilding(length, height, max);
			
			Answer = judgeView(length, max, buildings);
			
			System.out.println("#" + (test_case + 1) + " " + Answer);
		}
	}
	
	public static int bigNumber(int[] input) {
		
		int max=0;
		
		for(int i=0; i < input.length; i++) {
			if(max < input[i]) {
				max = input[i];
			}
		}
		
		return max;
	}
	public static int[] stringToInt (int length ,String input){
		
		String[] stringHeight = input.split(" ");
		int [] height = new int[length];
		
		for(int i=0; i< stringHeight.length; i++) {
			height[i] = Integer.parseInt(stringHeight[i]);
		}
		
		
		return height;
		
	}
	
	public static int[][] presentBuilding(int length,int[] height, int max){
		
		int[][] building = new int[length][max];
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<height[i]; j++) {
				building[i][j] = 1;
			}
		}
		
		return building;
	}
	
	public static int judgeView(int length, int max, int[][] buildings) {
		
		int result = 0;
		
		for(int i=2; i<length-1; i++) {
			
			for(int j=0; j<max; j++) {
				
				if(buildings[i][j] == 1) {
					
					if(buildings[i-2][j] != 1 && buildings[i-1][j] != 1 && buildings[i+1][j] != 1 && buildings[i+2][j] != 1) {
						result++;
					}
					
				}else {
					break;
				}
			}
		}		
		return result;
	}
}