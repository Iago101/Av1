package br.edu.ifsp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.tela.TelaPessoa;

public class ListaPessoa implements ActionListener {

	private TelaPessoa tela = null;
	private Pessoa modelo = null;
	
	public ListaPessoa(TelaPessoa telaPessoa) {
		
		tela = telaPessoa;
		modelo = new Pessoa();
		this.tela.getBotao3().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		new PessoaDAO().listarTodasPessoas();
		
	}

}