package br.com.ws.rest;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.pojos.Alternativa;
import br.com.pojos.Dica;
import br.com.pojos.Pergunta;
import br.com.pojos.Responsavel;
import br.com.pojos.Resposta;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(HelloWorld.class);
		resources.add(TransporteService.class);
		resources.add(ClienteService.class);
		resources.add(AlternativaService.class);
		resources.add(Dica.class);
		resources.add(MidiaService.class);
		resources.add(MiniJogoService.class);
		resources.add(PerfilService.class);
		resources.add(PerguntaService.class);
		resources.add(RelatorioService.class);
		resources.add(ResponsavelService.class);
		resources.add(Resposta.class);
		resources.add(SeloService.class);
		resources.add(UsuarioMiniJogoService.class);
		

	}

}
