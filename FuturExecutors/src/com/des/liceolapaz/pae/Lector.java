package com.des.liceolapaz.pae;

import java.util.concurrent.*;

public class Lector implements Callable<String>{


	public static void main(String[] args) {
		try {
			Lector lector = new Lector();
			ExecutorService servExe = Executors.newSingleThreadExecutor();
			Future<String> result = servExe.submit(lector);
			String txt = result.get();
			if (result.isDone()) {
				System.out.println(txt);
				System.out.println("Process finished");
			} else if (result.isCancelled()) {
				System.out.println("Process cancelled");
			}
			servExe.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String call() throws Exception {
		String txtRead = "Me gusta el flow de la cucaracha";
		Thread.sleep(1000);
		return txtRead;
	}

}
