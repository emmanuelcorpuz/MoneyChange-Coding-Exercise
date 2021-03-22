package com.rocketmiles;

import java.util.Arrays;
import java.util.Map;

public class CashRegister {

	private Cash[] cashSlots;
	private final int INF = 100000;

	public CashRegister() {

	}
	
	public CashRegister(Map<Integer, Integer> denomTable) {
		Cash[] cashSlots = new Cash[denomTable.size()];
		for (int i = 0; i < denomTable.size(); i++) {
			Cash cash = new Cash(0, denomTable.get(i).intValue());
			cashSlots[i] = cash;
		}
		this.cashSlots = cashSlots;
	}

	public void show() {
		System.out.print("$" + getTotal() + " ");
		System.out.println(Arrays.toString(this.cashSlots));
	}	

	private int getTotal() {
		int tot = 0;
		if (this.cashSlots != null) {
			for (Cash cash : this.cashSlots) {
				tot = tot + (cash.getCount() * cash.getDenomination());
			}
		}
		return tot;
	}	

	public void put(String[] input, Map<Integer, Integer> denomTable) {
		if (this.cashSlots != null) {
			for (int i = 0; i < input.length; i++) {
				Cash cash = this.cashSlots[i];
				cash.setCount(cash.getCount() + Integer.parseInt(input[i]));
			}
		}
		show();
	}

	public boolean take(String[] input, Map<Integer, Integer> denomTable) {
		if (this.cashSlots != null) {
			Cash[] cashOriginal = new Cash[this.cashSlots.length];
			for (int i = 0; i < this.cashSlots.length; i++) {
				cashOriginal[i] =  new Cash(this.cashSlots[i].getCount(), this.cashSlots[i].getDenomination());
			}
			
			for (int i = 0; i < input.length; i++) {
				Cash cash = this.cashSlots[i];
				cash.setCount(cash.getCount() - Integer.parseInt(input[i]));
				if (cash.getCount() < 0) {
					System.out.println("sorry");
					this.cashSlots = cashOriginal;
					return false;
				}
			}
		} else {
			System.out.println("sorry");
			return false;
		}
		return true;
	}

	public void change(int amount, Map<Integer, Integer> denomTableReverse, Map<Integer, Integer> denomTable) {
		Cash[] change = new Cash[denomTable.size()];
		for (Map.Entry<Integer, Integer> entry : denomTable.entrySet()) {
			change[entry.getKey()] = new Cash(0, entry.getValue());
		}
		
		Cash[] cashCopy = new Cash[this.cashSlots.length];
		for (int i = 0; i < this.cashSlots.length; i++) {
			cashCopy[i] =  new Cash(this.cashSlots[i].getCount(), this.cashSlots[i].getDenomination());
		}
		
		while (amount > 0) {
			amount = changeMethod(cashCopy, amount, denomTableReverse, change);
		}
		if (amount == 0) {
			String[] changeCount = new String[change.length];
			for(int j=0; j < change.length; j++) {
				changeCount[j] = String.valueOf(change[j].getCount());
			}
			
			if (take(changeCount, denomTable)) {
				System.out.println(Arrays.toString(change));
			}
		}
	}

	private int changeMethod(Cash d[], int n, Map<Integer, Integer> denomTableReverse, Cash change[]) {
		int k = d.length - 1;
		int[] M = new int[n+1];
		M[0] = 0;
		int[] S = new int[n+1];
		S[0] = 0;
		for(int j=1; j<=n; j++) {
			int minimum = INF;
			int coin = 0;
			for(int i=1; i<=k; i++) {
				if (d[i].getCount() == 0)
					continue;
				if(j >= d[i].getDenomination()) {
					if((1+M[j-d[i].getDenomination()]) < minimum) {
						minimum = 1+M[j-d[i].getDenomination()];
						coin = i;
					}
				}
			}
			M[j] = minimum;
			S[j] = coin;
		}
		int l = n;
		while(l>0) {
			if (denomTableReverse.get(d[S[l]].getDenomination()) == null)  {
				System.out.println("sorry");
				return -1;
			}
			Cash c = change[denomTableReverse.get(d[S[l]].getDenomination())];
			c.setCount(c.getCount() + 1);
			l = l-d[S[l]].getDenomination();
			d[S[l]].setCount(d[S[l]].getCount() - 1);
			if (l < 0)  {
				System.out.println("sorry");
				return -1;
			}
			if (d[S[l]].getCount() == 0) {
				return l;
			}
		}
		return l;
	}

	public Cash[] getCashSlots() {
		return cashSlots;
	}

	public void setCashSlots(Cash[] cashSlots) {
		this.cashSlots = cashSlots;
	}
}
