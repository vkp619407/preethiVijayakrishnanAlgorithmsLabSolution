package com.gl.currencydenomination.denominationCounter;

import java.util.Scanner;

import com.gl.currencydenomination.sort.MergeSort;

public class CounterDisplay {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort mergeSort = new MergeSort();
		System.out.println("Enter the size of currency denominations");
		int size = sc.nextInt();
		
		int[] currencyDenomination = new int[size];
		System.out.println("Enter the currency denominations value");
		for(int i =0;i<size;i++) {
			currencyDenomination[i]=sc.nextInt();
		}
		System.out.println("Enter the amount you want to pay");
		int amountToPay = sc.nextInt();
		int[] counter = new int[size];
		mergeSort.mergeSort(currencyDenomination, 0, size-1);
		
		int remAmount = countNotes(currencyDenomination,counter,0,size-1,amountToPay);
		if(remAmount>0) {
			System.out.println("Amount cannot be paid in given denominations");			
		}
		for(int i=size-1;i>=0;i--) {
			if(counter[i]>0) {
				System.out.println(currencyDenomination[i]+" : "+counter[i]+" = " +currencyDenomination[i]*counter[i]);
			}
		}	

	}
	
	
	public static int countNotes(int[] currencyDenomination,int[] counter, int low, int high, int amountToPay) {
		if(amountToPay==0) {
			return 0;
		}
		if(amountToPay < currencyDenomination[0]) {
			return amountToPay;
		}
		if(amountToPay >= currencyDenomination[high]) {
			counter[high] = amountToPay / currencyDenomination[high];
			amountToPay = amountToPay % currencyDenomination[high];
			return countNotes(currencyDenomination, counter, 0, high-1, amountToPay);
		}
		int mid= (low + high) / 2;
		if(amountToPay <= currencyDenomination[mid]) {
			return countNotes(currencyDenomination, counter, 0, mid, amountToPay);
		}
		return countNotes(currencyDenomination,counter,0,high-1,amountToPay);
	}

}
