package model;

public class StudentPojo {
	
	private String userName;
	private String age;
	private String password;
	private int standard;
	private long mobileNumber;
	//private boolean doubt;
	private String materialType;
	private String materials;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	@Override
	public String toString() {
		return "StudentPojo [userName=" + userName + ", age=" + age + ", standard="
				+ standard + ", mobileNumber=" + mobileNumber + ", materialType=" + materialType
				+ ", materials=" + materials + "]";
	}
	
	
	
	
	

}
