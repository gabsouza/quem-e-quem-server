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

import br.com.daos.PerfilDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Perfil;

@Path("/perfil")
public class PerfilService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private PerfilDAO perfilDAO = new PerfilDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idPerfil}")
	public Perfil consultar(@PathParam("idPerfil") int id_perfil){
		int exceptionNumber = 500;
		try{
			Perfil perfil = perfilDAO.getById(id_perfil);
			if (perfil == null){
				exceptionNumber = 404;
				throw new Exception("Não há perfil com este id");
			}
			return perfil;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Perfil> listar(){
		int exceptionNumber = 500;
		try{
			List<Perfil> perfis = perfilDAO.listAllPerfis();
			if (perfis.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No perfis registred");
				}
			return perfis;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Perfil perfil){
		try{
			sem.getEntityManager().getTransaction().begin();
			perfil = perfilDAO.save(perfil);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity(perfil).build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idPerfil}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Perfil perfil){
		int exceptionNumber = 500;
		try{
			Perfil perfiljput = perfilDAO.getById(id);
			if(perfiljput == null){
				exceptionNumber = 404;
				throw new Exception("No perfil with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				perfil.setIdPerfil(id);
				perfilDAO.save(perfil);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Perfil alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idPerfil}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idPerfil") int id_perfil){
		int exceptionNumber = 500;
		try{
			Perfil perfil = perfilDAO.getById(id_perfil);
			if(perfil == null){
				exceptionNumber = 404;
				throw new Exception("No perfil with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			perfilDAO.delete(perfil);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Perifl excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
