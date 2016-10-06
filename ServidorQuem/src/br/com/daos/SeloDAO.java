package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Selo;

public class SeloDAO extends GenericDAO<Integer, Selo> {

	public SeloDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todos os selos
			public List<Selo> listAllSelos(){
				List<Selo> selos = new ArrayList<Selo>();
				try{
					Query consulta = this.em.createQuery("Select s from Selo s");
					selos = consulta.getResultList();
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
				return selos;
			}
			
			// Retorna um selo especifico
			public Selo listSeloPorId(){
				Selo seloId = new Selo();
				try{
					Query consultaId = this.em.createQuery("Select s from Selo s where s.idSelo = :id");
					consultaId.setParameter("id", 2);
					seloId = (Selo)consultaId.getSingleResult();	
					} catch (Exception e){
						System.out.println(e.getMessage());
				}
				return seloId;
			}
			
			public List<Selo> listAllSeloPorNome(){
			List<Selo> selosPorNome = new ArrayList<Selo>();
			try{
				Query consultaPorNome = this.em.createQuery("Select s from Selo s where s.nomeSelo like :nomeSelo");
				consultaPorNome.setParameter("nomeSelo", "%a%");
				selosPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return selosPorNome;
		}
}
