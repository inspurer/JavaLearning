package homework;

import java.util.ArrayList;

public class App12_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al =new ArrayList<String>();
		al.add("你好");
		al.add("hello");
		al.add("hi");
		int index = (int)(Math.random()*al.size());
		System.out.println(al.get(index));
		
	}

}
