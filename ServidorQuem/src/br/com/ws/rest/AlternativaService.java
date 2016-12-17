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
	public Alternativa consultar(@PathParam("idAlternativa") int id_alternativa) {
		int exceptionNumber = 500;
		try {
			Alternativa alternativa = alternativaDAO.listAlternativaPorId(id_alternativa);
			if (alternativa == null) {
				exceptionNumber = 404;
				throw new Exception("No client with this id");
			}
			return alternativa;
		} catch (Exception e) {
			throw new WebApplicationException(exceptionNumber);
		}
	}

	@GET
	@Path("/pergunta/{idPergunta}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alternativa> listarAlternativasPorIdPergunta(@PathParam("idPergunta") int idPergunta) {
		int exceptionNumber = 500;
		try {
			List<Alternativa> alternativas = alternativaDAO.listarAlternativasPorIdPergunta(idPergunta);
			if (alternativas.isEmpty()) {
				exceptionNumber = 404;
				throw new Exception("No alternativas registred");
			}
			return alternativas;
		} catch (Exception e) {
			throw new WebApplicationException(exceptionNumber);
		}
	}

//	@GET
//	@Path("/{idAlternativa1}/{idAlternativa2}/{numeroDeAlternativas}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Alternativa> buscarAlternativasIncorretas(@PathParam("idAlternativa1") int idAlternativa1,
//			@PathParam("idAlternativa2") int idAlternativa2,
//			@PathParam("numeroDeAlternativas") int numeroDeAlternativas) {
//		int exceptionNumber = 500;
//		try {
//			List<Alternativa> alternativas = alternativaDAO.buscarAlternativasIncorretas(idAlternativa1, idAlternativa2,
//					numeroDeAlternativas);
//			if (alternativas.isEmpty()) {
//				exceptionNumber = 404;
//				throw new Exception("No alternativas registred");
//			}
//			return alternativas;
//		} catch (Exception e) {
//			throw new WebApplicationException(exceptionNumber);
//		}
//	}

	 @GET
	 @Path("/{idAlternativa1}/{idAlternativa2}/{numeroDeAlternativas}/{generoPersonagem}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Alternativa> buscarAlternativasIncorretas(@PathParam("idAlternativa1") int
	 idAlternativa1, @PathParam("idAlternativa2") int idAlternativa2,
	 @PathParam("numeroDeAlternativas") int numeroDeAlternativas, 
	 @PathParam("generoPersonagem") String generoPersonagem) {
	 int exceptionNumber = 500;
	 	try {
	 		List<Alternativa> alternativas = alternativaDAO.buscarAlternativasIncorretas(idAlternativa1,
	 				idAlternativa2, numeroDeAlternativas, generoPersonagem);
	 			if (alternativas.isEmpty()) {
	 				exceptionNumber = 404;
	 				throw new Exception("No alternativas registred");
	 			}
	 			return alternativas;
	 			
	 	} catch (Exception e) {
	 		throw new WebApplicationException(exceptionNumber);
	 	}
	 }
	
//	 public List<Alternativa>
//	 buscarAlternativasIncorretasFemininas(@PathParam("idAlternativa1") int
//	 idAlternativa1, @PathParam("idAlternativa2") int idAlternativa2,
//	 @PathParam("generoPersonagem") Enum generoPersonagem,
//	 @PathParam("numeroDeAlternativas") int numeroDeAlternativas) {
//	 int exceptionNumber = 500;
//	 try {
//	 List<Alternativa> alternativas =
//	 alternativaDAO.buscarAlternativasIncorretasFemininas(idAlternativa1,
//	 idAlternativa2, generoPersonagem, numeroDeAlternativas);
//	 if (alternativas.isEmpty()) {
//	 exceptionNumber = 404;
//	 throw new Exception("No alternativas registred");
//	 }
//	 return alternativas;
//	 } catch (Exception e) {
//	 throw new WebApplicationException(exceptionNumber);
//	 }
//	 }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alternativa> listar() {
		int exceptionNumber = 500;
		try {
			List<Alternativa> alternativas = alternativaDAO.listAllAlternativas();
			if (alternativas.isEmpty()) {
				exceptionNumber = 404;
				throw new Exception("No alternativas registred");
			}
			return alternativas;
		} catch (Exception e) {
			throw new WebApplicationException(exceptionNumber);
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") int id_alternativa) {
		int exceptionNumber = 500;
		try {
			Alternativa alternativa = alternativaDAO.listAlternativaPorId(id_alternativa);
			if (alternativa == null) {
				exceptionNumber = 404;
				throw new Exception("No client with this id");
			}
			sem.getEntityManager().getTransaction().begin();
			alternativaDAO.delete(alternativa);
			sem.getEntityManager().getTransaction().commit();
			return Response.status(200).entity("Cliente excluído com sucesso").build();
		} catch (Exception e) {
			throw new WebApplicationException(exceptionNumber);
		}
	}
}
