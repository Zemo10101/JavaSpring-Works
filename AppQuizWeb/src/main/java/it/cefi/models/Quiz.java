package it.cefi.models;

public class Quiz {

	private String d1;
	private String r1;
	private String r2;
	private String r3;
	private String r4;

	
	private boolean val1;
	private boolean val2;
	private boolean val3;
	private boolean val4;
	
	
	public Quiz(String d1, String r1, String r2, String r3, String r4, boolean val1, boolean val2, boolean val3,
			boolean val4) {
		super();
		this.d1 = d1;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
		this.val4 = val4;
	}
	
	public Quiz() {}
	

	public void setD1(String d1) {
		this.d1 = d1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	public void setR4(String r4) {
		this.r4 = r4;
	}

	public void setVal1(boolean val1) {
		this.val1 = val1;
	}

	public void setVal2(boolean val2) {
		this.val2 = val2;
	}

	public void setVal3(boolean val3) {
		this.val3 = val3;
	}

	public void setVal4(boolean val4) {
		this.val4 = val4;
	}

	public String getD1() {
		return d1;
	}
	public String getR1() {
		return r1;
	}
	public String getR2() {
		return r2;
	}
	public String getR3() {
		return r3;
	}
	public String getR4() {
		return r4;
	}
	public boolean isVal1() {
		return val1;
	}
	public boolean isVal2() {
		return val2;
	}
	public boolean isVal3() {
		return val3;
	}
	public boolean isVal4() {
		return val4;
	}
	
	
}
