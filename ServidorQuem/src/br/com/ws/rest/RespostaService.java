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

import br.com.daos.RespostaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Resposta;

public class RespostaService {
	
	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private RespostaDAO respostaDAO = new RespostaDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idResposta}")
	public Resposta consultar(@PathParam("idResposta") int id_resposta){
		int exceptionNumber = 500;
		try{
			Resposta resposta = respostaDAO.getById(id_resposta);
			if (resposta == null){
				exceptionNumber = 404;
				throw new Exception("No resposta with this id");
			}
			return resposta;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resposta> listar(){
		int exceptionNumber = 500;
		try{
			List<Resposta> respostas = respostaDAO.listAllRespostas();
			if (respostas.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No respostas registred");
				}
			return respostas;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Resposta resposta){
		try{
			sem.getEntityManager().getTransaction().begin();
			respostaDAO.save(resposta);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Resposta cadastrada com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idResposta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Resposta resposta){
		int exceptionNumber = 500;
		try{
			Resposta respostaput = respostaDAO.getById(id);
			if(respostaput == null){
				exceptionNumber = 404;
				throw new Exception("No resposta with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				resposta.setIdResposta(id);
				respostaDAO.save(resposta);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Resposta alterada com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idResposta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idResposta") int id_resposta){
		int exceptionNumber = 500;
		try{
			Resposta resposta = respostaDAO.getById(id_resposta);
			if(resposta == null){
				exceptionNumber = 404;
				throw new Exception("No resposta with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			respostaDAO.delete(resposta);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Resposta excluída com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
