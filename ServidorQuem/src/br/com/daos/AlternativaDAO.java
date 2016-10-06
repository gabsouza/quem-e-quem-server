package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Alternativa;
import br.com.pojos.Dica;

public class AlternativaDAO extends GenericDAO<Integer, Alternativa> {

	public AlternativaDAO(EntityManager entity) {
		super(entity);
	}
	
	// Retorna todas as alternativas
		public List<Alternativa> listAllAlternativas(){
			List<Alternativa> alternativas = new ArrayList<Alternativa>();
			try{
				Query consulta = this.em.createQuery("Select a from Alternativa a");
				alternativas = consulta.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return alternativas;
		}
		
		// Retorna uma alternativa especifica
		public Alternativa listAlternativaPorId(int idAlternativa){
			Alternativa alternativaId = new Alternativa();
			try{
				Query consultaId = this.em.createQuery("Select a from Alternativa a where a.idAlternativa = :id");
				consultaId.setParameter("id", idAlternativa);
				alternativaId = (Alternativa)consultaId.getSingleResult();	
			} catch (Exception e){
				System.out.println(e.getMessage());
				}
			return alternativaId;
			}
		
		
//		public Alternativa consultaId(int idAlternativa){
//			em.getTransaction().begin();
//			Alternativa alternativa = em.find(Alternativa.class, idAlternativa);
//			em.getTransaction().commit();
//			return alternativa;
//		}
		
		// Retorna altenativas com determinadas letras		
		public List<Alternativa> listAllAlternativasPorNome(){
			List<Alternativa> alternativasPorNome = new ArrayList<Alternativa>();
			try{
				Query consultaPorNome = this.em.createQuery("Select a from Alternativa a where a.descricao like :descricao");
				consultaPorNome.setParameter("descricao", "%a%");
				alternativasPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return alternativasPorNome;
		}
		
}


