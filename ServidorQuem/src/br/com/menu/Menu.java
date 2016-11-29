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
		
//		try{
//			sem.beginTransaction();
//			List<Cliente> clientes = clienteDAO.listAllClientes();
//			Cliente clientesId = clienteDAO.listClientePorId();
//			List<Cliente> clientesPorNome = clienteDAO.listAllClientesPorNome();
//			List<Locacao> locacoes = locacaoDAO.listAllLocacoes();
//			sem.commit();
//			
//			for(Cliente cliente : clientes){
//				System.out.println(cliente.getMatricula());
//				System.out.println(cliente.getNome());
//				System.out.println(cliente.getCpf());
//				System.out.println(cliente.getDataCadastro());
//				System.out.println(cliente.getNascimento());
//				System.out.println(cliente.getStatus());
//				
//				// Colocando contato:
//				for(Contato c : cliente.getContatos()){
//					System.out.println(c.getIdContato() + " , " +  c.getTipo() + " , " + c.getInfo() + " "  );
//				}
//				// Como endereco é um array, devemos colocar assim:
//				for(Endereco e : cliente.getEnderecos()){
//					System.out.println(e.getRua() + " - " + e.getNumero() + " , " + e.getBairro() + " , " + e.getCidade() + 
//										" , " + e.getEstado() + " , " + e.getCep());
//				}
//				for(Locacao locacao : locacoes){
//					System.out.println(locacao.getTipo());
//					System.out.println(locacao.getTitulo());
//					System.out.println(locacao.getClassificacao());
//					System.out.println(locacao.getDataentrega());
//					System.out.println(locacao.getDatasaida());
//					System.out.println(locacao.getGenero());
//					System.out.println(locacao.getPreco());
//				}
//			
//			System.out.println(clientesId.getNome());
//			
//			
//			for(Cliente cliente : clientesPorNome){
//				System.out.println(cliente.getMatricula());
//				System.out.println(cliente.getNome());
//				System.out.println(cliente.getCpf());
//				System.out.println(cliente.getDataCadastro());
//				System.out.println(cliente.getNascimento());
//				System.out.println(cliente.getStatus());
//				System.out.println("-----------------");
//			}
//		} catch (Exception e){
//			System.out.println("Ocorreu um erro: " + e.getMessage());
//		} finally {
//			sem.close();
//		}
	}	
}
