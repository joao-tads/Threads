package threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import principal.Arquivo;

public class Thread_01 implements Runnable{
	
	private Thread_02 thre2;
	private int contador = 0;
	
	public Thread_01() {
		Thread thre2 = new Thread(this);
		thre2.start();
	}
	
	@Override
	public void run() {
		
		while(true) {
			Arquivo arq = new Arquivo();
			
			try {
				if(arq.ListaArquivos().length == 0) {
					Thread.sleep(5000);
				}else {
					for (File file : arq.ListaArquivos()) {
						arq.Mover(file, "Processo\\"+file.getName());
						thre2 = new Thread_02("Processo\\"+file.getName());
					}
					contador = contador--;
				}
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			
			if(contador > 1) {
				break;
			}else {
				contador++;
			}
		}    
	}
}
