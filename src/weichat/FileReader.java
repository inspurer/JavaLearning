package weichat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String content = readfile("test.txt");
		System.out.println(content);
		ArrayList<Integer> Numbers =getNumbers(content);
		System.out.println("班级编号:"+Numbers.get(0)+"\t学号:"+Numbers.get(1));
	}
	public static  ArrayList<Integer> getNumbers(String content) {
		StringBuffer aNumber = new StringBuffer();
		ArrayList<Integer> Numbers =new ArrayList<Integer>();;
		for(int i = 0; i<=content.length(); i++) {
			char ch = content.charAt(i);
			while(ch>='0'&&ch<='9') {
				aNumber.append(ch);
				i++;
				if(i==content.length()) break;
				ch = content.charAt(i);
			}
			if(aNumber.length()>0) {
				Numbers.add(Integer.parseInt(aNumber.toString()));
				aNumber.delete(0, aNumber.length());
			}
		}
		return Numbers;
	}
	public static String readfile(String filename) throws Exception{//原样读取
		BufferedReader br=new BufferedReader(new InputStreamReader
				(new FileInputStream(filename),"UTF-8"));  
		StringBuffer lines = new StringBuffer(); 
		/**
		 * StringBuffer是一个动态字符串类，常用此类对象的append()方法来链接字符串
		 * 其实也可以用String类的”+“代替，但是前者性能明显优于后者
		 * 最后要用StringBuffer类的toString()方法转成String
		 * 这样才能使用String类强大而灵活的API
		 */
		int count = 0;
		 while((count=br.read())!=-1){  
			 //read方法返回一个整数，用(char)转为字符
             lines.append((char)count);  
         } 
		 br.close();
		 return lines.toString();
	}

}
