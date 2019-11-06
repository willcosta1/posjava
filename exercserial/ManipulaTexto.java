package exercserial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Exercício: Alterar a classe Janela Clientes de forma que implementem as
 * funcionalidades 'Editar', 'Remover' e 'Anterior'.
 * 
 * @author fabricio@utfpr.edu.br
 */
public class ManipulaTexto {

	private File arquivo;
	private FileInputStream entrada;
	private ObjectInputStream objLeitura;
	private FileOutputStream saida;
	private ObjectOutputStream objGravar;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public void ManipulaTexto() {
		arquivo = null;
		entrada = null;
		saida = null;
	}

	public void criarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showSaveDialog(null);// posiciona a janela no centro da tela
		// usando o this a janela é centrada na janela da aplicação. O FileChooser é
		// modal
		if (result == JFileChooser.CANCEL_OPTION) {
			return;// finaliza a execuçao do metodo
		}
		arquivo = fileChooser.getSelectedFile();
		System.out.println(fileChooser.getName());

		if (arquivo == null || arquivo.getName().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				if (!arquivo.exists()) {
					saida = new FileOutputStream(arquivo, false);
				} else {
					saida = new FileOutputStream(arquivo, false);
					objGravar = new ObjectOutputStream(saida);
					entrada = new FileInputStream(arquivo);
					objLeitura = new ObjectInputStream(entrada);
					try {
						clientes = (ArrayList<Cliente>) objLeitura.readObject();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} finally {
						entrada = null;
						objLeitura = null;
					}
				}
			} catch (IOException ioException) {
				JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void fecharArquivo() {
		try {
			if (saida != null) {
				saida.close();
			}
			if (entrada != null) {
				entrada.close();
			}
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(null, "Error ao Fechar Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	public void GravaCliente(Cliente cliente) {
		if (saida == null) {
			criarArquivo();
		}
		try {
			clientes.add(cliente);
			saida = new FileOutputStream(arquivo, false);
			objGravar = new ObjectOutputStream(saida);
			entrada = new FileInputStream(arquivo);
			objLeitura = new ObjectInputStream(entrada);
			objGravar.writeObject(clientes);
			saida.flush();
			objGravar.flush();
		} catch (NumberFormatException formatException) {
			JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioException) {
			fecharArquivo();
		}
	}

	public void abrirArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}
		arquivo = fileChooser.getSelectedFile();
		System.out.println(arquivo);

		if (arquivo == null || arquivo.getName().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				entrada = new FileInputStream(arquivo);
				objLeitura = new ObjectInputStream(entrada);
				try {
					clientes = (ArrayList<Cliente>) objLeitura.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException ioException) {
				JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public Cliente lerRegistro(Cliente cliente) {

		if (entrada == null) {
			abrirArquivo();
		}
		try {
			cliente = clientes.get(clientes.indexOf(cliente) + 1);
		} catch (NumberFormatException err) {
			JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			return cliente;
		}
	}

	public Cliente lerRegistroAnterior(Cliente cliente) {
		if (entrada == null) {
			abrirArquivo();
		}
		try {
			cliente = clientes.get(clientes.indexOf(cliente) - 1);
		} catch (NumberFormatException err) {
			JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			return cliente;
		}
	}

	public Cliente removerCliente(Cliente c) {
		if (buscarCliente(c)) {
			int interator = clientes.indexOf(c);
			clientes.remove(c);
			try {
				objGravar = new ObjectOutputStream(saida);
				objGravar.writeObject(clientes);
				saida.flush();
				objGravar.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (clientes.isEmpty()) {
				c.setNome("");
				c.setFone("");
				c.setIdade(0);
				JOptionPane.showMessageDialog(null, "Neste momento não há registos!", "Sem registros!",
						JOptionPane.WARNING_MESSAGE);
				return c;
			}
			return c = clientes.get(interator - 1);
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não selecionado!", "Selecione um cliente!",
					JOptionPane.WARNING_MESSAGE);
			return c;
		}
	}

	public boolean buscarCliente(Cliente cliente) {
		if (clientes.contains(cliente)) {
			return true;
		}
		return false;
	}

	public Cliente editarCliente(Cliente cliente) {
		if (buscarCliente(cliente)) {
			try {
				clientes.set(clientes.indexOf(cliente), cliente);
				saida = new FileOutputStream(arquivo, false);
				objGravar = new ObjectOutputStream(saida);
				entrada = new FileInputStream(arquivo);
				objLeitura = new ObjectInputStream(entrada);
				objGravar.writeObject(clientes);
				saida.flush();
				objGravar.flush();
				entrada = new FileInputStream(arquivo);
			} catch (NumberFormatException formatException) {
				JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
			} catch (IOException ioException) {
				fecharArquivo();
			} finally {
				return cliente;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não selecionado!", "Selecione um cliente!",
					JOptionPane.WARNING_MESSAGE);
			return cliente;
		}
	}
}