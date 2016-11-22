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
import br.com.pojos.Alternativa;
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
				
				Integer qtdProfissoes = alternativaDAO.consultaQuantidadeProfissoes();		
				
				if(qtdProfissoes != 0){
				}
				
				// Profissões

				// Árbitra
				Alternativa alternativa1 = new Alternativa();
				alternativa1.setDescricao("Árbitra");

				// Árbitro
				Alternativa alternativa2 = new Alternativa();
				alternativa2.setDescricao("Árbitro");

				// Juíza
				Alternativa alternativa3 = new Alternativa();
				alternativa3.setDescricao("Juíza");

				// Juíz
				Alternativa alternativa4 = new Alternativa();
				alternativa4.setDescricao("Juíz");

				// Veterinária
				Alternativa alternativa5 = new Alternativa();
				alternativa5.setDescricao("Veterinária");

				// Veterinário
				Alternativa alternativa6 = new Alternativa();
				alternativa6.setDescricao("Veterinário");

				// Tratadora de animais - Tratador de animais
				Alternativa alternativa7 = new Alternativa();
				alternativa7.setDescricao("Tratadora de animais");

				// Tratador de animais
				Alternativa alternativa8 = new Alternativa();
				alternativa8.setDescricao("Tratador de animais");

				// Zeladora
				Alternativa alternativa9 = new Alternativa();
				alternativa9.setDescricao("Zeladora");

				// Zelador
				Alternativa alternativa10 = new Alternativa();
				alternativa10.setDescricao("Zelador");

				// Pilota
				Alternativa alternativa11 = new Alternativa();
				alternativa11.setDescricao("Pilota");

				// Piloto
				Alternativa alternativa12 = new Alternativa();
				alternativa12.setDescricao("Piloto");

				// Prisidenta
				Alternativa alternativa13 = new Alternativa();
				alternativa13.setDescricao("Político");

				// Presidente
				Alternativa alternativa14 = new Alternativa();
				alternativa14.setDescricao("Político");

				// Nutricionista
				Alternativa alternativa15 = new Alternativa();
				alternativa15.setDescricao("Nutricionista");

				// Massagista
				Alternativa alternativa16 = new Alternativa();
				alternativa16.setDescricao("Massagista");

				// Babá
				Alternativa alternativa17 = new Alternativa();
				alternativa17.setDescricao("Babá");

				// Costureira
				Alternativa alternativa18 = new Alternativa();
				alternativa18.setDescricao("Costureira");

				// Costureiro
				Alternativa alternativa19 = new Alternativa();
				alternativa19.setDescricao("Costureiro");

				// Decoradora
				Alternativa alternativa20 = new Alternativa();
				alternativa20.setDescricao("Decoradora");

				// Decorador
				Alternativa alternativa21 = new Alternativa();
				alternativa21.setDescricao("Decorador");

				// Arquiteta
				Alternativa alternativa22 = new Alternativa();
				alternativa22.setDescricao("Arquiteta");

				// Arquiteto
				Alternativa alternativa23 = new Alternativa();
				alternativa23.setDescricao("Arquiteto");

				// Pedreira
				Alternativa alternativa24 = new Alternativa();
				alternativa24.setDescricao("Pedreira");

				// Pedreiro
				Alternativa alternativa25 = new Alternativa();
				alternativa25.setDescricao("Pedreiro");

				// Eletricista
				Alternativa alternativa26 = new Alternativa();
				alternativa26.setDescricao("Eletricista");

				// Salva-vidas
				Alternativa alternativa27 = new Alternativa();
				alternativa27.setDescricao("Salva-vidas");

				// Vendedora
				Alternativa alternativa28 = new Alternativa();
				alternativa28.setDescricao("Vendedora");

				// Vendedor
				Alternativa alternativa29 = new Alternativa();
				alternativa29.setDescricao("Vendedor");

				// Cozinheira
				Alternativa alternativa30 = new Alternativa();
				alternativa30.setDescricao("Cozinheira");

				// Cozinheiro
				Alternativa alternativa31 = new Alternativa();
				alternativa31.setDescricao("Cozinheiro");

				// Jardineira
				Alternativa alternativa32 = new Alternativa();
				alternativa32.setDescricao("Jardineira");

				// Jardineiro
				Alternativa alternativa33 = new Alternativa();
				alternativa33.setDescricao("Jardineiro");

				// Agricultor
				Alternativa alternativa34 = new Alternativa();
				alternativa34.setDescricao("Agricultor");

				// Agricultora
				Alternativa alternativa35 = new Alternativa();
				alternativa35.setDescricao("Agricultora");

				// Entregadora
				Alternativa alternativa36 = new Alternativa();
				alternativa36.setDescricao("Entregadora");

				// Entregador
				Alternativa alternativa37 = new Alternativa();
				alternativa37.setDescricao("Entregador");

				// Sorveteira
				Alternativa alternativa38 = new Alternativa();
				alternativa38.setDescricao("Sorveteira");

				// Sorveteiro
				Alternativa alternativa39 = new Alternativa();
				alternativa39.setDescricao("Sorveteiro");

				// Carteira
				Alternativa alternativa40 = new Alternativa();
				alternativa40.setDescricao("Carteira");

				// Carteiro
				Alternativa alternativa41 = new Alternativa();
				alternativa41.setDescricao("Carteiro");

				// Segurança
				Alternativa alternativa42 = new Alternativa();
				alternativa42.setDescricao("Segurança");

				// Enfermeira
				Alternativa alternativa43 = new Alternativa();
				alternativa43.setDescricao("Enfermeira");

				// Enfermeiro
				Alternativa alternativa44 = new Alternativa();
				alternativa44.setDescricao("Enfermeiro");

				// Caminhoneira
				Alternativa alternativa45 = new Alternativa();
				alternativa45.setDescricao("Caminhoneira");

				// Caminhoneiro
				Alternativa alternativa46 = new Alternativa();
				alternativa46.setDescricao("Caminhoneiro");

				// Faxineira
				Alternativa alternativa47 = new Alternativa();
				alternativa47.setDescricao("Faxineira");

				// Faxineiro
				Alternativa alternativa48 = new Alternativa();
				alternativa48.setDescricao("Faxineiro");

				// Professora
				Alternativa alternativa49 = new Alternativa();
				alternativa49.setDescricao("Professora");

				// Professor
				Alternativa alternativa50 = new Alternativa();
				alternativa50.setDescricao("Professor");

				// Bailarino
				Alternativa alternativa51 = new Alternativa();
				alternativa51.setDescricao("Bailarino");

				// Bailarina
				Alternativa alternativa52 = new Alternativa();
				alternativa52.setDescricao("Bailarina");

				// Curadora
				Alternativa alternativa53 = new Alternativa();
				alternativa53.setDescricao("Curadora");

				// Curador
				Alternativa alternativa54 = new Alternativa();
				alternativa54.setDescricao("Curador");

				// Bombeira
				Alternativa alternativa55 = new Alternativa();
				alternativa55.setDescricao("Bombeira");

				// Bombeiro
				Alternativa alternativa56 = new Alternativa();
				alternativa56.setDescricao("Bombeiro");

				// Jogadora de Futebol
				Alternativa alternativa57 = new Alternativa();
				alternativa57.setDescricao("Jogadora de Futebol");

				// Jogador de Futebol
				Alternativa alternativa58 = new Alternativa();
				alternativa58.setDescricao("Jogador de Futebol");

				// Floriculturista
				Alternativa alternativa59 = new Alternativa();
				alternativa59.setDescricao("Floriculturista");

				// Mecânica
				Alternativa alternativa60 = new Alternativa();
				alternativa60.setDescricao("Mecânica");

				// Mecânico
				Alternativa alternativa61 = new Alternativa();
				alternativa61.setDescricao("Mecânico");

				// Taxista
				Alternativa alternativa62 = new Alternativa();
				alternativa62.setDescricao("Taxista");

				// Garçonete
				Alternativa alternativa63 = new Alternativa();
				alternativa63.setDescricao("Garçonete");

				// Garçom
				Alternativa alternativa64 = new Alternativa();
				alternativa64.setDescricao("Garçom");

				// Banqueira
				Alternativa alternativa65 = new Alternativa();
				alternativa65.setDescricao("Banqueira");

				// Banqueiro
				Alternativa alternativa66 = new Alternativa();
				alternativa66.setDescricao("Banqueiro");

				// Secretária
				Alternativa alternativa67 = new Alternativa();
				alternativa67.setDescricao("Secretária");

				// Secretário
				Alternativa alternativa68 = new Alternativa();
				alternativa68.setDescricao("Secretário");
				
				// Cabeleireira
				Alternativa alternativa69 = new Alternativa();
				alternativa69.setDescricao("Cabeleireira");

				// Cabeleireiro
				Alternativa alternativa70 = new Alternativa();
				alternativa70.setDescricao("Cabeleireiro");

				// Manicure
				Alternativa alternativa71 = new Alternativa();
				alternativa71.setDescricao("Manicure");

				// Cientista
				Alternativa alternativa72 = new Alternativa();
				alternativa72.setDescricao("Cientista");

				// Astronauta 
				Alternativa alternativa73 = new Alternativa();
				alternativa73.setDescricao("Astronauta");

				// Policial
				Alternativa alternativa74 = new Alternativa();
				alternativa74.setDescricao("Policial");

				// Pintora
				Alternativa alternativa75 = new Alternativa();
				alternativa75.setDescricao("Pintora");

				// Pintor
				Alternativa alternativa76 = new Alternativa();
				alternativa76.setDescricao("Pintor");

				// Médica
				Alternativa alternativa77 = new Alternativa();
				alternativa77.setDescricao("Médica");

				// Médico
				Alternativa alternativa78 = new Alternativa();
				alternativa78.setDescricao("Médico");

				// Maquiadora
				Alternativa alternativa79 = new Alternativa();
				alternativa79.setDescricao("Maquiadora");

				// Maquiador
				Alternativa alternativa80 = new Alternativa();
				alternativa80.setDescricao("Maquiador");

				// Gari
				Alternativa alternativa81 = new Alternativa();
				alternativa81.setDescricao("Gari");

				// Jornalista
				Alternativa alternativa82 = new Alternativa();
				alternativa82.setDescricao("Jornalista");

				// Psicóloga
				Alternativa alternativa83 = new Alternativa();
				alternativa83.setDescricao("Psicóloga");

				// Psicólogo
				Alternativa alternativa84 = new Alternativa();
				alternativa84.setDescricao("Psicólogo");
				
				// Tênista
				Alternativa alternativa85 = new Alternativa();
				alternativa85.setDescricao("Tênista");
				
				// Estilista
				Alternativa alternativa86 = new Alternativa();
				alternativa86.setDescricao("Estilista");
				
				
				
				
				//Perguntas
				
				//Agricultor(a)
				Pergunta pergunta1 = new Pergunta();
				pergunta1.setDescricao("Eu adoro cuidar da terra, quem eu sou?");
				pergunta1.setQuantTentativas(3);
				perguntaDAO.save(pergunta1);
				
				//Floriculturista
				Pergunta pergunta2 = new Pergunta();
				pergunta2.setDescricao("Eu adoro trabalhar com plantas, quem eu sou?");
				pergunta2.setQuantTentativas(3);
				perguntaDAO.save(pergunta2);
				
				//Política(o)
				Pergunta pergunta3 = new Pergunta();
				pergunta3.setDescricao("Sou responsável por defender os interesses da população, quem eu sou?");
				pergunta3.setQuantTentativas(3);
				perguntaDAO.save(pergunta3);
				
				//Arquiteto(a)
				Pergunta pergunta4 = new Pergunta();
				pergunta4.setDescricao("Eu gosto de planejar casas e prédios, quem eu sou?");
				pergunta4.setQuantTentativas(3);
				perguntaDAO.save(pergunta4);
				
				//Babá
				Pergunta pergunta5 = new Pergunta();
				pergunta5.setDescricao("Eu gosto muito de trabalhar com crianças, quem eu sou?");
				pergunta5.setQuantTentativas(3);
				perguntaDAO.save(pergunta5);
				
				//Entregadora(o)
				Pergunta pergunta6 = new Pergunta();
				pergunta6.setDescricao("Meu dever é fazer com que as pessoas recebam suas encomendas, quem eu sou?");
				pergunta6.setQuantTentativas(3);
				perguntaDAO.save(pergunta6);
				
				//Cientista
				Pergunta pergunta7 = new Pergunta();
				pergunta7.setDescricao("Eu adoro pesquisar e descobrir coisas novas, quem eu sou?");
				pergunta7.setQuantTentativas(3);
				perguntaDAO.save(pergunta7);
				
				//Piloto/Pilota
				Pergunta pergunta8 = new Pergunta();
				pergunta8.setDescricao("Eu gosto de velocidade e de adrenalina, quem eu sou?");
				pergunta8.setQuantTentativas(3);
				perguntaDAO.save(pergunta8);
				
				//Manicure
				Pergunta pergunta9 = new Pergunta();
				pergunta9.setDescricao("Eu gosto de cuidar das unhas das pessoas, quem eu sou?");
				pergunta9.setQuantTentativas(3);
				perguntaDAO.save(pergunta9);
				
				//Policial 
				Pergunta pergunta10 = new Pergunta();
				pergunta10.setDescricao("Meu dever é defender a cidade, quem eu sou?");
				pergunta10.setQuantTentativas(3);
				perguntaDAO.save(pergunta10);
				
				
				
				//Midias
				
				
				// Midia imagem agricultor(a)
				Midia midia1 = new Midia();
				midia1.setCaminho("lalala");
				midia1.setDescricao("Dica em imagem agricultor" );
				midia1.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia1);
				
				//Midia imagem Floriculturista
				Midia midia2 = new Midia();
				midia2.setCaminho("lalala");
				midia2.setDescricao("Dica em imagem Floriculturista" );
				midia2.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia2);
				
				//Midia imagem política(o)
				Midia midia3 = new Midia();
				midia3.setCaminho("lalala");
				midia3.setDescricao("Dica em imagem política(o)" );
				midia3.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia3);
				
				//Midia imagem arquiteta(o)
				Midia midia4 = new Midia();
				midia4.setCaminho("lalala");
				midia4.setDescricao("Dica em imagem arquiteta(o)" );
				midia4.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia4);
				
				//Midia imagem babá
				Midia midia5 = new Midia();
				midia5.setCaminho("lalala");
				midia5.setDescricao("Dica em imagem babá" );
				midia5.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia5);
				
				//Midia imagem entregador(a)
				Midia midia6 = new Midia();
				midia6.setCaminho("lalala");
				midia6.setDescricao("Dica em imagem entregador(a)" );
				midia6.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia6);
				
				//Midia imagem cientista
				Midia midia7 = new Midia();
				midia7.setCaminho("lalala");
				midia7.setDescricao("Dica em imagem cientista" );
				midia7.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia7);
				
				//Midia imagem pilota(o)
				Midia midia8 = new Midia();
				midia8.setCaminho("lalala");
				midia8.setDescricao("Dica em imagem pilota(o)" );
				midia8.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia8);
				
				//Midia imagem manicure
				Midia midia9 = new Midia();
				midia9.setCaminho("lalala");
				midia9.setDescricao("Dica em imagem manicure" );
				midia9.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia9);
				
				//Midia imagem policial
				Midia midia10 = new Midia();
				midia10.setCaminho("lalala");
				midia10.setDescricao("Dica em imagem policial" );
				midia10.setTipoMidia(TipoMidia.FIGURA);
				midiaDAO.save(midia10);
				
				
				
				
				//Dicas
				
				
				//Dica Agricultor
				Dica dica1 = new Dica();
				midia1 = (Midia)midiaDAO.getById(1);
				dica1.setMidia(midia1);
				dicaDAO.save(dica1);
				
				//Dica Floriculturista
				Dica dica2 = new Dica();
				midia2 = (Midia)midiaDAO.getById(1);
				dica2.setMidia(midia2);
				dicaDAO.save(dica2);

				//Dica política(o)
				Dica dica3 = new Dica();
				midia3 = (Midia)midiaDAO.getById(1);
				dica3.setMidia(midia3);
				dicaDAO.save(dica3);
				
				//Dica arquiteta(o)
				Dica dica4 = new Dica();
				midia4 = (Midia)midiaDAO.getById(1);
				dica4.setMidia(midia4);
				dicaDAO.save(dica4);
				
				//Dica babá
				Dica dica5 = new Dica();
				midia5 = (Midia)midiaDAO.getById(1);
				dica5.setMidia(midia5);
				dicaDAO.save(dica5);
				
				//Dica entregador(a)
				Dica dica6 = new Dica();
				midia6 = (Midia)midiaDAO.getById(1);
				dica6.setMidia(midia6);
				dicaDAO.save(dica6);
				
				//Dica cientista
				Dica dica7 = new Dica();
				midia7 = (Midia)midiaDAO.getById(1);
				dica7.setMidia(midia7);
				dicaDAO.save(dica7);
				
				//Dica pilota(o)
				Dica dica8 = new Dica();
				midia8 = (Midia)midiaDAO.getById(1);
				dica8.setMidia(midia8);
				dicaDAO.save(dica8);
				
				//Dica manicure
				Dica dica9 = new Dica();
				midia9 = (Midia)midiaDAO.getById(1);
				dica9.setMidia(midia9);
				dicaDAO.save(dica1);
				
				//Dica policial
				Dica dica10 = new Dica();
				midia10 = (Midia)midiaDAO.getById(1);
				dica10.setMidia(midia10);
				dicaDAO.save(dica10);
				
				s.commit();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				s.rollback();
				
			} finally{
				s.close();
			}
		}	
	}
