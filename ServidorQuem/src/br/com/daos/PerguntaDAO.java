package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Alternativa;
import br.com.pojos.Pergunta;

public class PerguntaDAO extends GenericDAO<Integer, Pergunta>{

	public PerguntaDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todas as perguntas
	public List<Pergunta> listAllPerguntas(){
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		try{
			Query consulta = this.em.createQuery("Select perg from Pergunta perg");
			perguntas = consulta.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return perguntas;
	}
	
	// Retorna uma pergunta especifica
	public Pergunta listPerguntaPorId(){
		Pergunta perguntaId = new Pergunta();
		try{
			Query consultaId = this.em.createQuery("Select perg from Pergunta perg where perg.idPergunta = :id");
			consultaId.setParameter("id", 8);
			perguntaId = (Pergunta)consultaId.getSingleResult();	
		} catch (Exception e){
			System.out.println(e.getMessage());
			}
		return perguntaId;
		}
	
	// Retorna perguntas com determinadas letras	
	public List<Pergunta> listAllPerguntasPorNome(){
		List<Pergunta> perguntasPorNome = new ArrayList<Pergunta>();
		try{
			Query consultaPorNome = this.em.createQuery("Select perg from Pergunta perg where perg.descricao like :descricao");
			consultaPorNome.setParameter("nome", "%a%");
			perguntasPorNome = consultaPorNome.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return perguntasPorNome;
	}
}
