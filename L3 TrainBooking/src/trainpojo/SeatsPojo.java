package trainpojo;

public class SeatsPojo {
   
	private boolean lowerBerth;
	private boolean  middle;
	private boolean  upper;
	private boolean sideberth;
	private boolean sideUpper;
	public boolean isLowerBerth() {
		return lowerBerth;
	}
	public void setLowerBerth(boolean lowerBerth) {
		this.lowerBerth = lowerBerth;
	}
	public boolean isMiddle() {
		return middle;
	}
	public void setMiddle(boolean middle) {
		this.middle = middle;
	}
	public boolean isUpper() {
		return upper;
	}
	public void setUpper(boolean upper) {
		this.upper = upper;
	}
	public boolean isSideberth() {
		return sideberth;
	}
	public void setSideberth(boolean sideberth) {
		this.sideberth = sideberth;
	}
	public boolean isSideUpper() {
		return sideUpper;
	}
	public void setSideUpper(boolean sideUpper) {
		this.sideUpper = sideUpper;
	}
	@Override
	public String toString() {
		return "lowerBerth=" + lowerBerth + ", middle=" + middle + ", upper=" + upper + ", sideberth="
				+ sideberth + ", sideUpper=" + sideUpper + "";
	}
	
	
	
	
}
