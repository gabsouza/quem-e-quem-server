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

import br.com.daos.ResponsavelDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Responsavel;

@Path("/responsavel")
public class ResponsavelService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private ResponsavelDAO responsavelDAO = new ResponsavelDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idResponsavel}")
	public Responsavel consultar(@PathParam("idResponsavel") int id_responsavel){
		int exceptionNumber = 500;
		try{
			Responsavel responsavel = responsavelDAO.getById(id_responsavel);
			if (responsavel == null){
				exceptionNumber = 404;
				throw new Exception("No responsavel with this id");
			}
			return responsavel;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Responsavel> listar(){
		int exceptionNumber = 500;
		try{
			List<Responsavel> responsaveis = responsavelDAO.listAllResponsaveis();
			if (responsaveis.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No responsaveis registred");
				}
			return responsaveis;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Responsavel responsavel){
		try{
			sem.getEntityManager().getTransaction().begin();
			responsavel = responsavelDAO.save(responsavel);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity(responsavel).build();
		} catch (Exception e){
			e.printStackTrace();
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idResponsavel}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Responsavel responsavel){
		int exceptionNumber = 500;
		try{
			Responsavel responsavelput = responsavelDAO.getById(id);
			if(responsavelput == null){
				exceptionNumber = 404;
				throw new Exception("No responsavel with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				responsavel.setIdResponsavel(id);;
				responsavelDAO.save(responsavel);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Responsavel alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idResponsavel}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idResponsavel") int id_responsavel){
		int exceptionNumber = 500;
		try{
			Responsavel responsavel = responsavelDAO.getById(id_responsavel);
			if(responsavel == null){
				exceptionNumber = 404;
				throw new Exception("No responsavel with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			responsavelDAO.delete(responsavel);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Responsavel excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
