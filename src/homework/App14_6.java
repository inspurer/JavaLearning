package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class App14_6 {

	/**
	 * @author:csu_xiaotao
	 */
	static int ClickedNumberCount = 0;
	static JTextField jtf = new JTextField("您已点击按钮"+ClickedNumberCount+"次");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    JFrame jf = new JFrame("按钮点击次数计数器");
	
	    jf.setLayout(null);
	    jf.setSize(300, 200);
	    
		JButton jb = new JButton("点击");
		jb.setBounds(110,30,60,40);
		jb.addActionListener(new MyListener());
		jf.add(jb);
		
		jtf.setBounds(90,80,100,30);
		jf.add(jtf);
		
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	static class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ClickedNumberCount++;
			jtf.setText("您已点击按钮"+ClickedNumberCount+"次");
		}
	}

}
