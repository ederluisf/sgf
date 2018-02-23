package br.com.sgf.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.sgf.api.entities.Manufacturer;
import br.com.sgf.api.entities.Vehicle;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Manufacturer.class, Vehicle.class);
    }
}
