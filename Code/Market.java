//模拟超市的场景
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
@SuppressWarnings("serial")
public class Market extends Frame  
{ 
    //变量的构造
    private String msg;
    private Label l1,label0,label,label1,label2,label3,label4,label5,label6,label7;
    private Button button0,button1,button2,button3;
    private TextField t0,t,t1,t2,t3,t4,t5,t6;
    private Panel panel1,panel2;
    private static float sum=0.0f;
    private Font font;
    public Market() //构造函数
    {
        setTitle("欢迎选购商品");
        setLayout(new BorderLayout());
        font=new Font("TimesRoman",Font.BOLD,16);//字体的设置
		label0=new Label("苹果：3元/斤",Label.CENTER);
		label=new Label("衬衫：128元",Label.CENTER);
		label1=new Label("纸巾：3元",Label.CENTER);
		label2=new Label("钢笔：5元",Label.CENTER);
		label3=new Label("沐浴露：20元",Label.CENTER);
		label4=new Label("方便面：2.5元",Label.CENTER);
		label5=new Label("笔记本：4.5元",Label.CENTER);
		label6=new Label("商品名称及单价",Label.CENTER);
		label6.setBackground(Color.orange);
		label7=new Label("购买数量",Label.CENTER);
		label7.setBackground(Color.orange);
		button0=new Button("修改购物车");
		button0.setBackground(Color.green);
		button0.setFont(font);
		button1=new Button("加入购物车");
		button1.setBackground(Color.green);
		button1.setFont(font);
		button2=new Button("查看购物车");
		button2.setBackground(Color.green);
		button2.setFont(font);
		button3=new Button("确认付款");
		button3.setBackground(Color.green);
		button3.setFont(font);
		t0=new TextField("0",4);
		t=new TextField("0",4);
		t1=new TextField("0",4);
		t2=new TextField("0",4);
		t3=new TextField("0",4);
		t4=new TextField("0",4);
		t5=new TextField("0",4);
		t6=new TextField("Tips：欢迎光临本店！",30);
		t6.setEditable(false);
		addWindowListener(new WinClose());//使窗口的 × 生效
		panel1=new Panel();
		panel2=new Panel();
		panel1.setLayout(new GridLayout(10,2));//布局管理
		panel1.add(label6);
		panel1.add(label7);
		panel1.add(label0);
		panel1.add(t0);
		panel1.add(label);
		panel1.add(t);
		panel1.add(label1);
		panel1.add(t1);
		panel1.add(label2);
		panel1.add(t2);
		panel1.add(label3);
		panel1.add(t3);
		panel1.add(label4);
		panel1.add(t4);
		panel1.add(label5);
		panel1.add(t5);
		panel1.add(new Label());
		panel1.add(new Label());
		panel1.add(button0);
		panel1.add(button1);
		button0.addActionListener(new B0()); //加入监听
		button1.addActionListener(new B1()); //加入监听
		panel2.setLayout(new BorderLayout());
		panel2.add(t6);
		panel2.add(button2);
		panel2.add(button3);
		button2.addActionListener(new B2()); //加入监听
		button3.addActionListener(new B3()); //加入监听
		panel2.add(t6,BorderLayout.NORTH);
		panel2.add(button2,BorderLayout.WEST);
		l1=new Label("",Label.CENTER);
		l1.setText("总计消费："+sum);
		l1.setBackground(Color.CYAN);
		panel2.add(l1,BorderLayout.CENTER);
		panel2.add(button3,BorderLayout.EAST);
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.CENTER);
		setBounds(0,15,400,370);
		setVisible(true);
		validate();
		t6.setText("Tips：欢迎光临本店，购物愉快！");
    }
    //采用内部类对按钮进行监听
    private class B0 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)//对响应button0的处理
        {
            try
            {
                //使得各编辑框获得编辑权限
                t0.setEditable(true);
                t.setEditable(true);
                t1.setEditable(true);
                t2.setEditable(true);
                t3.setEditable(true);
                t4.setEditable(true);
                t5.setEditable(true);
                sum=0.0f;
            }
            catch(Exception e2)//异常处理
            {
                t6.setText("输入有误！");
                e2.printStackTrace();
            }
        }
    }
    private class B1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)//对响应button1的处理
        { 
            try
            {
                t6.setText("Tips:正在加入购物车，请稍等...");
                //计算消费总额
                sum+=3*Integer.parseInt(t0.getText())+128*Integer.parseInt(t.getText())+
                    3*Integer.parseInt(t1.getText())+5*Integer.parseInt(t2.getText())+
                    20*Integer.parseInt(t3.getText())+2.5*Integer.parseInt(t4.getText())+
                    4.5*Integer.parseInt(t5.getText());
                //统计购物清单
                msg="";
                if(Integer.parseInt(t0.getText())!=0)
                	msg+="苹果：3元，数量："+Integer.parseInt(t0.getText());
                else
                	msg+="";
                if(Integer.parseInt(t.getText())!=0)
                	msg+="\n衬衫：128元，数量："+Integer.parseInt(t.getText());
                else
                	msg+="";
                if(Integer.parseInt(t1.getText())!=0)
                	msg+="\n纸巾：3元，数量："+Integer.parseInt(t1.getText());
                else
                	msg+="";
                if(Integer.parseInt(t2.getText())!=0)
                	msg+="\n钢笔：5元，数量："+Integer.parseInt(t2.getText());
                else
                	msg+="";
                if(Integer.parseInt(t3.getText())!=0)
                	msg+="\n沐浴露：20元，数量："+Integer.parseInt(t3.getText());
                else
                	msg+="";
                if(Integer.parseInt(t4.getText())!=0)
                	msg+="\n方便面：2.5元，数量："+Integer.parseInt(t4.getText());
                else
                	msg+="";
                if(Integer.parseInt(t5.getText())!=0)
                	msg+="\n笔记本：4.5元，数量："+Integer.parseInt(t5.getText());
                else
                	msg+="";
                msg+="\n\t\t\t\t总计："+sum+"元";
                //写出本地文件
				LogIO.fprint(msg);//这里采用类名直接调用，因为fprint（）被定义为静态方法
                t0.requestFocus();//焦点移到第一个输入框
                //使得各编辑框不可再次编辑，避免重复计入购物车
                t0.setEditable(false);
                t.setEditable(false);
                t1.setEditable(false);
                t2.setEditable(false);
                t3.setEditable(false);
                t4.setEditable(false);
                t5.setEditable(false);
                Thread.sleep(500);//模拟等待场景，当前线程睡眠0.5秒
                l1.setText("总计消费："+sum);
                t6.setText("Tips:已经加入购物车！");
                sum=0.0f;
            }
            catch(Exception e2)//容错处理
            {
                t6.setText("输入有误！");
                e2.printStackTrace();
            }
        }  	
    }
    private class B2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)//对响应button2的处理
        {
            try
            {
                t6.setText("正在进入购物车，请稍等...");
                Thread.sleep(500);
                new ShoppingCart();//创建购物车frame，进入购物车界面;
                t6.setText("成功进入购物车!");
            }
            catch(Exception e2)
            {
                t6.setText("输入有误！");
                e2.printStackTrace();
            }
        }
    }
    private class B3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)//对响应button3的处理
        {
            try
            {
                t6.setText("Tips：正在进入收银台，请稍等...");
                Thread.sleep(500);
                new Casher();//创建收银台对象，进入收银台模拟界面
                t6.setText("Tips：成功进入收银台!");
            }
            catch(Exception e2)
            {
                t6.setText("Tips:付款失败！");
                e2.printStackTrace();
            }
        }
    }
    private class WinClose extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            (e.getWindow()).dispose();
            System.exit(0);
        }
    }
}

