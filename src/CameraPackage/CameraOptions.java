package CameraPackage;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class CameraOptions {
	 public static void View_All_Cameras(TreeMap<Integer, Camera> tm)
	 {
	     System.out.println("--------------------------------------------------------------------------------------");
	     System.out.printf("| %-10s | %-15s | %-15s | %-20s | %-10s|\n",
	             "CAMERA_ID", "CAMERA_BRAND", "CAMERA_MODEL", "CAMERA_PRICE(PER DAY)", "STATUS");
	     System.out.println("--------------------------------------------------------------------------------------");
	     for(Map.Entry<Integer, Camera> en : tm.entrySet()) {
	         Camera cameraDetails = en.getValue();
	         System.out.printf("| %-10d | %-15s | %-15s | %-20.2f | %-10s |\n",cameraDetails.getCameraid(),cameraDetails.getBrand(),cameraDetails.getModel(),cameraDetails.getPrice(),cameraDetails.getStatus());
	     }

	     System.out.println("--------------------------------------------------------------------------------------");
	 }
	 static Scanner sc = new Scanner(System.in);
	 public static void My_Camera(TreeMap<Integer, Camera> tm , float walletamt) {
	         System.out.println("-------------------------------------------------");
	         System.out.println("----> THIS IS MY CAMERA LIBRARY:");
	         System.out.println("-------------------------------------------------");

	         while (true){
	             Scanner sc = new Scanner(System.in);
	             System.out.println("1. ADD THE CAMERA");
	             System.out.println("2. REMOVE THE CAMERA");
	             System.out.println("3. VIEW ALL MY CAMERAS");
	             System.out.println("4. GO TO THE PREVIOUS MENU");
	             System.out.print("ENTER THE OPTIONS IN THE CAMERA LIBRARY: ");
	             int options=sc.nextInt();
	             System.out.println("-------------------------------------------------");
	             if (options == 1) {
	                 System.out.print("ENTER THE CAMERA ID: ");
	                 int id = sc.nextInt();
	                 System.out.print("ENTER THE CAMERA BRAND: ");
	                 String brand = sc.next();
	                 System.out.print("ENTER THE CAMERA MODEL: ");
	                 String model = sc.next();
	                 System.out.print("ENTER THE CAMERA PRICE(PER DAY): ");
	                 float price = sc.nextFloat();
	                 String status = "AVAILABLE";
	                 tm.put(id, new Camera(id, brand, model, price, status));
	                 System.out.println("-------------------------------------------------");
	                 System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE MENU");
	                 System.out.println("-------------------------------------------------");
	             } 
	             else if (options == 2) {
	                 System.out.print("ENTER THE CAMERA ID TO REMOVE: ");
	                 int id = sc.nextInt();

	                 if (tm.containsKey(id)) {
	                     tm.remove(id);
	                     System.out.println("-------------------------------------------------");
	                     System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE MENU");
	                     System.out.println("-------------------------------------------------");
	                 } else {
	                     System.out.println("-------------------------------------------------");
	                     System.out.println("THE ENTERED CAMERA ID IS NOT IN THE MENU!");
	                     System.out.println("-------------------------------------------------");
	                 }
	             }
	             else if(options == 3) {
	                 View_All_Cameras(tm);
	             }
	             else {
	            	  System.out.println("-------------------------------------------------");
	                  System.out.println("------> GOING TO THE MENU PAGE.");
	                  System.out.println("-------------------------------------------------");
	                  CameraMenu.Menu(tm,walletamt);
	                  break;
	              }
	             
 }
	 }
	 public static float Rent_Camera(TreeMap<Integer,Camera> tm,float walletamt){
		 TreeMap<Integer,Camera> temp=new TreeMap<>();
		 for(Map.Entry<Integer,Camera> i: tm.entrySet()) {
			 int key=i.getKey();
			 Camera value=i.getValue();
			 if(value.getStatus().equals("AVAILABLE")) {
			 temp.put(key,value);
			 }
			 
		 }
		 System.out.println("-------------------------------------------------");
	     System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S)");
	     System.out.println("-------------------------------------------------");
	     View_All_Cameras(temp);
	     System.out.println("-------------------------------------------------");
	     System.out.println("Enter the Camera ID you want to rent: ");
	     int id=sc.nextInt();
	     
	     if(tm.containsKey(id)) {
	    	 Camera cam=tm.get(id);
	    	 if(cam.getPrice() <= walletamt) {
	    		 cam.setStatus("Rented");
	    		 System.out.println("Rented Successfully");
	    		 walletamt-=cam.getPrice();
	    		 System.out.println("YOUR TRANSACTION FOR CAMERA "+ cam.getBrand() + " " + cam.getModel()+ " WITH RENT INR. " + cam.getPrice()+ " HAS SUCCESSFULLY COMPLETED.");
	             walletamt -= cam.getPrice();
	    	 }
	    	 else {
	                 System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE.");
	                 System.out.println("PLEASE DEPOSIT THE AMOUNT IN YOUR WALLET."); 
	    	 }
	     }
	     else
	     {
	         System.out.println("YOUR RENT ID IS NOT IN THE MENU");
	     }
	     return walletamt;
	 }
	 public static float My_Wallet(float walletamt)
	 {
	     System.out.println("-------------------------------------------------");
	     System.out.println("               WALLET DETAILS");
	     System.out.println("-------------------------------------------------");
	     System.out.println("YOUR CURRENT WALLET BALANCE IS - INR. " + walletamt);
	     System.out.println("-------------------------------------------------");
	     System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? \n1. YES\n2. NO\nEnter your choice: ");

	     int choice = sc.nextInt();

	     if (choice == 1) {
	         System.out.print("ENTER THE AMOUNT TO DEPOSIT: INR. ");
	         float depositAmount = sc.nextFloat();
	         walletamt += depositAmount;
	         System.out.println("-------------------------------------------------");
	         System.out.println("WALLET UPDATED SUCCESSFULLY!");
	         System.out.println("YOUR CURRENT WALLET BALANCE: INR. " + walletamt);
	         System.out.println("-------------------------------------------------");
	     } else if (choice == 2) {
	         System.out.println("-------------------------------------------------");
	         System.out.println("WALLET BALANCE NOT UPDATED");
	         System.out.println("YOUR CURRENT WALLET BALANCE: INR. " + walletamt);
	         System.out.println("-------------------------------------------------");
	     } else {
	         System.out.println("INVALID CHOICE! PLEASE ENTER 1 OR 2.");
	     }
	    return walletamt;
	 }
	 
	 
	 
	 
	 }
