package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Dica;
import br.com.pojos.Midia;

public class MidiaDAO extends GenericDAO<Integer, Midia> {

	public MidiaDAO(EntityManager entity) {
		super(entity);
	}
	
	// Retorna todas as midias
	public List<Midia> listAllMidias(){
		List<Midia> midias = new ArrayList<Midia>();
		try{
			Query consulta = this.em.createQuery("Select m from Midia m");
			midias = consulta.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return midias;
	}
	
	// Retorna uma midia especifica
			public Midia listMidiaPorId(){
				Midia midiaId = new Midia();
				try{
					Query consultaId = this.em.createQuery("Select m from Midia m where m.idMidia = :id");
					consultaId.setParameter("id", 2);
					midiaId = (Midia)consultaId.getSingleResult();	
				} catch (Exception e){
					System.out.println(e.getMessage());
					}
				return midiaId;
				}
	
	// Retorna midias com determinadas letras	
	public List<Midia> listAllMidiaPorNome(){
		List<Midia> midiasPorNome = new ArrayList<Midia>();
		try{
			Query consultaPorNome = this.em.createQuery("Select m from Midia m where m.descricao like :descricao");
			consultaPorNome.setParameter("descricao", "%a%");
			midiasPorNome = consultaPorNome.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return midiasPorNome;
	}
}



