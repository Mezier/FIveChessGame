package com.seecen;

public class CheckWin {
     public static int heng(int allchess[][], int i, int j){
    	 int sum=1;
    	 int color=allchess[i][j];  // 1 2
    	 int right=1;
    	 int left=1;
    	 while(i+right<18&&allchess[i+right][j]==color){
    		 sum++;
    		 right++;
    	 }
    	 while(i-left>=0&&allchess[i-left][j]==color){
    		 sum++;
    		 left++;
    	 } 	 
    	 return sum;
     }
     
     public static int cong(int allchess[][], int i, int j){
    	 int sum=1;
    	 int up=1;
    	 int down=1;
    	 int color=allchess[i][j];
    	 while(color==allchess[i][j-up]){
    		 sum++;
    		 up++;
    	 }
    	 while(color==allchess[i][j+down]){
    		 sum++;
    		 down++;
    	 }
    	 return sum;
     } 
     
}
