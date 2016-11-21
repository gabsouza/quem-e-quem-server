package br.com.menu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
import br.com.pojos.Dica;
import br.com.pojos.Midia;
import br.com.pojos.Pergunta;
import br.com.pojos.TipoMidia;

// import br.com.aula.daos.GenericDAO;

public class Inserir {

		public static void inserir(SimpleEntityManager s, AlternativaDAO alternativaDAO, DicaDAO dicaDAO,
							MidiaDAO midiaDAO, MiniJogoDAO miniJogoDAO, PerguntaDAO perguntaDAO, 
							RelatorioDAO relatorioDAO, RespostaDAO respostaDAO, SeloDAO seloDAO,
							UsuarioMiniJogoDAO usuarioMiniJogoDAO){
			try{
				s.beginTransaction();
				
		/*	// Midia 1
			Midia midia1 = new Midia();
			midia1.setCaminho("lalala");
			midia1.setDescricao(" Eu adoro trabalhar com plantas" );
			midia1.setTipoMidia(TipoMidia.AUDIO);
			midiaDAO.save(midia1);
			
			//Dica 1
			Dica dica1 = new Dica();
			midia1 = (Midia)midiaDAO.getById(1);
			dica1.setMidia(midia1);
			dicaDAO.save(dica1);*/
				
				s.commit();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				s.rollback();
				
			} finally{
				s.close();
			}
		}	
	}
