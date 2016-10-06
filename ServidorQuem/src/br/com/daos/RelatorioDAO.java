package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.Pergunta;
import br.com.pojos.Relatorio;

public class RelatorioDAO extends GenericDAO<Integer, Relatorio> {
	
	public RelatorioDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todos os relatorios
		public List<Relatorio> listAllRelatorios(){
			List<Relatorio> relatorios = new ArrayList<Relatorio>();
			try{
				Query consulta = this.em.createQuery("Select r from Relatorio r");
				relatorios = consulta.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return relatorios;
		}
		
		// Retorna um relatorio especifico
		public Relatorio listRelatorioPorId(){
			Relatorio relatorioId = new Relatorio();
			try{
				Query consultaId = this.em.createQuery("Select r from Relatorio r where r.idRelatorio = :id");
				consultaId.setParameter("id", 2);
				relatorioId = (Relatorio)consultaId.getSingleResult();	
			} catch (Exception e){
				System.out.println(e.getMessage());
				}
			return relatorioId;
			}
		
		// Retorna relatorios com determinadas letras	
		public List<Relatorio> listAllReatoriosPorNome(){
			List<Relatorio> relatoriosPorNome = new ArrayList<Relatorio>();
			try{
				Query consultaPorNome = this.em.createQuery("Select r from Relatorio r where r.informacoes like :informacoes");
				consultaPorNome.setParameter("informacoes", "%a%");
				relatoriosPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return relatoriosPorNome;
		}

}
