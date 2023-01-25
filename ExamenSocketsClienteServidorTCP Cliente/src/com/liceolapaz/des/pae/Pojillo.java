package com.liceolapaz.des.pae;

import java.io.Serializable;
import java.util.ArrayList;

public class Pojillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> mYm;
	int suma;
	
	public Pojillo(ArrayList<Integer> mYm, int suma) {
		super();
		this.mYm = mYm;
		this.suma = suma;
	}
	
	public ArrayList<Integer> getmYm() {
		return mYm;
	}

	public void setmYm(ArrayList<Integer> mYm) {
		this.mYm = mYm;
	}

	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma = suma;
	}
}
