package br.com.menu;

import br.com.daos.AlternativaDAO;
import br.com.daos.DicaDAO;
import br.com.daos.MidiaDAO;
import br.com.daos.MiniJogoDAO;
import br.com.daos.PerguntaDAO;
import br.com.daos.RelatorioDAO;
import br.com.daos.RespostaDAO;
import br.com.daos.SeloDAO;
import br.com.daos.SimpleEntityManager;
import br.com.daos.UsuarioMiniJogoDAO;

public class Menu {

	public static void main(String[] args) {

		SimpleEntityManager sem = SimpleEntityManager.getInstance();
		
		AlternativaDAO alternativaDAO = new AlternativaDAO(sem.getEntityManager());
		DicaDAO dicaDAO = new DicaDAO(sem.getEntityManager());
		MidiaDAO midiaDAO = new MidiaDAO(sem.getEntityManager());
		MiniJogoDAO miniJogoDAO = new MiniJogoDAO(sem.getEntityManager());
		PerguntaDAO perguntaDAO = new PerguntaDAO(sem.getEntityManager());
		RelatorioDAO relatorioDAO = new RelatorioDAO(sem.getEntityManager());
		RespostaDAO respostaDAO = new RespostaDAO(sem.getEntityManager());
		SeloDAO seloDAO = new SeloDAO(sem.getEntityManager());
		UsuarioMiniJogoDAO usuarioMiniJogoDAO = new UsuarioMiniJogoDAO(sem.getEntityManager());
		
		Inserir.inserir(sem, alternativaDAO, dicaDAO, midiaDAO, miniJogoDAO, perguntaDAO, relatorioDAO, respostaDAO, seloDAO, usuarioMiniJogoDAO);
	}
}
