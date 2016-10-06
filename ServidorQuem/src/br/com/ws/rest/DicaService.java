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

import br.com.daos.DicaDAO;
import br.com.daos.SimpleEntityManager;
import br.com.pojos.Dica;

	@Path("/dica")
	public class DicaService {

			SimpleEntityManager sem = SimpleEntityManager.getInstance();
			private DicaDAO dicaDAO = new DicaDAO(sem.getEntityManager());

			@GET
			@Produces(MediaType.APPLICATION_JSON)
			@Path("/{idDica}")
			public Dica consultar(@PathParam("idDica") int id_dica){
				int exceptionNumber = 500;
				try{
					Dica dica = dicaDAO.getById(id_dica);
					if (dica == null){
						exceptionNumber = 404;
						throw new Exception("No client with this id");
					}
					return dica;
				} catch (Exception e){
					throw new WebApplicationException(exceptionNumber);
				}
			}
			
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Dica> listar(){
				int exceptionNumber = 500;
				try{
					List<Dica> dicas = dicaDAO.listAllDicas();
					if (dicas.isEmpty()) {
							exceptionNumber = 404;
							throw new Exception("No alternativas registred");
						}
					return dicas;
				} catch (Exception e){
					throw new WebApplicationException(exceptionNumber);
				}
			}
			
			
			
			@POST
			@Consumes(MediaType.APPLICATION_JSON)
			public Response cadastrar(Dica dica){
				try{
					sem.getEntityManager().getTransaction().begin();
					dicaDAO.save(dica);
					sem.getEntityManager().getTransaction().commit();
					return Response.status(200).entity("Dica cadastrada com sucesso").build();
				} catch (Exception e){
					throw new WebApplicationException(500);
				}
			}
			
			@PUT
			@Path("/{idDica}")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response atualizar(@PathParam("id") int id, Dica dica){
				int exceptionNumber = 500;
				try{
					Dica dicaput = dicaDAO.getById(id);
					if(dicaput == null){
						exceptionNumber = 404;
						throw new Exception("No client with this id");
					} else {
						sem.getEntityManager().getTransaction().begin();
						dica.setIdDica(id);
						dicaDAO.save(dica);
						sem.getEntityManager().getTransaction().commit();
						return Response.status(200).entity("Dica alterada com sucesso").build();
					}
				} catch (Exception e){
					throw new WebApplicationException(exceptionNumber);
				}
			}
			
			@DELETE
			@Path("/{idDica}")
			@Consumes(MediaType.APPLICATION_JSON)
			public Response deletar(@PathParam("idDica") int id_alternativa){
				int exceptionNumber = 500;
				try{
					Dica dica = dicaDAO.getById(id_alternativa);
					if(dica == null){
						exceptionNumber = 404;
						throw new Exception("No client with this id");
					}
					sem.getEntityManager().getTransaction().begin();
					dicaDAO.delete(dica);
					sem.getEntityManager().getTransaction().commit();
					return Response.status(200).entity("Dica excluída com sucesso").build();
				} catch (Exception e){
					throw new WebApplicationException(exceptionNumber);
				}
			}
}
