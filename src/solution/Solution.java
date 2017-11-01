package solution;

import java.util.Scanner;

class Solution {
	static int Answer;
	static int pointX, pointY;
	static int[] x, y;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = Integer.parseInt(sc.nextLine());
		
		x = new int[2];
		y = new int[2];

		for (int test_case = 0; test_case < T; test_case++) {

			String input = sc.nextLine();
			
			String values[] = input.split("\\s");
			
			getPoint(input);
			
			pointX = x[0] + x[1];
			pointY = y[0] + y[1];
			
			
			System.out.println("#" + (test_case + 1) + " " + getResult(pointX, pointY));
		}
	}
	
	public static int getResult(int x, int y){
		
		int result=0;
		int index=1;
		int xIndex, yIndex;
		
		//add x
		for(xIndex = 0; xIndex <= x; xIndex++){
			result += xIndex;
		}
		
		xIndex -= 1;
		
		//add y
		for(index=0 ; index < y-1; index++){
			
			result = result+xIndex;
			xIndex++;
		}
		
		return result;
		
	}
	
	public static void getPoint(String input){
		
		String values[] = input.split("\\s");
		
		for(int i=0; i<2; i++){
			
			int index = 0;
			int result = 1;
			
			int tempX=0, tempY=0;
			
			int value = Integer.parseInt(values[i]);
			
			while(true){
				index++;
				
				result += index;
				
				if(result > value){
					result -= index;
					break;
				}
				
			}
			
			int sumIndex = index + 1;
			int times = 0;
			
			while(true){
				
				times++;
				
				if(value == result){
					tempX = times;
					tempY = sumIndex - times;
					
					break;
				}
				
				result++;
			}
			x[i] = tempX;
			y[i] = tempY;
			
			//System.out.println("( " + x[i] + " , " + y[i] + " )");
			
		}
		
	}
}