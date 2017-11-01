package solution;

import java.util.Scanner;

class Solution {
   static int Answer;

   public static void main(String args[]) throws Exception   {
      Scanner sc = new Scanner(System.in);
      //Scanner sc = new Scanner(new FileInputStream("input.txt"));

      int T = sc.nextInt();
      for(int test_case = 0; test_case < T; test_case++) {

         System.out.println("Case #"+(test_case+1));
         System.out.println(Answer);
      }
   }
}