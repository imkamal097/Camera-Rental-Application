package CameraPackage;

import java.util.Scanner;
import java.util.TreeMap;

public class CameraMenu {
public static void Menu(TreeMap<Integer,Camera> tm,float walletamt)
{
	boolean flag=true;
	while(flag)
    {
        System.out.println("+----------------------------------------+");
        System.out.println("|              CAMERA APP MENU           |");
        System.out.println("+----------------------------------------+");
        System.out.println("| 1. MY CAMERA                           |");
        System.out.println("| 2. RENT A CAMERA                       |");
        System.out.println("| 3. VIEW ALL CAMERAS                    |");
        System.out.println("| 4. MY WALLET                           |");
        System.out.println("| 5. EXIT                                |");
        System.out.println("+----------------------------------------+");

        System.out.print("ENTER THE OPTIONS TO PROCEED NEXT:");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        System.out.println("------------------------------------------");
        switch(option){
        case 1:
        	CameraOptions.My_Camera(tm,walletamt);
        	break;
        case 2:
        	walletamt=CameraOptions.Rent_Camera(tm, walletamt);
        	break;
        case 3:
        	CameraOptions.View_All_Cameras(tm);
        	break;
        	
        case 4:
        	walletamt=CameraOptions.My_Wallet(walletamt);
        	break;
        	
        default:
        	System.out.println("-------------------------------------------------");
            System.out.println("EXITED FROM THE APPLICATION. THANK YOU!");
            System.out.println("-------------------------------------------------");
            flag=false; 
       } 

}
}
}
