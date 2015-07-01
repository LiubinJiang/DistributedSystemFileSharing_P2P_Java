package tests;

import thread.LookupThread;

public class testThread {

	public static void main(String[] args) {
		System.out.println("multiple look up test");
		
		for(int i=0;i<100;i++){
			new LookupThread(i);
		}
		

	}

}
