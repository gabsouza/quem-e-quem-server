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

import br.com.daos.MidiaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Midia;

@Path("/midia")
public class MidiaService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private MidiaDAO midiaDAO = new MidiaDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idMidia}")
	public Midia consultar(@PathParam("idMidia") int id_midia){
		int exceptionNumber = 500;
		try{
			Midia midia = midiaDAO.getById(id_midia);
			if (midia == null){
				exceptionNumber = 404;
				throw new Exception("No midia with this id");
			}
			return midia;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Midia> listar(){
		int exceptionNumber = 500;
		try{
			List<Midia> midias = midiaDAO.listAllMidias();
			if (midias.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No midias registred");
				}
			return midias;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Midia midia){
		try{
			sem.getEntityManager().getTransaction().begin();
			midiaDAO.save(midia);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Midia cadastrada com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idMidia}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Midia midia){
		int exceptionNumber = 500;
		try{
			Midia midiaput = midiaDAO.getById(id);
			if(midiaput == null){
				exceptionNumber = 404;
				throw new Exception("No midia with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				midia.setIdMidia(id);;
				midiaDAO.save(midia);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Midia alterada com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idMidia}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idMidia") int id_midia){
		int exceptionNumber = 500;
		try{
			Midia midia = midiaDAO.getById(id_midia);
			if(midia == null){
				exceptionNumber = 404;
				throw new Exception("No midia with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			midiaDAO.delete(midia);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Midia excluída com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
