package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Perfil;

public class PerfilDAO extends GenericDAO<Integer, Perfil> {
	
	public PerfilDAO(EntityManager entity){
		super(entity);
	}
	
		// Retorna todos os perfis
		public List<Perfil> listAllPerfis(){
			List<Perfil> perfis = new ArrayList<Perfil>();
			try{
				Query consulta = this.em.createQuery("Select p from Perfil p");
				perfis = consulta.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
				}
			return perfis;
			}	
			
		// Retorna um perfil especifico
		public Perfil listPerfilPorId(){
			Perfil perfilId = new Perfil();
			try{
				Query consultaId = this.em.createQuery("Select p from Perfil p where p.idPerfil = :id");
				consultaId.setParameter("id", 2);
				perfilId = (Perfil)consultaId.getSingleResult();	
			} catch (Exception e){
				System.out.println(e.getMessage());
				}
			return perfilId;
			}
		
		// Retorna perfis com determinadas letras	
		public List<Perfil> listAllPerfilPorNome(){
		List<Perfil> perfisPorNome = new ArrayList<Perfil>();
			try{
				Query consultaPorNome = this.em.createQuery("Select p from Perfil p where p.nomePerfil like :nomePerfil");
				consultaPorNome.setParameter("nomePerfil", "%a%");
				perfisPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return perfisPorNome;
		}
}
