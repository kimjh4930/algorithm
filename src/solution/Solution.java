package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
	
	static Map<Integer, Integer> clientMap = new HashMap<Integer, Integer>();
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = Integer.parseInt(sc.nextLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			
			String value1 = sc.nextLine();
			String[] valueArray = value1.split(" ");
			
			int clients = Integer.parseInt(valueArray[0]);
			int interval = Integer.parseInt(valueArray[1]);
			int bread = Integer.parseInt(valueArray[2]);
			int time = 0;
			boolean possible = true;
			
			int currentBread = 0;
			
			getClientTimeInfo(sc.nextLine());
			
			if(clientMap.containsKey(0)){
				possible = false;
			}
			
			while(possible){
				
				time++;
				
				if(time % interval == 0){
					currentBread += bread;
				}
				if(clientMap.containsKey(time)){
					currentBread -= clientMap.get(time);
					
					clientMap.remove(time);
					
					if(currentBread < 0 ){
						possible = false;
						break;
					}
					
					if(clientMap.size() == 0){
						break;
					}
				}
			}
			
			if(possible == false){
				System.out.println("#" + (test_case + 1) + " Impossible");
			}else{
				System.out.println("#" + (test_case + 1) + " Possible");
			}
			
			clientMap.clear();
		}
	}
	
	public static void getClientTimeInfo (String clientArrivalTime){
		
		String[] clientInfoArray = clientArrivalTime.split(" ");
		
		for(int i=0; i<clientInfoArray.length; i++){
			
			int key = Integer.parseInt(clientInfoArray[i]);
			
			if(clientMap.containsKey(key)){
				int value = clientMap.get(key);
				value++;
				clientMap.replace(key, value);
			}else{
				clientMap.put(key, 1);
			}
			
		}
	}
}







