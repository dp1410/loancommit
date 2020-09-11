package phonepe.ext;

import java.util.Properties;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;

import com.jarredweb.webjar.web.app.AbstractAppServer;

public class AppExtServer extends AbstractAppServer{

	public AppExtServer(ApplicationContext ctx, Properties startOptions) throws Exception {
		super(ctx, startOptions);
	}

	@Override
	public ResourceConfig getResourceConfig() {
		return new AppRestConfig(ctx);
	}
}
