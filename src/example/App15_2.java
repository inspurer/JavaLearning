package example;
//App15_2.java            手工绘画程序
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
public class App15_2 extends JFrame
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x1,y1,x2,y2;
  private NewPanel panel=new NewPanel();
  App15_2()
  {
    setTitle("交互式绘图");
    setBounds(10,10,250,200);
    add(panel);
  }
  public static void main(String[] args)
  {
    App15_2 frm=new App15_2();
    frm.setVisible(true);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  class MyMouseList extends MouseAdapter
  {
    public void mousePressed(MouseEvent e)
    {
      x1= e.getX();
      y1= e.getY();
    }
  }
  class MyMouseMotionList extends MouseMotionAdapter
  {
    public void mouseDragged(MouseEvent e)
    {
      x2= e.getX();
      y2= e.getY();
      Graphics g=panel.getGraphics();
      g.drawLine(x1,y1,x2,y2);
      x1=x2;
      y1=y2;
    }
  }
  private class NewPanel extends JPanel 
  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewPanel()
    {
      this.addMouseMotionListener(new MyMouseMotionList());
      this.addMouseListener(new MyMouseList());
    }
  }
}
