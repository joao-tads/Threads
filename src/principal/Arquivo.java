package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Arquivo {
	
	public File[] ListaArquivos() {
		File pasta = new File("Inicio");
		File[] arquivo = pasta.listFiles();

		return arquivo;
	}
	
	public void Mover(File a, String b) throws IOException {
		
		File dest = new File(b);
		
		if(dest.exists()) {
			dest.delete();
		}
		FileChannel x = null;
		FileChannel z = null;
		 
		    try {
		        x = new FileInputStream(a).getChannel();
		        z = new FileOutputStream(dest).getChannel();
		        x.transferTo(0, x.size(),
		                z);
		    } finally {
		        if (x != null && x.isOpen())
		            x.close();
		        if (z != null && z.isOpen())
		            z.close();
		   }    
		   a.delete(); 
	}
	
	public String ler(File file) {
		
		FileReader a = null;
		String t = "";
		
		try {
			a = new FileReader(file);
			BufferedReader ler = new BufferedReader(a);
			String linha = "";
			do {
				linha = ler.readLine();
			}while(t != null && t != "");
			a.close();
			t = linha;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public void Escrever(int result, String name) {
		
		try {
			FileWriter e = new FileWriter("Processo\\Resultado.txt", true);
			synchronized (e) {
				e.write("Arquivo: "+name+" -> (Soma = "+result+");\n");
				e.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
