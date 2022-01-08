package br.edu.ifsp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.tela.TelaPessoa;

public class DeletaPessoa implements ActionListener {

	private TelaPessoa tela = null;
	private Pessoa modelo = null;
	
	public DeletaPessoa(TelaPessoa telaPessoa) {
		
		tela = telaPessoa;
		modelo = new Pessoa();
		this.tela.getBotao4().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.setNome(this.tela.getCampo1().getText());
		new PessoaDAO().removerPessoa(modelo);
		
	}

}