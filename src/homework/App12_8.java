package homework;
import java.util.*;
public class App12_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		HashSet <Integer> hs = new HashSet<Integer>(size);
		Random rd = new Random();
		for (int i=0; i<size; i++) {
			int RNumber = rd.nextInt(size);
			if(hs.add(RNumber))
				System.out.println("添加数字"+RNumber+"成功！");
			else
				System.out.println("数字"+RNumber+"重复!");
		}
		System.out.println("HashSet中共有"+hs.size()+"个元素,分别是:");
		Iterator<Integer> it = hs.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

}
