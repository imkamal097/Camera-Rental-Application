import java.util.TreeMap;

import java.util.*;

import CameraPackage.Camera;
import CameraPackage.CameraMenu;

public class CameraMain {
	
	public static boolean checkcredentials(String uname,String pwd) {
		if(uname.equals("admin") && pwd.equals("admin123"))
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TreeMap<Integer,Camera> tm=new TreeMap<>();
       tm.put(11,new Camera(11,"NIKON","DSLR-D700",500.0f,"AVAILABLE"));
       tm.put(12,new Camera(12,"Samsung","SM123",200.0f,"AVAILABLE"));
       tm.put(13,new Camera(13,"SONY","SONY1234",123.0f,"AVAILABLE"));
       tm.put(14,new Camera(14,"Sony","DSLR12",200.0f,"AVAILABLE"));
       tm.put(15,new Camera(15,"cannon","5030",25000.0f,"AVAILABLE"));
       float walletamt=200.0f;
       System.out.println("+--------------------------------------+");
       System.out.println("|      WELCOME TO CAMERA RENTAL APP    |");
       System.out.println("+--------------------------------------+");
       Scanner sc = new Scanner(System.in);
       System.out.println("Please Enter your Username: ");
       String uname=sc.next();
       System.out.println("Please Enter your Password: ");
       String pwd=sc.next();
       if(checkcredentials(uname,pwd)) {
    	   CameraMenu.Menu(tm, walletamt);
       }
       else {
    	   System.out.println("OOPS! You are not a Authenticated User.");
       }
       
	}

}
