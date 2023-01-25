package com.liceolapaz.des.pae;

import java.io.Serializable;

public class POJO2 implements Serializable {

	private static final long serialVersionUID = -4558635501092572397L;
	int int1;
	int int2;

	public POJO2(int int1, int int2) {
		super();
		this.int1 = int1;
		this.int2 = int2;
	}
	
	public int getInt1() {
		return int1;
	}
	
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	
	public int getInt2() {
		return int2;
	}
	
	public void setInt2(int int2) {
		this.int2 = int2;
	}
}
