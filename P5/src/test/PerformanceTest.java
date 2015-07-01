package test;


import java.util.concurrent.*;

import method.Lookup;

public class PerformanceTest {
	private static int total=200;
	private final static CountDownLatch start=new CountDownLatch(1);
	private final static CountDownLatch done=new CountDownLatch(200);

	public static void main(String[] args) {
		System.out.println("performance test 1 peer load");
		long startTime=System.currentTimeMillis();
		Lookup lk=new Lookup();
		String[] result=new String[10];
		for(int messageID=0;messageID<200;messageID++){
			for(Integer i=0;i<10;i++){
				result[i]=lk.lookupFile(messageID+i.toString(), 5,i.toString()+"k.txt", "mesh");
				System.out.println(messageID+" "+i+"th time"+ result[i]);
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("average time "+(endTime-startTime)/2000);
		
	}

}
