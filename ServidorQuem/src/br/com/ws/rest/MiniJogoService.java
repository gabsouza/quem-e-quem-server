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

import br.com.daos.MiniJogoDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.MiniJogo;

public class MiniJogoService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private MiniJogoDAO miniJogoDAO = new MiniJogoDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idMiniJogo}")
	public MiniJogo consultar(@PathParam("idMiniJogo") int id_mini_jogo){
		int exceptionNumber = 500;
		try{
			MiniJogo miniJogo = miniJogoDAO.getById(id_mini_jogo);
			if (miniJogo == null){
				exceptionNumber = 404;
				throw new Exception("No miniJogo with this id");
			}
			return miniJogo;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MiniJogo> listar(){
		int exceptionNumber = 500;
		try{
			List<MiniJogo> miniJogos = miniJogoDAO.listAllMiniJogos();
			if (miniJogos.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No miniJogos registred");
				}
			return miniJogos;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(MiniJogo miniJogo){
		try{
			sem.getEntityManager().getTransaction().begin();
			miniJogoDAO.save(miniJogo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("MiniJogo cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idMiniJogo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, MiniJogo miniJogo){
		int exceptionNumber = 500;
		try{
			MiniJogo minijput = miniJogoDAO.getById(id);
			if(minijput == null){
				exceptionNumber = 404;
				throw new Exception("No miniJogo with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				miniJogo.setIdMiniJogo(id);
				miniJogoDAO.save(miniJogo);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("MiniJogo alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idMiniJogo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idMiniJogo") int id_mini_jogo){
		int exceptionNumber = 500;
		try{
			MiniJogo miniJogo = miniJogoDAO.getById(id_mini_jogo);
			if(miniJogo == null){
				exceptionNumber = 404;
				throw new Exception("No miniJogo with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			miniJogoDAO.delete(miniJogo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("MiniJogo excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}

}
