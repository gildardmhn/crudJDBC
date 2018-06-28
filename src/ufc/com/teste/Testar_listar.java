package ufc.com.teste;

import java.util.List;

import ufc.com.dao.LivroDAO;
import ufc.com.model.Livro;

public class Testar_listar {
	public static void main(String[] args) {
		
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.getList();
		
		for(Livro livro : livros) {
			System.out.println("id: " + livro.getId());
			System.out.println("Nome do livro: " + livro.getNomeLivro());
			System.out.println("Categoria: " + livro.getCategoria());
		}

	}
}
