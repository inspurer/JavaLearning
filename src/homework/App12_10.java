package homework;
import java.util.*;
public class App12_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ComName = {"Google","FaceBook","Apple","Microsoft","Huawei"
				,"Alibaba","Tencent"};
		String [] ComNumber = {"100001","100002","100003","100004","100005"
				,"10006","10007"};
		HashMap <String,String> hm = new HashMap <String,String>();
		for(int i=0; i<ComName.length; i++) {
			hm.put(ComName[i], ComNumber[i]);
		}
		int index = (int) (Math.random()*hm.size());
		String key = ComName[index];
	    System.out.println("HashMap电话簿中包含"+key+"?  "+hm.containsKey(key));
		hm.remove(key);
	    System.out.println("HashMap电话簿中包含"+key+"?  "+hm.containsKey(key));

	}

}
