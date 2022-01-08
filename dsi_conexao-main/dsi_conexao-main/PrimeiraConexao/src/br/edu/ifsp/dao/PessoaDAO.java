package br.edu.ifsp.dao;
import br.edu.ifsp.conexao.Conexao;
import br.edu.ifsp.modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PessoaDAO {
	
	Connection conexao = null;
	
	public PessoaDAO() {
		conexao = Conexao.obterConexao();
	}
	
	public void inserirPessoa(Pessoa pessoa) {
		
		String SQL = "INSERT INTO pessoa(nome, idade, endereco) VALUE (?,?,?)";
		
		try {
			
			PreparedStatement pstm = conexao.prepareStatement(SQL);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3, pessoa.getEndereco());
			
			pstm.executeUpdate();
			
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Erro ao executar SQL de insercao de Pessoa");
		}
	}
	
	public void listarTodasPessoas() {
		String sql = "SELECT * FROM pessoa";
		 
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			 
			int count = 0;
			 
			while (result.next()){
			    String nome = result.getString("nome");
			    String idade = result.getString("idade");
			    String endereco = result.getString("endereco");
			 
			    String output = "Pessoa #%d: %s - %s - %s";
			    System.out.println(String.format(output, ++count, nome, idade, endereco));
			}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Erro ao executar SQL de seleção de Pessoas");
		}
	}
	
	
	public void atualizarPessoa(Pessoa pessoa) {
		String sql = "UPDATE pessoa SET nome=?, idade=?, endereco=? WHERE nome=?";
		 
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, pessoa.getNome());
			statement.setInt(2, pessoa.getIdade());
			statement.setString(3, pessoa.getEndereco());
			statement.setString(4, pessoa.getNome());
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Pessoa atualizada");
			}
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Erro ao executar SQL de atualizar Pessoa");
		}
	}
	
	public void removerPessoa(Pessoa pessoa) {
		String sql = "DELETE FROM pessoa WHERE nome=?";
		 try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, pessoa.getNome());
			 
			int linhasDeletadas = statement.executeUpdate();
			if (linhasDeletadas > 0) {
			    System.out.println("Pessoa deletada");
			}
		 }catch(SQLException sqlex) {
				sqlex.printStackTrace();
				System.out.println("Erro ao executar SQL de deletar Pessoa");
			}
	}
}
