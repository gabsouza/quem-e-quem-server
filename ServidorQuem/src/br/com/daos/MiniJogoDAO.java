package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.MiniJogo;

public class MiniJogoDAO extends GenericDAO<Integer, MiniJogo> {
	
	public MiniJogoDAO(EntityManager entity){
		super(entity);
	}
	
	// Retorna todos os miniJogos
			public List<MiniJogo> listAllMiniJogos(){
				List<MiniJogo> miniJogos = new ArrayList<MiniJogo>();
				try{
					Query consulta = this.em.createQuery("Select mj from MiniJogo mj");
					miniJogos = consulta.getResultList();
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
				return miniJogos;
			}
			
			// Retorna um miniJogo especifico
			public MiniJogo listMiniJogoPorId(){
				MiniJogo miniJogoId = new MiniJogo();
				try{
					Query consultaId = this.em.createQuery("Select mj from MiniJogo mj where mj.idMiniJogo = :id");
					consultaId.setParameter("id", 2);
					miniJogoId = (MiniJogo)consultaId.getSingleResult();	
					} catch (Exception e){
						System.out.println(e.getMessage());
				}
				return miniJogoId;
			}
			
			// Retorna um miniJogo com determinadas letras
			public List<MiniJogo> listAllMiniJogoPorNome(){
			List<MiniJogo> miniJogosPorNome = new ArrayList<MiniJogo>();
			try{
				Query consultaPorNome = this.em.createQuery("Select mj from MiniJogo mj where mj.nomeMiniJogo like :nomeMiniJogo");
				consultaPorNome.setParameter("nomeMiniJogo", "%a%");
				miniJogosPorNome = consultaPorNome.getResultList();
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			return miniJogosPorNome;
		}

}
