package br.com.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.UsuarioMiniJogoDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.UsuarioMiniJogo;

public class UsuarioMiniJogoService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private UsuarioMiniJogoDAO usuarioMiniJogoDAO = new UsuarioMiniJogoDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idUsuarioMiniJogo}")
	public UsuarioMiniJogo consultar(@PathParam("idUsuarioMiniJogo") int id_usuario_mini_jogo){
		int exceptionNumber = 500;
		try{
			UsuarioMiniJogo usuarioMiniJogo = usuarioMiniJogoDAO.getById(id_usuario_mini_jogo);
			if (usuarioMiniJogo == null){
				exceptionNumber = 404;
				throw new Exception("No usuarioMiniJogo with this id");
			}
			return usuarioMiniJogo;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioMiniJogo> listar(){
		int exceptionNumber = 500;
		try{
			List<UsuarioMiniJogo> usuarioMiniJogos = usuarioMiniJogoDAO.listAllUsuariosMiniJogos();
			if (usuarioMiniJogos.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No usuarioMiniJogos registred");
				}
			return usuarioMiniJogos;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(UsuarioMiniJogo usuarioMiniJogo){
		try{
			sem.getEntityManager().getTransaction().begin();
			usuarioMiniJogoDAO.save(usuarioMiniJogo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("UsuarioMiniJogo cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idUsuarioMiniJogo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, UsuarioMiniJogo usuarioMiniJogo){
		int exceptionNumber = 500;
		try{
			UsuarioMiniJogo usuminijput = usuarioMiniJogoDAO.getById(id);
			if(usuminijput == null){
				exceptionNumber = 404;
				throw new Exception("No usuairoMiniJogo with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				usuarioMiniJogo.setIdUsuarioMiniJogo(id);
				usuarioMiniJogoDAO.save(usuarioMiniJogo);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("UsuarioMiniJogo alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idMiniJogo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idUsuarioMiniJogo") int id_usuario_mini_jogo){
		int exceptionNumber = 500;
		try{
			UsuarioMiniJogo usuarioMiniJogo = usuarioMiniJogoDAO.getById(id_usuario_mini_jogo);
			if(usuarioMiniJogo == null){
				exceptionNumber = 404;
				throw new Exception("No usuarioMiniJogo with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			usuarioMiniJogoDAO.delete(usuarioMiniJogo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("UsuarioMiniJogo excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
