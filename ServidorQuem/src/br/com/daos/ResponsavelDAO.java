package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Responsavel;

public class ResponsavelDAO extends GenericDAO<Integer, Responsavel>{
	
	public ResponsavelDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todos os responsaveis
		public List<Responsavel> listAllResponsaveis(){
			List<Responsavel> responsaveis = new ArrayList<Responsavel>();
			try{
				Query consulta = this.em.createQuery("Select resp from Responsavel resp");
				responsaveis = consulta.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return responsaveis;
		}
		
		// Retorna um responsavel especifico
		public Responsavel listResponsavelPorId(){
			Responsavel responsavelId = new Responsavel();
			try{
				Query consultaId = this.em.createQuery("Select resp from Responsavel resp where resp.idResponsavel = :id");
				consultaId.setParameter("id", 2);
				responsavelId = (Responsavel)consultaId.getSingleResult();	
				} catch (Exception e){
					System.out.println(e.getMessage());
			}
			return responsavelId;
		}
		
		//Retorna responsaveis com letras especificas
		public List<Responsavel> listAllResponsavelPorNome(){
		List<Responsavel> responsaveisPorNome = new ArrayList<Responsavel>();
		try{
			Query consultaPorNome = this.em.createQuery("Select resp from Responsavel resp where resp.nomeResponsavel like :nomeResponsavel");
			consultaPorNome.setParameter("nomeResponsavel", "%a%");
			responsaveisPorNome = consultaPorNome.getResultList();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return responsaveisPorNome;
	}

}
