package br.com.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.daos.AlternativaDAO;
import br.com.daos.SimpleEntityManager;

import br.com.pojos.Alternativa;

@Path("/alternativa")
public class AlternativaService {

		SimpleEntityManager sem = SimpleEntityManager.getInstance();
		private AlternativaDAO alternativaDAO = new AlternativaDAO(sem.getEntityManager());

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{idAlternativa}")
		public Alternativa consultar(@PathParam("idAlternativa") int id_alternativa){
			int exceptionNumber = 500;
			try{
				Alternativa alternativa = alternativaDAO.listAlternativaPorId(id_alternativa);
				if(alternativa == null){
					exceptionNumber = 404;
					throw new Exception("No client with this id");
				}
				return alternativa;
			} catch (Exception e){
				throw new WebApplicationException(exceptionNumber);
			}
		}
		
		@GET
		@Path("/pergunta/{idPergunta}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Alternativa> listarAlternativasPorIdPergunta(@PathParam("idPergunta")int idPergunta){
			int exceptionNumber = 500;
			try{
				List<Alternativa> alternativas = alternativaDAO.listarAlternativasPorIdPergunta(idPergunta);
				if (alternativas.isEmpty()) {
						exceptionNumber = 404;
						throw new Exception("No alternativas registred");
					}
				return alternativas;
			} catch (Exception e){
				throw new WebApplicationException(exceptionNumber);
			}
		}
		
//		@GET
//		@Produces(MediaType.APPLICATION_JSON)
//		public List<Alternativa> listar(){
//			int exceptionNumber = 500;
//			try{
//				List<Alternativa> alternativas = alternativaDAO.listAllAlternativas();
//				if (alternativas.isEmpty()) {
//						exceptionNumber = 404;
//						throw new Exception("No alternativas registred");
//					}
//				return alternativas;
//			} catch (Exception e){
//				throw new WebApplicationException(exceptionNumber);
//			}
//		}
		
	
		//N�O PRECISAREI
//		@POST
//		@Consumes(MediaType.APPLICATION_JSON)
//		public Response cadastrar(Alternativa alternativa){
//			try{
//				sem.getEntityManager().getTransaction().begin();
//				alternativaDAO.save(alternativa);
//				sem.getEntityManager().getTransaction().commit();
//				return Response.status(200).entity("Alternativa cadastrada com sucesso").build();
//			} catch (Exception e){
//				throw new WebApplicationException(500);
//			}
//		}
		
		//N�O PRECISAREI
//		@PUT
//		@Path("/{id}")
//		@Consumes(MediaType.APPLICATION_JSON)
//		public Response atualizar(@PathParam("id") int id, Alternativa alternativa){
//			int exceptionNumber = 500;
//			try{
//				Alternativa alternativaPer = alternativaDAO.listAlternativaPorId(id);
//				if(alternativaPer == null){
//					exceptionNumber = 404;
//					throw new Exception("No client with this id");
//				} else {
//					sem.getEntityManager().getTransaction().begin();
//					alternativa.setIdAlternativa(id);
//					alternativaDAO.save(alternativa);
//					sem.getEntityManager().getTransaction().commit();
//					return Response.status(200).entity("Cliente alterado com sucesso").build();
//				}
//			} catch (Exception e){
//				throw new WebApplicationException(exceptionNumber);
//			}
//		}
		
		@DELETE
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response deletar(@PathParam("id") int id_alternativa){
			int exceptionNumber = 500;
			try{
				Alternativa alternativa = alternativaDAO.listAlternativaPorId(id_alternativa);
				if(alternativa == null){
					exceptionNumber = 404;
					throw new Exception("No client with this id");
				}
				sem.getEntityManager().getTransaction().begin();
				alternativaDAO.delete(alternativa);
				sem.getEntityManager().getTransaction().commit();
				return Response.status(200).entity("Cliente exclu�do com sucesso").build();
			} catch (Exception e){
				throw new WebApplicationException(exceptionNumber);
			}
		}
	}

