package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class App3_2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static String filename  = "test.txt"; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//文件内容
		String content;
		System.out.println("请输入文件内容(以‘$’结束):");
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char ch;
		while((ch = (char) br.read())!='$')
			sb.append(ch);
		content = sb.toString();
		WriteToFile(content);
		LoadToScreen();
	}

	private static void LoadToScreen() throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer readedContent = new StringBuffer();
		int aChar;
		while((aChar = br.read())!=-1)
			readedContent.append((char)(aChar));
		br.close();
		System.out.println("文件中内容是:\n"+readedContent.toString());
	}

	private static void WriteToFile(String content) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter(filename);
		fw.write(content);
		fw.close();//不关闭的话，没有保存到文件中，还在缓冲区
	}

}
