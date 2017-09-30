package com.seecen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JFrame;

public class FiveChessFrame extends JFrame implements MouseListener{
	private Image bj;
	private int[][]allchess=new int[17][17];  //存储棋盘的所有坐标点
	                         //假设 allchess[i][j]==0 没有放棋子 
	                        //allchess[i][j]==1 白子  allchess[i][j]==2 黑子
	private boolean isHei=true; //让黑子先下
   public FiveChessFrame(){
	    this.setSize(700, 570);this.setTitle("五子棋游戏");
		//获取屏幕的大小 
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-700)/2,(height-570)/2);
		//点击X 按钮结束程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); this.setVisible(true);		
		//获取图片的路径
		URL url=this.getClass().getResource("/bg_game.jpg");
		bj=Toolkit.getDefaultToolkit().createImage(url);
		//实现自己监听自己窗口的鼠标事件
		this.addMouseListener(this);
   }

@Override
   public void paint(Graphics g) {
	   //System.out.println("paint.....");
	  /* g.drawLine(100, 100, 400, 400);
	   g.drawLine(100, 100, 100, 400);
	   g.drawLine(100, 400, 400, 400);*/
	
	  g.drawImage(bj, 0, 20, this);
	  //x=170,y=40
	 // x=680,y=550    680-170 -》510   550-40-》 510   510 -》30*17
	  for(int i=0;i<18;i++){
		  g.drawLine(170, 40+i*30, 680, 40+i*30);
		  g.drawLine(170+i*30, 40, 170+i*30, 550);
	  }
	  
	  for(int i=0;i<17;i++){
		  for(int j=0;j<17;j++){
			  //棋盘 i j 转换成坐标位置
			  int x=170+i*30;
			  int y=40+j*30;
			  if(allchess[i][j]==2){
				  //画黑子
				  g.fillOval(x-15, y-15, 30, 30);
				
			  }
			  
			  if(allchess[i][j]==1){		
				  //画白子
				  g.setColor(Color.white);
				  g.fillOval(x-15, y-15, 30, 30);
				  g.setColor(Color.black);
			  }
			  
		  }
	  }

	
    }

@Override
public void mouseClicked(MouseEvent e) {
	   int x=  e.getX();  //获取到鼠标点击 x 轴坐标
	   int y=  e.getY();  //获取到鼠标点击 y 轴坐标
	   System.out.println("x="+x+",y="+y);
	   //有效下棋范围
	   if(x>=170&&x<=680&&y>=40&&y<=550){
		    int i=(int) Math.round((x-170)/30.0);
		    int j=(int) Math.round((y-40)/30.0);
		   if(isHei){
			   //下黑子
			   allchess[i][j]=2;
			   isHei=false;
		   }else{
			   allchess[i][j]=1;
			   isHei=true;
		   }
		   
		   
	   }else{
		   System.out.println("没有在下棋范围");
	   }
	   this.repaint();
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
   
}
