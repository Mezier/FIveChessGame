package com.seecen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FiveChess  extends JFrame implements MouseListener{
	  public static void main(String[] args) {
		   new FiveChess();
	   }
	  private Image bj;
	  private int allchess[][]=new int[18][18];
	  //allchess[i][j]==1  黑子   allchess[i][j]==2  白子   0无棋子
	  private boolean isHei=true ;  //让黑子先下 实现 黑白交替
	  private String message="轮到我啦";
	  public FiveChess(){
		  
		    this.setSize(700, 570);this.setTitle("五子棋游戏");
			//获取屏幕的大小 
			int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			this.setLocation((width-700)/2,(height-570)/2);
			//点击X 按钮结束程序
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);	 this.setVisible(true);	
			//获取图片的路径
			URL url=this.getClass().getResource("/bg_game.jpg");
			bj=Toolkit.getDefaultToolkit().createImage(url);
			//实现自己监听自己窗口的鼠标事件
			this.addMouseListener(this);
	  }
	@Override
	public void paint(Graphics g) {
		g.drawImage(bj, 0, 20, this);
		//x=170,y=40
		//x=680,y=550   682-166= 510   550-38=510  30*30
		for(int i=0;i<18;i++){
			g.drawLine(170,40+30*i, 680, 40+30*i);
			g.drawLine(170+30*i,40, 170+30*i, 550);
		}
		for(int i=0;i<17;i++){
			for(int j=0;j<17;j++){
				//通过棋盘 下标获取 x y轴的坐标
				int x=170+30*i;
				int y=40+j*30;
				if(allchess[i][j]==1){
					//黑子
					g.fillOval(x-15, y-15, 30, 30);
				}
				if(allchess[i][j]==2){
					g.setColor(Color.white);
					g.fillOval(x-15, y-15, 30, 30);
					g.setColor(Color.BLACK);
				}
				
			}
		}
	    g.setFont(new Font("黑体",Font.BOLD,24));
	    g.setColor(Color.red);
		if(isHei){
			g.drawString(message, 27, 395);
		}else{
			g.drawString(message, 27, 111);
		}
		g.setColor(Color.BLACK);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		  int x=e.getX();
		  int y=e.getY();
		 //System.out.println("x="+x+",y="+y);
		  //有效下棋范围
		  if(x>=170&&x<=680&&y>=40&&y<=550){
			  //x y  轴转换成 棋盘 数组的下标
			  int i=(int) Math.round((x-170)/30.0) ;
			  int j=(int) Math.round((y-40)/30.0) ;
			  if(allchess[i][j]==0){
				  if(isHei){
					  //下黑子
					  allchess[i][j]=1; 
					  isHei=false;
				  }else{
					  allchess[i][j]=2; 
					  isHei=true;
				  }
				  this.repaint();
				 //判断输赢 
				 int hengcout= CheckWin.heng(allchess, i, j);
				 int congcout= CheckWin.cong(allchess, i, j);
				 int result=0;  //0 重来  1 不重来  2 取消
				 if(hengcout>=5||congcout>=5){
					 if(isHei){
						 result=JOptionPane.showConfirmDialog(this, "白子赢！,是否重来一盘");
					 }else{
						 result= JOptionPane.showConfirmDialog(this, "黑子赢！,是否重来一盘");
					 } 
					 
					 if(result==0){
						 allchess=new int[18][18];
						 isHei=true;
					 }else{
						 if(result==1){
							 System.exit(0);
						 }else{
							 for(int n=0;n<17;n++){
								 for(int m=0;m<17;m++){
									 if(allchess[n][m]==0){
										 allchess[n][m]=4;
									 }
								 }
							 }
						 }
					 }
					
				 }
				  
			  }else{
				  if(allchess[i][j]==4){
					  JOptionPane.showMessageDialog(this,"游戏结束了");
				  }else{
					  JOptionPane.showMessageDialog(this,"该处有棋子，请选择其他位置");  
				  }
				  
			  }
			  
			  
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
