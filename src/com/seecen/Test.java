package com.seecen;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		/*JFrame jf=new JFrame ();
		jf.setSize(700, 500);
		jf.setTitle("五子棋游戏");//1360 768
		//获取屏幕的大小 
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		jf.setLocation((width-700)/2,(height-500)/2);
		jf.setResizable(false);
		//点击X 按钮结束程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
		jf.setVisible(true);*/
		
		new FiveChessFrame();
	}

}
