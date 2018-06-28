package ufc.com.teste;
import ufc.com.model.*;
import ufc.com.dao.*;

public class Testar_delete {

	public static void main(String[] args) {
		Livro livro = new Livro();
		livro.setId(2);
		
		LivroDAO dao = new LivroDAO();
		dao.remover(livro);
	}

}
