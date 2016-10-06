package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Alternativa;
import br.com.pojos.Dica;
import br.com.pojos.Perfil;

public class DicaDAO extends GenericDAO<Integer, Dica>{
	
	public DicaDAO(EntityManager entity){
		super(entity);
	}

	// Retorna todas as dicas
	public List<Dica> listAllDicas(){
		List<Dica> dicas = new ArrayList<Dica>();
		try{
			Query consulta = this.em.createQuery("Select d from Dica d");
			dicas = consulta.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return dicas;
	}
	
	// Retorna uma dica especifica
	public Dica listDicaPorId(){
				Dica dicaId = new Dica();
				try{
					Query consultaId = this.em.createQuery("Select d from Dica d where d.idDica = :id");
					consultaId.setParameter("id", 1);
					dicaId = (Dica)consultaId.getSingleResult();	
				} catch (Exception e){
					System.out.println(e.getMessage());
					}
				return dicaId;
				}
	
	// Retorna dicas com determinadas letras	
	public List<Dica> listAllDicaPorNome(){
		List<Dica> dicasPorNome = new ArrayList<Dica>();
		try{
			Query consultaPorNome = this.em.createQuery("Select d from Dica d where d.midia like :midia");
			consultaPorNome.setParameter("midia", "%a%");
			dicasPorNome = consultaPorNome.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return dicasPorNome;
	}
}
