//模拟超市的购物车
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
@SuppressWarnings("serial")
public class ShoppingCart extends Frame 
{
	private TextArea ta1;
	private Label lb1,lb2;
	private Button bt1;
	private String msg;
	private Font font;
	public ShoppingCart()throws IOException//构造函数
	{
		setTitle("购物车"); //设置窗口名字
		setLayout(new BorderLayout());
		addWindowListener(new WinClose());//使窗口的 × 生效
		setBounds(385,15,600,370);//设置窗口位置
        setVisible(true);
        //布局管理
        font=new Font("TimesRoman",Font.BOLD,16);//设置字体
        ta1=new TextArea(10,25);
        ta1.setEditable(false);//设为不可编辑，只作为显示窗口
        bt1=new Button("确定");
        bt1.setBackground(Color.cyan);
        bt1.setFont(font);
        lb1=new Label("购物车清单",Label.CENTER);
        lb1.setBackground(Color.green);
        lb2=new Label((new Date()).toString());
        add(lb1,BorderLayout.NORTH);
        add(lb2,BorderLayout.WEST);
        add(ta1,BorderLayout.CENTER);
        add(bt1,BorderLayout.EAST);
        bt1.addActionListener(new Click());
        msg=LogIO.fwrite(); //直接采用类名调用
        ta1.setText(msg);   
	}
	class Click implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)//对响应bt1的处理
        { 
        	  try
        	  {
        		ta1.setText("\n\n\n\n\n\n\n\n\n\n\n\t  谢谢你的光临，欢迎下次再来！O(∩_∩"); 
        	  }
        	  catch(Exception e2)//异常处理
        	  {
        		  e2.printStackTrace();
        	  }
        }
	}
	class WinClose extends WindowAdapter
    {
    	@Override
    	public void windowClosing(WindowEvent e)
    	{
    		(e.getWindow()).dispose();
    	}
    }
}
