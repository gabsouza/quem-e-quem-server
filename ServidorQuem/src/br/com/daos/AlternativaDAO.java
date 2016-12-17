package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Alternativa;
import br.com.pojos.GeneroPersonagem;

public class AlternativaDAO extends GenericDAO<Integer, Alternativa> {

	public AlternativaDAO(EntityManager entity) {
		super(entity);
	}

	// Retorna todas as alternativas
	public List<Alternativa> listAllAlternativas() {
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		try {
			Query consulta = this.em.createQuery("Select a from Alternativa a");
			alternativas = consulta.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alternativas;
	}

	// Retorna uma alternativa especifica
	public Alternativa listAlternativaPorId(int idAlternativa) {
		Alternativa alternativaId = new Alternativa();
		try {
			Query consultaId = this.em.createQuery("Select a from Alternativa a where a.idAlternativa = :id");
			consultaId.setParameter("id", idAlternativa);
			alternativaId = (Alternativa) consultaId.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alternativaId;
	}

	public List<Alternativa> listarAlternativasPorIdPergunta(int idPergunta) {
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		try {
			Query consulta = this.em.createQuery("Select a from Alternativa a where a.pergunta.idPergunta = :id");
			consulta.setParameter("id", idPergunta);
			alternativas = consulta.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alternativas;
	}

//	public List<Alternativa> buscarAlternativasIncorretas(int idAlternativa1, int idAlternativa2,
//			int numeroDeAlternativas) {
//		List<Alternativa> alternativas = new ArrayList<Alternativa>();
//		try {
//			Query consulta = this.em.createQuery(
//					"Select a from Alternativa a where a.pergunta.idPergunta != :id1 and "
//					+ "a.pergunta.idPergunta != :id2");
//			consulta.setParameter("id1", idAlternativa1);
//			consulta.setParameter("id2", idAlternativa2);
//			consulta.setMaxResults(numeroDeAlternativas);
//			alternativas = consulta.getResultList();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return alternativas;
//	}

	// Tentativa
	public List<Alternativa> buscarAlternativasIncorretas(int idAlternativa1, int idAlternativa2,
			 int numeroDeAlternativas, String generoPersonagem) {
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		try {
			Query consulta = this.em.createQuery(
					"Select a from Alternativa a where a.pergunta.idPergunta != :id1 and a.pergunta.idPergunta != :id2 "
					+ "and a.generoPersonagem = :genPersonagem or a.generoPersonagem = :neutro");
			consulta.setParameter("id1", idAlternativa1);
			consulta.setParameter("id2", idAlternativa2);
			if(generoPersonagem.equalsIgnoreCase("FEMININO")){
				consulta.setParameter("genPersonagem", GeneroPersonagem.FEMININO);
			}else{
				if(generoPersonagem.equalsIgnoreCase("MASCULINO")){
					consulta.setParameter("genPersonagem", GeneroPersonagem.MASCULINO);
				}
			}
			consulta.setParameter("neutro", GeneroPersonagem.NEUTRO);
			consulta.setMaxResults(numeroDeAlternativas);
			alternativas = consulta.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alternativas;
	}


	// Retorna altenativas com determinadas letras
	public List<Alternativa> listAllAlternativasPorNome() {
		List<Alternativa> alternativasPorNome = new ArrayList<Alternativa>();
		try {
			Query consultaPorNome = this.em
					.createQuery("Select a from Alternativa a where a.descricao like :descricao");
			consultaPorNome.setParameter("descricao", "%a%");
			alternativasPorNome = consultaPorNome.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alternativasPorNome;
	}

}
