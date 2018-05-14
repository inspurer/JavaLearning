//App15_1.java         简单的绘图程序
package example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App15_1 extends JFrame 
{ 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
static JButton bnt1 =new JButton("画圆");
  static JButton bnt2 =new JButton("画椭圆"); 
  static JPanel pan = new MyPanel();
  static App15_1 frm = new App15_1();
  static int circle=0;
  public static void main(String[] args)
  {
    frm.setVisible(true);
    frm.setTitle("简单绘图应用程序");
    frm.setSize(300,250);
    frm.setLayout(null); 
    frm.add(pan);
    pan.setBounds(0,0,300,250);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
  } 
  static class MyPanel extends JPanel implements ActionListener
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyPanel()
    {          
      this.add(bnt1);   this.add(bnt2);      
      bnt1.addActionListener(this);
      bnt2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
      JButton bt=(JButton)e.getSource();
      if (bt==bnt1) circle=1;
      else circle=2;
      @SuppressWarnings("unused")
	Graphics g=this.getGraphics();
      repaint();
    }
    public void paintComponent(Graphics g)
    {
       //super.paintComponent(g);
       bnt1.setBounds(50,180,80,25);
       bnt2.setBounds(150,180,80,25);
       g.setFont(new Font("楷体",Font.ITALIC,20));
       g.setColor(Color.RED);
       g.drawString("画圆或椭圆",100,30);
       if (circle==1) g.drawOval(100,70,70,70);
       else if (circle==2) g.drawOval(80,40,70,120);
    }
  }
}
