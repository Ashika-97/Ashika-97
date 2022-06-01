package l3Model;

public class StockInfo implements java.io.Serializable{
	
	private String category;
	private String brand;
	private String model;
	private double price;
	private long invoiceNumber;
	private long stockCount=3;
	private String coupenCode;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public long getStockCount() {
		return stockCount;
	}
	public void setStockCount(long stockCount) {
		this.stockCount = stockCount;
	}
	
	public String getCoupenCode() {
		return coupenCode;
	}
	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}
	@Override
	public String toString() {
		return "StockInfo [category=" + category + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", invoiceNumber=" + invoiceNumber + ", stockCount=" + stockCount + ", coupenCode=" + coupenCode
				+ "]";
	}

	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
