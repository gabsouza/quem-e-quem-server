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
import br.com.pojos.StatusAlternativa;
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
				alternativa1.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa1);
				
				// Árbitro
				Alternativa alternativa2 = new Alternativa();
				alternativa2.setDescricao("Árbitro");
				alternativa2.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa2);
				
				// Juíza
				Alternativa alternativa3 = new Alternativa();
				alternativa3.setDescricao("Juíza");
				alternativa3.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa3);
				
				// Juíz
				Alternativa alternativa4 = new Alternativa();
				alternativa4.setDescricao("Juíz");
				alternativa4.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa4);

				// Veterinária
				Alternativa alternativa5 = new Alternativa();
				alternativa5.setDescricao("Veterinária");
				alternativa5.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa5);
				
				// Veterinário
				Alternativa alternativa6 = new Alternativa();
				alternativa6.setDescricao("Veterinário");
				alternativa6.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa6);

				// Tratadora de animais - Tratador de animais
				Alternativa alternativa7 = new Alternativa();
				alternativa7.setDescricao("Tratadora de animais");
				alternativa7.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa7);
				
				// Tratador de animais
				Alternativa alternativa8 = new Alternativa();
				alternativa8.setDescricao("Tratador de animais");
				alternativa8.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa8);
				
				// Zeladora
				Alternativa alternativa9 = new Alternativa();
				alternativa9.setDescricao("Zeladora");
				alternativa9.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa9);

				// Zelador
				Alternativa alternativa10 = new Alternativa();
				alternativa10.setDescricao("Zelador");
				alternativa10.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa10);

				// Pilota
				Alternativa alternativa11 = new Alternativa();
				alternativa11.setDescricao("Pilota");
				alternativa11.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa11);

				// Piloto
				Alternativa alternativa12 = new Alternativa();
				alternativa12.setDescricao("Piloto");
				alternativa12.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa12);

				// Prisidenta
				Alternativa alternativa13 = new Alternativa();
				alternativa13.setDescricao("Político");
				alternativa13.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa13);

				// Presidente
				Alternativa alternativa14 = new Alternativa();
				alternativa14.setDescricao("Político");
				alternativa14.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa14);

				// Nutricionista
				Alternativa alternativa15 = new Alternativa();
				alternativa15.setDescricao("Nutricionista");
				alternativa15.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa15);

				// Massagista
				Alternativa alternativa16 = new Alternativa();
				alternativa16.setDescricao("Massagista");
				alternativa16.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa16);

				// Babá
				Alternativa alternativa17 = new Alternativa();
				alternativa17.setDescricao("Babá");
				alternativa17.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa17);

				// Costureira
				Alternativa alternativa18 = new Alternativa();
				alternativa18.setDescricao("Costureira");
				alternativa18.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa18);

				// Costureiro
				Alternativa alternativa19 = new Alternativa();
				alternativa19.setDescricao("Costureiro");
				alternativa19.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa19);

				// Decoradora
				Alternativa alternativa20 = new Alternativa();
				alternativa20.setDescricao("Decoradora");
				alternativa20.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa20);

				// Decorador
				Alternativa alternativa21 = new Alternativa();
				alternativa21.setDescricao("Decorador");
				alternativa21.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa21);

				// Arquiteta
				Alternativa alternativa22 = new Alternativa();
				alternativa22.setDescricao("Arquiteta");
				alternativa22.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa22);

				// Arquiteto
				Alternativa alternativa23 = new Alternativa();
				alternativa23.setDescricao("Arquiteto");
				alternativa23.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa23);

				// Pedreira
				Alternativa alternativa24 = new Alternativa();
				alternativa24.setDescricao("Pedreira");
				alternativa24.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa24);

				// Pedreiro
				Alternativa alternativa25 = new Alternativa();
				alternativa25.setDescricao("Pedreiro");
				alternativa25.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa25);

				// Eletricista
				Alternativa alternativa26 = new Alternativa();
				alternativa26.setDescricao("Eletricista");
				alternativa26.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa26);

				// Salva-vidas
				Alternativa alternativa27 = new Alternativa();
				alternativa27.setDescricao("Salva-vidas");
				alternativa27.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa27);

				// Vendedora
				Alternativa alternativa28 = new Alternativa();
				alternativa28.setDescricao("Vendedora");
				alternativa28.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa28);

				// Vendedor
				Alternativa alternativa29 = new Alternativa();
				alternativa29.setDescricao("Vendedor");
				alternativa29.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa29);

				// Cozinheira
				Alternativa alternativa30 = new Alternativa();
				alternativa30.setDescricao("Cozinheira");
				alternativa30.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa30);

				// Cozinheiro
				Alternativa alternativa31 = new Alternativa();
				alternativa31.setDescricao("Cozinheiro");
				alternativa31.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa31);

				// Jardineira
				Alternativa alternativa32 = new Alternativa();
				alternativa32.setDescricao("Jardineira");
				alternativa32.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa32);

				// Jardineiro
				Alternativa alternativa33 = new Alternativa();
				alternativa33.setDescricao("Jardineiro");
				alternativa7.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa7);

				// Agricultor
				Alternativa alternativa34 = new Alternativa();
				alternativa34.setDescricao("Agricultor");
				alternativa34.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa34);

				// Agricultora
				Alternativa alternativa35 = new Alternativa();
				alternativa35.setDescricao("Agricultora");
				alternativa35.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa35);

				// Entregadora
				Alternativa alternativa36 = new Alternativa();
				alternativa36.setDescricao("Entregadora");
				alternativa36.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa36);

				// Entregador
				Alternativa alternativa37 = new Alternativa();
				alternativa37.setDescricao("Entregador");
				alternativa37.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa37);

				// Sorveteira
				Alternativa alternativa38 = new Alternativa();
				alternativa38.setDescricao("Sorveteira");
				alternativa38.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa38);

				// Sorveteiro
				Alternativa alternativa39 = new Alternativa();
				alternativa39.setDescricao("Sorveteiro");
				alternativa39.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa39);

				// Carteira
				Alternativa alternativa40 = new Alternativa();
				alternativa40.setDescricao("Carteira");
				alternativa40.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa40);

				// Carteiro
				Alternativa alternativa41 = new Alternativa();
				alternativa41.setDescricao("Carteiro");
				alternativa41.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa41);

				// Segurança
				Alternativa alternativa42 = new Alternativa();
				alternativa42.setDescricao("Segurança");
				alternativa42.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa42);

				// Enfermeira
				Alternativa alternativa43 = new Alternativa();
				alternativa43.setDescricao("Enfermeira");
				alternativa43.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa43);

				// Enfermeiro
				Alternativa alternativa44 = new Alternativa();
				alternativa44.setDescricao("Enfermeiro");
				alternativa44.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa44);

				// Caminhoneira
				Alternativa alternativa45 = new Alternativa();
				alternativa45.setDescricao("Caminhoneira");
				alternativa45.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa45);

				// Caminhoneiro
				Alternativa alternativa46 = new Alternativa();
				alternativa46.setDescricao("Caminhoneiro");
				alternativa46.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa46);

				// Faxineira
				Alternativa alternativa47 = new Alternativa();
				alternativa47.setDescricao("Faxineira");
				alternativa47.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa47);

				// Faxineiro
				Alternativa alternativa48 = new Alternativa();
				alternativa48.setDescricao("Faxineiro");
				alternativa48.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa48);

				// Professora
				Alternativa alternativa49 = new Alternativa();
				alternativa49.setDescricao("Professora");
				alternativa49.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa49);

				// Professor
				Alternativa alternativa50 = new Alternativa();
				alternativa50.setDescricao("Professor");
				alternativa50.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa50);

				// Bailarino
				Alternativa alternativa51 = new Alternativa();
				alternativa51.setDescricao("Bailarino");
				alternativa51.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa51);

				// Bailarina
				Alternativa alternativa52 = new Alternativa();
				alternativa52.setDescricao("Bailarina");
				alternativa52.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa52);

				// Curadora
				Alternativa alternativa53 = new Alternativa();
				alternativa53.setDescricao("Curadora");
				alternativa53.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa53);

				// Curador
				Alternativa alternativa54 = new Alternativa();
				alternativa54.setDescricao("Curador");
				alternativa54.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa54);

				// Bombeira
				Alternativa alternativa55 = new Alternativa();
				alternativa55.setDescricao("Bombeira");
				alternativa55.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa55);

				// Bombeiro
				Alternativa alternativa56 = new Alternativa();
				alternativa56.setDescricao("Bombeiro");
				alternativa56.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa56);

				// Jogadora de Futebol
				Alternativa alternativa57 = new Alternativa();
				alternativa57.setDescricao("Jogadora de Futebol");
				alternativa57.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa57);

				// Jogador de Futebol
				Alternativa alternativa58 = new Alternativa();
				alternativa58.setDescricao("Jogador de Futebol");
				alternativa58.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa58);

				// Floriculturista
				Alternativa alternativa59 = new Alternativa();
				alternativa59.setDescricao("Floriculturista");
				alternativa59.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa59);

				// Mecânica
				Alternativa alternativa60 = new Alternativa();
				alternativa60.setDescricao("Mecânica");
				alternativa60.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa60);

				// Mecânico
				Alternativa alternativa61 = new Alternativa();
				alternativa61.setDescricao("Mecânico");
				alternativa61.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa61);

				// Taxista
				Alternativa alternativa62 = new Alternativa();
				alternativa62.setDescricao("Taxista");
				alternativa62.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa62);

				// Garçonete
				Alternativa alternativa63 = new Alternativa();
				alternativa63.setDescricao("Garçonete");
				alternativa63.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa63);

				// Garçom
				Alternativa alternativa64 = new Alternativa();
				alternativa64.setDescricao("Garçom");
				alternativa64.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa64);

				// Banqueira
				Alternativa alternativa65 = new Alternativa();
				alternativa65.setDescricao("Banqueira");
				alternativa65.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa65);

				// Banqueiro
				Alternativa alternativa66 = new Alternativa();
				alternativa66.setDescricao("Banqueiro");
				alternativa66.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa66);

				// Secretária
				Alternativa alternativa67 = new Alternativa();
				alternativa67.setDescricao("Secretária");
				alternativa67.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa67);

				// Secretário
				Alternativa alternativa68 = new Alternativa();
				alternativa68.setDescricao("Secretário");
				alternativa68.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa68);
				
				// Cabeleireira
				Alternativa alternativa69 = new Alternativa();
				alternativa69.setDescricao("Cabeleireira");
				alternativa69.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa69);

				// Cabeleireiro
				Alternativa alternativa70 = new Alternativa();
				alternativa70.setDescricao("Cabeleireiro");
				alternativa70.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa70);

				// Manicure
				Alternativa alternativa71 = new Alternativa();
				alternativa71.setDescricao("Manicure");
				alternativa71.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa71);

				// Cientista
				Alternativa alternativa72 = new Alternativa();
				alternativa72.setDescricao("Cientista");
				alternativa72.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa72);

				// Astronauta 
				Alternativa alternativa73 = new Alternativa();
				alternativa73.setDescricao("Astronauta");
				alternativa73.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa73);

				// Policial
				Alternativa alternativa74 = new Alternativa();
				alternativa74.setDescricao("Policial");
				alternativa74.setStatusAlternativa(StatusAlternativa.CORRETA);
				alternativaDAO.save(alternativa74);

				// Pintora
				Alternativa alternativa75 = new Alternativa();
				alternativa75.setDescricao("Pintora");
				alternativa75.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa75);

				// Pintor
				Alternativa alternativa76 = new Alternativa();
				alternativa76.setDescricao("Pintor");
				alternativa76.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa76);

				// Médica
				Alternativa alternativa77 = new Alternativa();
				alternativa77.setDescricao("Médica");
				alternativa77.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa77);

				// Médico
				Alternativa alternativa78 = new Alternativa();
				alternativa78.setDescricao("Médico");
				alternativa78.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa78);

				// Maquiadora
				Alternativa alternativa79 = new Alternativa();
				alternativa79.setDescricao("Maquiadora");
				alternativa79.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa79);

				// Maquiador
				Alternativa alternativa80 = new Alternativa();
				alternativa80.setDescricao("Maquiador");
				alternativa80.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa80);

				// Gari
				Alternativa alternativa81 = new Alternativa();
				alternativa81.setDescricao("Gari");
				alternativa81.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa81);

				// Jornalista
				Alternativa alternativa82 = new Alternativa();
				alternativa82.setDescricao("Jornalista");
				alternativa82.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa82);

				// Psicóloga
				Alternativa alternativa83 = new Alternativa();
				alternativa83.setDescricao("Psicóloga");
				alternativa83.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa83);

				// Psicólogo
				Alternativa alternativa84 = new Alternativa();
				alternativa84.setDescricao("Psicólogo");
				alternativa84.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa84);
				
				// Tênista
				Alternativa alternativa85 = new Alternativa();
				alternativa85.setDescricao("Tênista");
				alternativa85.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa85);
				
				// Estilista
				Alternativa alternativa86 = new Alternativa();
				alternativa86.setDescricao("Estilista");
				alternativa86.setStatusAlternativa(StatusAlternativa.ERRADA);
				alternativaDAO.save(alternativa86);
			
			
				
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
