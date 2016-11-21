package br.com.appservidorquem;

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
				
			//Pergunta 1
			Pergunta p1 = new Pergunta();
			p1.setDescricao("Eu adoro trabalhar com plantas");
			//Como no pojo da PERGUNTA o quantTentativas est� nullable = false (ou seja, n�o pode ser nulo)
			//eu pus um valor s� pra n�o dar erro na hora de mandarmos inserir
			p1.setQuantTentativas(3);
			perguntaDAO.save(p1);
			
			// Midia 1 da dica 1
			Midia m1 = new Midia();
			m1.setCaminho("lalala");
			m1.setDescricao("imagem sobre agricultor" );
			m1.setTipoMidia(TipoMidia.FIGURA);
			midiaDAO.save(m1);
			
			//Dica 1
			Dica d1 = new Dica();
			m1 = (Midia)midiaDAO.getById(1);
			d1.setMidia(m1);
			dicaDAO.save(d1);
			
//			// Contato cliente 1
//			Contato c11 = new Contato();
//			c11.setInfo("1234-0565");
//			c11.setTipo(TipoInfo.PHONE);
//			c1 = (Cliente)clienteDAO.getById(1);
//			c11.setDono(c1);
//			contatoDAO.save(c11);
//		
//			// Dependente cliente 1
//			Dependente d1 = new Dependente();
//			d1.setNomeDependente("Augusto");
//			c1 = (Cliente)clienteDAO.getById(1);
//			d1.setIdCliente(c1);
//			d1.setDataNascimentoDependente(new Date("09/09/2009"));
//			dependenteDAO.save(d1);
//			
//			// Endereco cliente 1
//			Endereco e1 = new Endereco();
//			e1.setRua("Av. Floriano");
//			e1.setNumero(12);
//			e1.setBairro("Lomba da Palmeira");
//			e1.setCidade("S�o Bernardo do Campo");
//			e1.setEstado("RS");
//			e1.setPais("Brasil");
//			e1.setCep("12345-111");
//			c1 = (Cliente)clienteDAO.getById(1);
//			e1.getPessoas().add(c1); 
//			enderecoDAO.save(e1);
				
				s.commit();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				s.rollback();
				
			} finally{
				s.close();
			}
		}	
	}
