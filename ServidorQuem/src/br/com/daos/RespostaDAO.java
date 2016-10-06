package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Pergunta;
import br.com.pojos.Resposta;

public class RespostaDAO extends GenericDAO<Integer, Resposta>{
	
	public RespostaDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todas as respostas
		public List<Resposta> listAllRespostas(){
			List<Resposta> respostas = new ArrayList<Resposta>();
			try{
				Query consulta = this.em.createQuery("Select resposta from Resposta resposta");
				respostas = consulta.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return respostas;
		}
		
		// Retorna uma resposta especifica
		public Resposta listRespostaPorId(){
			Resposta respostaId = new Resposta();
			try{
				Query consultaId = this.em.createQuery("Select resposta from Resposta resposta where resposta.idResposta = :id");
				consultaId.setParameter("id", 2);
				respostaId = (Resposta)consultaId.getSingleResult();	
			} catch (Exception e){
				System.out.println(e.getMessage());
				}
			return respostaId;
			}
		
		// Retorna respostas com determinadas letras	
		public List<Resposta> listAllRespostasPorNome(){
			List<Resposta> respostasPorNome = new ArrayList<Resposta>();
			try{
				Query consultaPorNome = this.em.createQuery("Select resposta from Resposta resposta where resposta.alternativa like :alternativa");
				consultaPorNome.setParameter("alternativa", "%a%");
				respostasPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return respostasPorNome;
		}

}
