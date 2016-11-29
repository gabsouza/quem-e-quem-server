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

import br.com.daos.PerguntaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Pergunta;

@Path("/pergunta")
public class PerguntaService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private PerguntaDAO perguntaDAO = new PerguntaDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idPergunta}")
	public Pergunta consultar(@PathParam("idPergunta") int id_pergunta){
		int exceptionNumber = 500;
		try{
			Pergunta pergunta = perguntaDAO.getById(id_pergunta);
			if (pergunta == null){
				exceptionNumber = 404;
				throw new Exception("No pergunta with this id");
			}
			return pergunta;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pergunta> listar(){
		int exceptionNumber = 500;
		try{
			List<Pergunta> perguntas = perguntaDAO.listAllPerguntas();
			if (perguntas.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No perguntas registred");
				}
			return perguntas;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Pergunta pergunta){
		try{
			sem.getEntityManager().getTransaction().begin();
			perguntaDAO.save(pergunta);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Pergunta cadastrada com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idPergunta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Pergunta pergunta){
		int exceptionNumber = 500;
		try{
			Pergunta perguntaput = perguntaDAO.getById(id);
			if(perguntaput == null){
				exceptionNumber = 404;
				throw new Exception("No pergunta with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				pergunta.setIdPergunta(id);
				perguntaDAO.save(pergunta);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Pergunta alterada com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idPergunta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idPergunta") int id_pergunta){
		int exceptionNumber = 500;
		try{
			Pergunta pergunta = perguntaDAO.getById(id_pergunta);
			if(pergunta == null){
				exceptionNumber = 404;
				throw new Exception("No pergunta with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			perguntaDAO.delete(pergunta);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Pergunta excluída com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
