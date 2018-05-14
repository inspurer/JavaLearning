package weichat;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileWriter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String content = "中南大学\r\n通信工程1602班\r\n100023";
		/**
		 * 在大多数编程语言中,从键盘上输入的回车等效于两个字符'\r'+'\n'
		 * 'r':回到行首;'n':新起一行
		 * 这里把content设置成这样是为了模拟文本编辑中换行操作
		 * 以及字符串和数字混合和分割的问题
		 */
		String filename = "test.txt";
		writefile(content,filename);
	}
	public static void writefile(String content,String filename) throws Exception {
		FileOutputStream fos = new FileOutputStream(filename);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(content);
		bw.close();
		osw.close();
		fos.close();
	}
}
