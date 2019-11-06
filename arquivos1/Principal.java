package ex1;
import java.io.File;

public class Principal {
	public static void main(String[] args) {
		File file = new File("C://");
		File fileInside;
		for (String directoryName : file.list()) {
			System.out.print(directoryName + (" - "));
			fileInside = new File("C://" + directoryName);
			System.out.println(fileInside.isDirectory() ? "é um diretorio" : "é um arquivo");
		}
	}
}