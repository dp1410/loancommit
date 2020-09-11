package phonepe.ext;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.springframework.context.ApplicationContext;

import com.jarredweb.webjar.web.config.WebjarRestConfig;

import phonepe.ctx.AppServices;

public class AppRestConfig extends WebjarRestConfig {

	public AppRestConfig(final ApplicationContext ctx){
		super();
		packages("phonepe.ext");
		property("jersey.config.server.mvc.templateBasePath.freemarker", "templates/freemarker/");
		property("jersey.config.server.mvc.caching.freemarker", false);
		register(FreemarkerMvcFeature.class);
		register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				AppServices services = ctx.getBean(AppServices.class);
				bind( services ).to( AppServices.class );
			}
		});
	}
}
