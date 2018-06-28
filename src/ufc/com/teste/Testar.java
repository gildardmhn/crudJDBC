package ufc.com.teste;
import ufc.com.model.Livro;
import ufc.com.dao.LivroDAO;


public class Testar {

	public static void main(String[] args) {
		
		Livro livro = new Livro();
		livro.setNomeLivro("Shingeki no Kyojin");
		livro.setCategoria("Mangas");
		
		LivroDAO dao = new LivroDAO();
		dao.adicionar(livro);


	}

}
