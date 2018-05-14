package lab;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author csu_xiaotao
 * 上午10:11:20
 * 2018年4月17日
 */
public class App3_1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean isInputRightly = false;
		System.out.println("请输入小写字母:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!isInputRightly) {
			try {
				char ch = (char) br.read();
				new App3_1().new CharChecker(ch).checkchar();
				isInputRightly = true;
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyException e) {
				//自定义异常，多态技术
				// TODO Auto-generated catch block
				System.out.println("Orz...发生异常\n异常名:" + e.getClass() + "\n异常信息:" + e.HandleException());
				System.out.println("请重新输入:");
				String ExceptionInfo = e.getClass().getName();
				String ExceptionName = ExceptionInfo.substring(
						ExceptionInfo.lastIndexOf('$')+1);
/*				System.out.println(ExceptionName);
*/				if(!ExceptionName.equals("NullInputException"))
					br.read();// 接收'\r'
				br.read();// 接收'\n'
			}
		}
	}

	class CharChecker {
		private char checker;

		public CharChecker(char input) {
			checker = input;
		}

		public void checkchar() throws MyException {
			if (checker >= 'A' && checker <= 'Z')
				throw new UppercaseException(checker);
			else if (checker == '\r' || checker == ' ' || checker == '\t')
				throw new NullInputException(checker);
			else if (checker >= 'a' && checker <= 'z')
				System.out.println("您正确输入了小写字母:" + checker+
						"\n转成大写字母是"+(char)(checker+'A'-'a'));
			else
				throw new OtherCharException(checker);
		}

	}

	//自定义异常的抽象类，定义了一些必须在子类实现的抽象方法
	abstract class MyException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private char input;

		public MyException(char input) {
			this.input = input;
		}

		abstract String HandleException();
	}

	class UppercaseException extends MyException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public UppercaseException(char input) {
			super(input);
			// TODO Auto-generated constructor stub
		}

		@Override
		String HandleException() {
			// TODO Auto-generated method stub
			return "输入了大写字母:" + super.input;
		}

	}

	class NullInputException extends MyException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NullInputException(char input) {
			super(input);
			// TODO Auto-generated constructor stub
		}

		@Override
		String HandleException() {
			// TODO Auto-generated method stub
			return "用户无输入";
		}

	}

	class OtherCharException extends MyException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5999031412269334172L;

		public OtherCharException(char input) {
			super(input);
			// TODO Auto-generated constructor stub
		}

		@Override
		String HandleException() {
			// TODO Auto-generated method stub
			return "输入了其他字符:" + super.input;
		}

	}

}
