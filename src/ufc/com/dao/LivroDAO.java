package ufc.com.dao;
import ufc.com.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufc.com.jdbc.ConexaoFactory;

public class LivroDAO {
	
	private Connection conexao;
	
	public LivroDAO() {
		this.conexao = new ConexaoFactory().conectarBanco();
	}
	
	public void adicionar(Livro livro) {
		String sql = "insert into livros (nomeLivro,categoria) values(?,?)";
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, livro.getNomeLivro());
			stm.setString(2, livro.getCategoria());
			
			stm.execute();
			stm.close();
			System.out.println("Livro cadastrado com sucesso");
		}
		catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void remover(Livro livro) {
		
		String sql = "delete from livros where id=?";
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, livro.getId());
			stm.execute();
			stm.close();
			System.out.println("Livro removido com sucesso");
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Livro livro) {
		String sql = "update livros set nomeLivro=?,categoria=? where id=?";
		
		try {
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, livro.getNomeLivro());
			stm.setString(2, livro.getCategoria());
			stm.setInt(3, livro.getId());
			stm.executeUpdate();
			stm.close();
			System.out.println("Livro atualizado com sucesso");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> getList(){
		String sql = "select * from livros";
		try {
			List<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setNomeLivro(rs.getString("nomeLivro"));
				livro.setCategoria(rs.getString("categoria"));
				
				livros.add(livro);
			}
			
			rs.close();
			stm.close();
			return livros;
			}
		catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}
