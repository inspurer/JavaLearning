package homework;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App13_10 {
	static int count = 0;
	static JCheckBox jcb1 = new JCheckBox("青莲剑歌:李白");
	static JCheckBox jcb2 = new JCheckBox("月光之女:露娜");
	static JCheckBox jcb3 = new JCheckBox("齐天大圣:孙悟空");
	static JCheckBox jcb4= new JCheckBox("圣骑之力:亚瑟");
	
	static JRadioButton jrb1 = new JRadioButton("娜可露露");
	static JRadioButton jrb2 = new JRadioButton("甄姬");
	static JRadioButton jrb3 = new JRadioButton("小乔");
	static JRadioButton jrb4 = new JRadioButton("鲁班七号");
	
	static JTextArea jta = new JTextArea("在此输入您对问题的建议:",10,30);
	static JScrollPane jsp = new JScrollPane(jta);
	
	static JButton jb = new JButton("提交答案");
	
	static JTextField jtf = new JTextField("提交后在此看作答结果");
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("王者问答");
		jf.setLayout(null);
		jf.setSize(600, 600);
		jf.getContentPane().setBackground(new Color(0, 191, 255));
		
		JLabel jlq1 = new JLabel("1.下面哪些英雄的定位是刺客？", JLabel.LEFT);
		JLabel jlq2 = new JLabel("2.在大多数情况下，下面哪个英雄更适合打野？", JLabel.LEFT);
		Font fnt = new Font("楷体", Font.BOLD, 16);
/*		Font fnt = new Font("Consolas",Font.BOLD+Font.ITALIC,20);
*/		jlq1.setOpaque(true);
		jlq1.setBackground(Color.white);
		jlq1.setForeground(Color.BLACK);
		jlq1.setLocation(15, 25);
		jlq1.setSize(500, 25);
		jlq1.setFont(fnt);
		jlq2.setOpaque(true);
		jf.add(jlq1);
		jlq2.setBackground(Color.white);
		jlq2.setForeground(Color.BLACK);
		jlq2.setLocation(15, 200);
		jlq2.setSize(500, 25);
		jlq2.setFont(fnt);
		jf.add(jlq2);
		
		/*jcb1.setBounds(x, y, width, height);*/
		jcb1.setBounds(20,75, 130, 20);
		jcb2.setBounds(20,100, 130, 20);
		jcb3.setBounds(20,125, 130, 20);
		jcb4.setBounds(20,150, 130, 20);
		jf.add(jcb1);
		jf.add(jcb2);
		jf.add(jcb3);
		jf.add(jcb4);
		/*for(int i =0,y = 75; i<4; i++) {
			jcb[0].setBounds(20, y, 130, 20);
			y += 25;
		}*/
		jrb1.setBounds(20,250,80,20);
		jrb2.setBounds(120,250,80,20);
		jrb3.setBounds(220,250,80,20);
		jrb4.setBounds(320,250,80,20);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		jf.add(jrb1);
		jf.add(jrb2);
		jf.add(jrb3);
		jf.add(jrb4);
		/*ButtonGroup bg = new ButtonGroup();
		for(int i=0, x=20; i<4; i++) {
			jrb[0].setBounds(x, 250, 80, 20);
			bg.add(jrb[i]);
			jf.add(jrb[i]);
			x += 100;
		}*/
		
		jsp.setBounds(15,300,500,150);
		jf.add(jsp);
		
		jb.setBounds(230,460,100,20);
		jb.addActionListener(new MyListener());
/*		jb.setToolTipText("点击按钮提交答案");
*/		jf.add(jb);
		
        jtf.setBounds(120,500,300,25);
        jtf.setEnabled(false);
        jtf.setDisabledTextColor(Color.red);
        jf.add(jtf);
        
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}
	public static class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			count++;
/*			jtf.setText("系统已收到你的提交，正在检测答案");
*//*			jb.setText("监测答案中"); ？？？为什么都设置失效？
*/			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
/*			jb.setToolTipText("答案已提交，暂时不能重复提交");
*/			jb.setEnabled(false);
            StringBuffer sb = new StringBuffer();
			if(jcb1.isSelected()&&jcb2.isSelected()
					&&jcb3.isSelected()&&!jcb4.isSelected())
				sb.append("第一题作答正确;");
			else 
				sb.append("第一题作答错误;");
			if(jrb1.isSelected()) 
				sb.append("第二题作答正确");
			else 
				sb.append("第二题作答错误");
			jtf.setText(sb.toString());
			String backContent = jta.getText().replaceAll("在此输入您对问题的建议:"
					,"");
			if(backContent.isEmpty()|backContent.equals("")) {
				System.out.println("第"+count+"次提交，答题者没有反馈信息");
			}
			else
				System.out.println("第"+count+"次提交，答题者的反馈信息是:"+backContent);
			jcb1.setSelected(false);
			jcb2.setSelected(false);
			jcb3.setSelected(false);
			jcb4.setSelected(false);
			/*jrb1.setSelected(false);
			jrb2.setSelected(false);
			jrb3.setSelected(false);
			jrb4.setSelected(false);*///为什么设置无效？
			/*for(int i =0; i<4;  i++) {
				jrb[i].setSelected(false);
				jcb[i].setSelected(false);
			}*/
			jta.setText("在此输入您对问题的建议:");
			jb.setText("提交答案");
			jb.setEnabled(true);
		}
	}
}