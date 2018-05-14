package lab;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App2_2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int NumCount =0 ,WordCount = 0 ,Others;
		BufferedReader  br = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("输入字符串:");
		String str = br.readLine();
		str = str.toLowerCase();//全部转化为小写，便于判断
		for(int i =0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch>='0'&&ch<='9')
				NumCount++;
			if(ch>='a'&&ch<='z')
			    WordCount++;
		}
		Others = str.length()-WordCount-NumCount;
		System.out.print("字符串中有数字"+NumCount+"个、");
		System.out.print("以及字母"+WordCount+"个");
		System.out.println("和"+Others+"个其他字符");
	}

}
