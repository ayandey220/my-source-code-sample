package edu.learn.displaytag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestList {
	public List<Test> getList(){
		System.out.println("called ...");
		List<Test> list = new ArrayList<Test>();
		for(int i = 0 ; i < 100; i++){
			Test test = new Test();
			test.setRow(i);
			int r = new Random().nextInt(255);
			test.setId(r);
			test.setName("Test string " + r);
			list.add(test);
		}
		
		return list;
	}	
}
