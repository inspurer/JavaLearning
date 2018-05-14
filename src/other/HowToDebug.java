package other;
public class HowToDebug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i<20; i++)
			System.out.println(i);
	}

}
/**
 * 1、在程序里面放置一个断点，也就是双击需要放置断点的程序左边的栏目上。
 * 2、点击那个虫子样子的按钮，或者右键单击该程序，选择debug as -> java application
 * 3、按F5就是一层层深入的debug相当于剥葱样，按F6就是一步步debug，不理会深层次运作，
 * 按F7就是不管当前位置有多深，都跳转到断点设置的那一层代码，按F8就是停止debug，运行完程序
 * 另，在debug时，会有很多有用信息显示在debug框里面，需要自己实践，
 * 鼠标移到变量上时会有当前变量的属性值
 * 补充：你可以看一看eclipse的配置项，有一个快捷键的说明，具体在哪里我不清楚（出差中，没有装那些东西）
 */
/**
 * eclipse从调试模式返回正常模式，可以通过点击右上方的eclipse按钮进行切换。
   调试模式在右上角的界面显示为DEBUG图标，正常模式为eclipse的图标，只要手动点击便可自由切换。
 */
