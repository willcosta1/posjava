package ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String nome = in.nextLine();
		File file = new File("E://Downloads//");
		String palavras = "";
		System.out.println("Escreva algumas palavras: ");
		palavras = in.nextLine();
		if (getEstadoFile(file.list(), nome)) {
			System.out.println("Arquivo já encontra-se criado");
			FileWriter fileWriter = new FileWriter("E://Downloads//" + nome);
			BufferedWriter buff = new BufferedWriter(fileWriter);
			buff.append(palavras);
			buff.close();
			System.out.println("Conteudo sobrescrito!");
		} else {
			FileWriter fileWriter = new FileWriter(new File("E://Downloads//" + nome));
			BufferedWriter buff = new BufferedWriter(fileWriter);
			System.out.println("Arquivo criado.");
			buff.append(palavras);
			buff.close();
		}
		System.out.println("Salvo com sucesso!");
	}

	public static boolean getEstadoFile(String files[], String nome) {
		for (String directoryName : files) {
			if (directoryName.equals(nome))
				return true;
		}
		return false;
	}
}
