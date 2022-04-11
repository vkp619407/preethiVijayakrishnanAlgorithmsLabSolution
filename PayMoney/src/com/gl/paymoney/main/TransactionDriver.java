package com.gl.paymoney.main;

import java.util.Scanner;

public class TransactionDriver {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the size of transaction ");
		int size = sc.nextInt();		
		System.out.println("Enter the values of array ");
		int[] transactions = new int[size];
		int[] transactionCumulative = new int[size];
		//getting transactions and cumulative transaction		
		for(int  i = 0; i<size;i++) {
			transactions[i] = sc.nextInt();
			transactionCumulative[i] = ((i==0)?0:transactionCumulative[i-1])+transactions[i];
		}		

		System.out.println("Enter the total no of targets that needs to be achieved ");
		int noOfTransactions = sc.nextInt();
		
		for (int i = 0 ; i<noOfTransactions; i++) {
			System.out.println("Enter the value of target "+(i+1)+": ");
			int value = sc.nextInt();
			int achievedTarget = checkTarget(transactionCumulative,0,size-1, value);
			if(achievedTarget < 0) {
				System.out.println("Given target is not achieved");
			}
			System.out.println("Target achieved after "+achievedTarget+" transactions");
		}		
	}

	public static int checkTarget(int[] cumulativeTrans, int low, int high,int target) {
		if(cumulativeTrans[cumulativeTrans.length-1]< target) {
			return -1;
		}
		if(cumulativeTrans[0]>target) {
			return 1;
		}
		if(low > high) {
			return -1;
		}
		int mid = (low + high)/2;
		if(target<=cumulativeTrans[mid]) {
			return target> cumulativeTrans[mid-1]? mid +1 : checkTarget(cumulativeTrans, low, mid-1, target);
		}
		return checkTarget(cumulativeTrans, mid +1, high, target);
	}

	

}
