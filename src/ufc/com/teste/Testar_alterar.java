package ufc.com.teste;
import ufc.com.dao.*;
import ufc.com.model.Livro;

public class Testar_alterar {

	public static void main(String[] args) {
		Livro livro = new Livro();
		livro.setId(3);
		livro.setNomeLivro("alterado");
		livro.setCategoria("catttt");
		
		LivroDAO dao = new LivroDAO();
		dao.atualizar(livro);
	}

}
