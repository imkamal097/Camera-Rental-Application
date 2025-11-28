package CameraPackage;

public class Camera {
   int id;
   String brand;
   String model;
   float price;
   String status;
public Camera(int id, String brand, String model, float price, String status) {
	super();
	this.id = id;
	this.brand = brand;
	this.model = model;
	this.price = price;
	this.status = status;
}
public int getCameraid() {
	return id;
}
public void setCameraid(int cameraid) {
	this.id = cameraid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
   
   
}
