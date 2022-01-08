package br.edu.ifsp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.tela.TelaPessoa;

public class EditaPessoa implements ActionListener {

	private TelaPessoa tela = null;
	private Pessoa modelo = null;
	
	public EditaPessoa(TelaPessoa telaPessoa) {
		
		tela = telaPessoa;
		modelo = new Pessoa();
		this.tela.getBotao2().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 //if (this.tela.getCampo1().getText() != null) {
			 modelo.setNome(this.tela.getCampo1().getText());
		 //}
		 //if (this.tela.getCampo2().getText() != null) {
			 modelo.setIdade(Integer.parseInt(this.tela.getCampo2().getText()));
		 //}
		 //if(this.tela.getCampo3().getText() != null) {
			 modelo.setEndereco(this.tela.getCampo3().getText());
		 //}
		
		// instacio o DAO Pessoa e insiro na base de dados
		new PessoaDAO().atualizarPessoa(modelo);
		
		JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!!");
	}

}