package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App10_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int[15];
		FileWriter fw;
		for(int i =0; i<15; i++) {
			a[i] = (int)(Math.random()*9997)+20;
			System.out.println(a[i]);
		}
		try {
			fw = new FileWriter("file2.txt");
			BufferedWriter bw = new  BufferedWriter(fw);
			for(int i =0; i<15; i++) {
				bw.write(String.valueOf(a[i]));
				bw.write("\r\n");
			}
			bw.flush();
			fw.close();
			BufferedReader br = new BufferedReader(new FileReader("file2.txt"));
			for(int i=0; i<15; i++) {
				a[i] = Integer.parseInt(br.readLine());
				/*System.out.println(a[i]);*/
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp;
		boolean flag = true;
		for(int i=0; i<a.length-1; i++) {
			for(int j=0 ;j<a.length-i-1; j++) {
				if(a[j]>a[j+1]) {
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
					flag = false;
				}
			}
			if(flag) break;
		}
		System.out.println("排序后");
		for(int i =0; i<15; i++) {
			System.out.println(a[i]);
		}
	}

}
