package br.com.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pojos.UsuarioMiniJogo;

public class UsuarioMiniJogoDAO extends GenericDAO<Integer, UsuarioMiniJogo> {

	public UsuarioMiniJogoDAO(EntityManager entity) {
		super(entity);
	}

			// Retorna todos os usuariosMiniJogos
			public List<UsuarioMiniJogo> listAllUsuariosMiniJogos(){
				List<UsuarioMiniJogo> usuariosMiniJogos = new ArrayList<UsuarioMiniJogo>();
				try{
					Query consulta = this.em.createQuery("Select u from UsuarioMiniJogo u");
					usuariosMiniJogos = consulta.getResultList();
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
				return usuariosMiniJogos;
			}
			
			// Retorna um usuarioMiniJogo especifico
			public UsuarioMiniJogo listUsuarioMiniJogoPorId(){
				UsuarioMiniJogo usuariosMiniJogoId = new UsuarioMiniJogo();
				try{
					Query consultaId = this.em.createQuery("Select u from UsuarioMiniJogo u where u.idUsuarioMiniJogo = :id");
					consultaId.setParameter("id", 2);
					usuariosMiniJogoId = (UsuarioMiniJogo)consultaId.getSingleResult();	
					} catch (Exception e){
						System.out.println(e.getMessage());
				}
				return usuariosMiniJogoId;
			}	
}
