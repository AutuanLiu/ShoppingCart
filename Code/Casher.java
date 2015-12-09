import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
@SuppressWarnings("serial")
public class Casher extends Frame
{
	private Label l1;
    public Casher() 
    {
        setTitle("收银台"); //设置窗口的名称
        setLayout(new BorderLayout());  //布局
        l1=new Label("结账成功，欢迎下次再来！",Label.CENTER);
        add(l1,BorderLayout.CENTER);
        setBounds(0,385,400,150);
        setVisible(true);
        addWindowListener(new WinClose());//使窗口的 × 生效   
    }
    private class WinClose extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            (e.getWindow()).dispose();
        }
    }
}
