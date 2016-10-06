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

import br.com.daos.RelatorioDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Relatorio;

public class RelatorioService {

	SimpleEntityManager sem = SimpleEntityManager.getInstance();
	private RelatorioDAO relatorioDAO = new RelatorioDAO(sem.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idRelatorio}")
	public Relatorio consultar(@PathParam("idRelatorio") int id_relatorio){
		int exceptionNumber = 500;
		try{
			Relatorio relatorio = relatorioDAO.getById(id_relatorio);
			if (relatorio == null){
				exceptionNumber = 404;
				throw new Exception("No relatorio with this id");
			}
			return relatorio;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Relatorio> listar(){
		int exceptionNumber = 500;
		try{
			List<Relatorio> relatorios = relatorioDAO.listAllRelatorios();
			if (relatorios.isEmpty()) {
					exceptionNumber = 404;
					throw new Exception("No miniJogos registred");
				}
			return relatorios;
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Relatorio relatorio){
		try{
			sem.getEntityManager().getTransaction().begin();
			relatorioDAO.save(relatorio);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Relatorio cadastrado com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{idRelatorio}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int id, Relatorio relatorio){
		int exceptionNumber = 500;
		try{
			Relatorio relatorioput = relatorioDAO.getById(id);
			if(relatorioput  == null){
				exceptionNumber = 404;
				throw new Exception("No relatorio with this id");
			} else {
				sem.getEntityManager().getTransaction().begin();
				relatorio.setIdRelatorio(id);
				relatorioDAO.save(relatorio);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Relatorio alterado com sucesso").build();
			}
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
	
	@DELETE
	@Path("/{idRelatorio}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("idRelatorio") int id_relatorio){
		int exceptionNumber = 500;
		try{
			Relatorio relatorio = relatorioDAO.getById(id_relatorio);
			if(relatorio == null){
				exceptionNumber = 404;
				throw new Exception("No relatorio with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			relatorioDAO.delete(relatorio);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Relatorio excluído com sucesso").build();
		} catch (Exception e){
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
