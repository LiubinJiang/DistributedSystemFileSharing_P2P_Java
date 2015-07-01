package test;

import method.LocalLookup;
import method.Lookup;
import method.PullMethod;
import method.UpdateList;

public class FunctionTest {

	public static void main(String[] args) {
		//add to pull list test
		/*
		UpdateList ul=new UpdateList();
		ul.addtoPull("0", "1k.txt","5000");
		*/
		
		//update pull list or delete pull list test
		
		  PullMethod pm=new PullMethod();
		  //Delete pull list Test
		  pm.pullChanges("1k.txt", "0");
		//LocalLookup ll=new LocalLookup();
		//ll.LookupResult("1k.txt");

	}

}
