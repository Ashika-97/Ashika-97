package model;

public class TeacherPojo {
	
	private String name;
	private String password;
	private int standard;
	private long mobilenumber;
	private String materials;
	private String answer;
	private String materialType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	@Override
	public String toString() {
		return "TeacherPojo [name=" + name + ", standard=" + standard + ", mobilenumber=" + mobilenumber
				+ ", materials=" + materials + ", answer=" + answer + ", materialType=" + materialType + "]";
	}
	
	
	
	

}
