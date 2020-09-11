package phonepe.ext;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jarredweb.webjar.web.config.WebjarRunner;

public class AppRunner extends WebjarRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

	public static void main(String[] args) {
		AppRunner runner = new AppRunner();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) runner.initApplicationContext();
		Properties startOptions = runner.getStartupOptions(args, ctx);
		runner.initStartupService(ctx).startServer(startOptions, ctx);
		LOGGER.info("AppServer started");
	}

	@Override
	public ApplicationContext initApplicationContext() {
		AnnotationConfigApplicationContext ctx = AppCtxConfig.getAnnotationConfigApplicationContext();
		LOGGER.info("app context in webjar-starter created");
		return ctx;
	}
}
