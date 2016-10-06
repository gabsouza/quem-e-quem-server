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

import br.com.daos.SeloDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Selo;

public class SeloService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private SeloDAO seloDAO = new SeloDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idSelo}")
	public Selo consultar(@PathParam("idSelo") int id_selo){
		int exceptionNumber = 500;
		try{
			Selo selo = seloDAO.getById(id_selo);
			if (selo == null){
				exceptionNumber = 404;
				throw new Exception("No miniJogo with this id");
			}
			return selo;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selo> listar(){
		int exceptionNumber = 500;
		try{
			List<Selo> selos = seloDAO.listAllSelos();
			if (selos.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No selos registred");
				}
			return selos;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Selo selo){
		try{
			sem.getEntityManager().getTransaction().begin();
			seloDAO.save(selo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Selo cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idSelo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Selo selo){
		int exceptionNumber = 500;
		try{
			Selo seloput = seloDAO.getById(id);
			if(seloput == null){
				exceptionNumber = 404;
				throw new Exception("No selo with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				selo.setIdSelo(id);
				seloDAO.save(selo);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Selo alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idSelo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idSelo") int id_selo){
		int exceptionNumber = 500;
		try{
			Selo selo = seloDAO.getById(id_selo);
			if(selo == null){
				exceptionNumber = 404;
				throw new Exception("No selo with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			seloDAO.delete(selo);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Selo excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
