package threads;

import java.io.File;
import java.io.IOException;

import principal.Arquivo;

public class Thread_02 implements Runnable{
	
	File arq;
	
	public Thread_02(String path) throws InterruptedException {
		
		this.arq = new File(path);
		Thread thre = new Thread(this);
		thre.start();
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		Arquivo x = new Arquivo();
		String t = x.ler(this.arq);
		int r = 0;

		for(int i = 0; i < t.length(); i++) {
			r += new Integer(t.charAt(i)+"");
		}
		
		x.Escrever(r,arq.getName());
		
		try {
			x.Mover(arq, "Fim\\"+arq.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
