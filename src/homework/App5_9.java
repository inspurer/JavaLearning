package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App5_9 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入字符串:");
		String parent = br.readLine();
		System.out.println("请输入要删除的字符:");
		String children = br.readLine();
		String child = children.substring(0,1);
		System.out.println(child);
		parent = parent.replaceAll(child, "");
		System.out.println(parent);
	}

}
