package br.edu.ifsp.principal;

import br.edu.ifsp.controlador.InserePessoaController;
import br.edu.ifsp.controlador.ListaPessoa;
import br.edu.ifsp.controlador.DeletaPessoa;
import br.edu.ifsp.controlador.EditaPessoa;
import br.edu.ifsp.tela.TelaPessoa;

public class ExecutarProjeto {

	public static void main(String[] args) {
		
		TelaPessoa telaPessoa = new TelaPessoa("Formulario Pessoa");
		InserePessoaController controller = new InserePessoaController(telaPessoa);
		EditaPessoa controller2 = new EditaPessoa(telaPessoa);
		ListaPessoa controller3 = new ListaPessoa(telaPessoa);
		DeletaPessoa controller4 = new DeletaPessoa(telaPessoa);
		telaPessoa.setVisible(true);
	}
}
