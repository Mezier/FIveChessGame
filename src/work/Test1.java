package work;

import java.util.Scanner;

class EmailException extends Exception{
	public EmailException(String message){
		super(message);
	}
}
public class Test1 {
	 public boolean checkEmail(String email) throws EmailException{
		 boolean f=true;
		 if(email.indexOf("@")==-1||email.indexOf("@")==0||email.indexOf("@")==email.length()-1){
			 f=false;
			 throw new EmailException("输入的是一个非法的邮件地址");
		 }	 
		 return f;
	 }
	public static void main(String[] args) {
	   System.out.println("请输入你要验证的邮件地址");
	   Scanner sc=new Scanner(System.in);
	   String email=sc.next();
	   Test1 t=new Test1();
	   try {
		boolean f=t.checkEmail(email);
		if(f){
			System.out.println("邮件地址合法");
		}
	  } catch (EmailException e) {
		//e.printStackTrace();
		System.out.println(e.getMessage());
	 }
	}

}
