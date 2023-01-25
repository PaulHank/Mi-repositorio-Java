package com.liceolapaz.des.pae;

public class Examenes {
	private volatile static int numExamenes = 50;

	public static int getNumExamenes() {
		return numExamenes;
	}

	public static void setNumExamenes(int numExamenes) {
		Examenes.numExamenes = numExamenes;
	}
	
}
