package exercserial;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaCliente.java
 */

/**
 * Exerc�cio: Alterar a classe Janela Clientes de forma que implementem as funcionalidades 'Editar', 'Remover' e 'Anterior'.
 * @author fabricio@utfpr.edu.br
 */
public class JanelaCliente extends JFrame {

	private Cliente cliente = null;
	private ManipulaTexto mt = null;

	/** Creates new form JanelaCliente */
	public JanelaCliente() {
		mt = new ManipulaTexto();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		cliente = new Cliente();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jBtnNovo = new javax.swing.JButton();
		jBtnFechar = new javax.swing.JButton();
		jTFNome = new javax.swing.JTextField();
		jTFFone = new javax.swing.JTextField();
		jSIdade = new javax.swing.JSpinner();
		jBtnGravar = new javax.swing.JButton();
		jBtnProximo = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Nome:");

		jLabel2.setText("Fone:");

		jLabel3.setText("Idade:");

		jBtnNovo.setText("Novo");
		jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnNovoActionPerformed(evt);
			}
		});

		jBtnFechar.setText("Fechar");
		jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnFecharActionPerformed(evt);
			}
		});

		jBtnGravar.setText("Gravar");
		jBtnGravar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jTFNome.getText().equals("") || jTFFone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nome ou Fone inv�lidos", "Nome, Fone ou Idade inv�lidos",
							JOptionPane.WARNING_MESSAGE);
				} else {
					jBtnGravarActionPerformed(evt);
				}
			}
		});

		jBtnProximo.setText("Proximo");
		jBtnProximo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnProximoActionPerformed(evt);
			}
		});

		JButton jBtnAnterior = new JButton("Anterior");
		jBtnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBtnAnteriorActionPerformed(e);
			}
		});

		jBtnEditar = new JButton("Editar");
		jBtnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jTFNome.getText().equals("") || jTFFone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nome ou Fone inv�lidos", "Nome, Fone ou Idade inv�lidos",
							JOptionPane.WARNING_MESSAGE);
				} else {
					cliente.setNome(jTFNome.getText());
					cliente.setFone(jTFFone.getText());
					cliente.setIdade((Integer) jSIdade.getValue());
					
					jBtnEditarActionPerformed(e);
				}
			}
		});

		jBtnRemover = new JButton("Remover");
		jBtnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBtnRemoverActionPerformed(e);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel3)
												.addComponent(jLabel1).addComponent(jLabel2))
										.addGap(18)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jTFNome, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
												.addComponent(jSIdade, GroupLayout.PREFERRED_SIZE, 69,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jTFFone)))
								.addGroup(layout.createSequentialGroup().addGap(4).addGroup(layout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jBtnNovo)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jBtnGravar)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jBtnAnterior).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(jBtnProximo))
										.addGroup(layout.createSequentialGroup().addGap(17).addComponent(jBtnEditar)
												.addGap(18).addComponent(jBtnRemover).addGap(18)
												.addComponent(jBtnFechar)))))
						.addContainerGap(103, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(jTFNome,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(jTFFone,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel3).addComponent(jSIdade,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jBtnNovo).addComponent(jBtnGravar)
						.addComponent(jBtnAnterior).addComponent(jBtnProximo))
				.addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jBtnFechar).addComponent(jBtnRemover).addComponent(jBtnEditar))
				.addContainerGap(24, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 399) / 2, (screenSize.height - 245) / 2, 421, 245);
	}// </editor-fold>//GEN-END:initComponents

	protected void jBtnRemoverActionPerformed(ActionEvent e) {
		cliente = mt.removerCliente(cliente);
		atualizarTela();
	}

	protected void jBtnEditarActionPerformed(ActionEvent e) {
		cliente = mt.editarCliente(cliente);
		atualizarTela();
	}

	protected void jBtnAnteriorActionPerformed(ActionEvent e) {
		cliente = mt.lerRegistroAnterior(cliente);
		atualizarTela();
	}

	private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtnNovoActionPerformed
		cliente = new Cliente();
		limparTela();
		jTFNome.requestFocus();
	}// GEN-LAST:event_jBtnNovoActionPerformed

	private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtnFecharActionPerformed
		if (mt != null) {
			mt.fecharArquivo();
		}
		System.exit(0);
	}// GEN-LAST:event_jBtnFecharActionPerformed

	private void jBtnGravarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtnGravarActionPerformed
		cliente = new Cliente(jTFNome.getText(), jTFFone.getText(), (Integer) jSIdade.getValue());
		mt.GravaCliente(cliente);
	}// GEN-LAST:event_jBtnGravarActionPerformed

	private void jBtnProximoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtnProximoActionPerformed
		cliente = mt.lerRegistro(cliente);
		atualizarTela();
	}// GEN-LAST:event_jBtnProximoActionPerformed

	public void limparTela() {
		jTFNome.setText("");
		jTFFone.setText("");
		jSIdade.setValue((Integer) 18);
	}

	public void atualizarTela() {
		if (cliente != null && cliente.getNome() != null) {
			jTFNome.setText(cliente.getNome());
			jTFFone.setText(cliente.getFone());
			jSIdade.setValue((Integer) cliente.getIdade());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new JanelaCliente().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jBtnFechar;
	private javax.swing.JButton jBtnGravar;
	private javax.swing.JButton jBtnNovo;
	private javax.swing.JButton jBtnProximo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JSpinner jSIdade;
	private javax.swing.JTextField jTFFone;
	private javax.swing.JTextField jTFNome;
	private JButton jBtnEditar;
	private JButton jBtnRemover;
}