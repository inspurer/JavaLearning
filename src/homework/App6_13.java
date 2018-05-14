package homework;

import java.util.Scanner;

public class App6_13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student stu = new App6_13().new student
				("0905160212","肖涛","?",false,100,99,98);
		System.out.println("stu的性别:"+stu.getSex());
		student stu2 = new App6_13().new student();
		stu2.InputInfo();
		System.out.println("stu2的平均分:"+stu2.getAverageScore());
	}
	public class student{
		private String id = "10001";
		private String name = "小明";
		private String sex = "male";//默认为male
		private boolean isClassLeader;
		private int mathscore = 100;
		private int chinesesore = 100;
		private int englishscore = 100;
		public student() {
		}
		public void InputInfo() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入id:");
			this.setId(scanner.nextLine());
			System.out.println("请输入name:");
			this.setName(scanner.nextLine());
			System.out.println("请输入sex(male or female):");
			this.setSex(scanner.nextLine());
			System.out.println("是否是班干部？(false or true):");
			this.setClassLeader(scanner.nextBoolean());
			System.out.println("请输入Mathscore:");
			this.setMathscore(scanner.nextInt());
			System.out.println("请输入Chinesescore:");
			this.setChinesesore(scanner.nextInt());
			System.out.println("请输入Englishscore:");
			this.setEnglishscore(scanner.nextInt());
			scanner.close();
		}
		public student(String id,String name,String sex,boolean isClassLeader,
				int mathscore,int chinesescore,int englishscore) {
			this.setId(id);
			this.setName(name);
			this.setSex(sex);
			this.setClassLeader(isClassLeader);
			this.setMathscore(mathscore);
			this.setChinesesore(chinesescore);
			this.setEnglishscore(englishscore);
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id.trim();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name.trim();
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex.equals("male")|sex.equals("female")?sex:this.sex;
		}
		public boolean isClassLeader() {
			return isClassLeader;
		}
		public void setClassLeader(boolean isClassLeader) {
			this.isClassLeader = isClassLeader;
		}
		public int getMathscore() {
			return mathscore;
		}
		public void setMathscore(int mathscore) {
			this.mathscore = mathscore>=0&&mathscore<=100?mathscore:this.mathscore;
		}
		public int getChinesesore() {
			return chinesesore;
		}
		public void setChinesesore(int chinesesore) {
			this.chinesesore = chinesesore>=0&&chinesesore<=100?chinesesore:this.chinesesore;
		}
		public int getEnglishscore() {
			return englishscore;
		}
		public void setEnglishscore(int englishscore) {
			this.englishscore = englishscore>=0&&englishscore>=100?englishscore:this.englishscore;
		}
		public int getTotalScores() {
			return mathscore+chinesesore+englishscore;
		}
		public int getAverageScore() {
			return getTotalScores()/3;
		}
	}

}
