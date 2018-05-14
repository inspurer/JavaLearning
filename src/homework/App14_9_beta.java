package homework;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * @author csu_xiaotao
 *
 */
public class App14_9_beta {

	// 文本区
	static JTextArea jta = new JTextArea("在此编辑你的心情:", 40, 80);
	static JScrollPane jsp = new JScrollPane(jta);
	// JScrollPane之中的组件显示的宽高大于JScrollPane本身的宽高时
	// 才会显示滚动条

	static JCheckBoxMenuItem style_common = new JCheckBoxMenuItem("普通");
	static JCheckBoxMenuItem style_black = new JCheckBoxMenuItem("黑体");
	static JCheckBoxMenuItem style_xie = new JCheckBoxMenuItem("斜体");

	static JRadioButtonMenuItem word_song = new JRadioButtonMenuItem("宋体");
	static JRadioButtonMenuItem word_kai = new JRadioButtonMenuItem("楷体");
	static JRadioButtonMenuItem word_black = new JRadioButtonMenuItem("黑体");

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		JFrame jf = new JFrame("App14_9_beta");
		jf.setLayout(null);// 设置为null后,jf内部的组件的setBounds方法才起作用
		jf.setSize(600, 400);

		jsp.setBounds(40, 100, 500, 200);
		jf.add(jsp);

		// 创建菜单栏
		JMenuBar jmb = new JMenuBar();
		// 创建”设置“菜单
		JMenu setMenu = new JMenu("设置");

		// 创建”字体“子菜单
		JMenu wordSet = new JMenu("字体");
		// JMenu类是JMenuItem的子类,看看把wordSet改成JMenu会怎样
		// 一般如果当前菜单下还有子菜单，将该菜单定义为JMenu类

		ButtonGroup bg = new ButtonGroup();
		bg.add(word_kai);//把单选按钮加到RadioGroup里面
		bg.add(word_black);//不加的话RadioButton和CheckBox
		bg.add(word_song);//从功能上说是一样的
		wordSet.add(word_kai);
		wordSet.add(word_black);
		wordSet.add(word_song);
		//注意不是WordSet.add(bg)这种写法
		
		//自定义FontChangeListener类
		//在一个接口里处理所有的同类事件源
		//实现java事件分发机制
		FontChangeListener fcl = new FontChangeListener();
		word_song.addActionListener(fcl);
		word_kai.addActionListener(fcl);
		word_black.addActionListener(fcl);

		// 添加子菜单“字体”到菜单“设置”
		setMenu.add(wordSet);

		// 设置“风格”子菜单
		JMenu style = new JMenu("风格");
		
		//java事件分发
		style.add(style_common);
		style_common.addActionListener(fcl);
		style.add(style_black);
		style_black.addActionListener(fcl);
		style.add(style_xie);
		style_xie.addActionListener(fcl);


		// 添加子菜单“风格”到菜单“设置”
		setMenu.add(style);

		// 设置“只读”子菜单
		JCheckBoxMenuItem readOnlyItem = new JCheckBoxMenuItem("只读");
		// 设置“只读”子菜单点击事件
		readOnlyItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
/*				System.out.println(e.getSource().equals(readOnlyItem));
*/				// TODO Auto-generated method stub
				
				//如果“只读”按钮被选中
				if (readOnlyItem.isSelected())
					//文本区设置为不可编辑
					jta.setEditable(false);
				else
					jta.setEditable(true);
			}
		});
		// 添加子菜单“只读”到菜单“设置”
		setMenu.add(readOnlyItem);

		jmb.add(setMenu);

		// "操作"菜单
		JMenu operateMenu = new JMenu("操作");
		JMenuItem exit = new JMenuItem("退出");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//在此可做一些释放内存、保存文件之类的操作
				System.exit(0);
			}
		});
		operateMenu.add(exit);
		jmb.add(operateMenu);

		jf.setJMenuBar(jmb);
		// 使用jf.add(jmb);jmb在贴左边而不是上面

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	static class FontChangeListener implements ActionListener {

		private Font newfont;
		private String word;
		private int style = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			/*//为什么要加最外面的if呢
			//先判断是哪个组件产生了事件源
			//然后判断是选中还是未选中
			//然后再做相应处理
			//java事件分发实例
*/			if (e.getSource().equals(style_common)) {
				if (style_common.isSelected())
					style += Font.PLAIN;
				else
					style -= Font.PLAIN;
			}
			else if (e.getSource().equals(style_black)) {
				if (style_black.isSelected())
					style += Font.BOLD;//粗体就是黑体？
				else
					style -= Font.ITALIC;
			}
			else if (e.getSource().equals(style_xie)) {
				if (style_xie.isSelected())
					style += Font.ITALIC;
				else
					style -= Font.ITALIC;
			}
			if(word_song.isSelected())
				word = "宋体";
			else if(word_kai.isSelected())
				word = "楷体";
			else if(word_black.isSelected())
				word = "黑体";
			newfont = new Font(word,style,16);
			jta.setFont(newfont);
		}
	}
}
