package phonepe.ext;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.jtwig.JtwigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jarredweb.webjar.service.api.BasicsService;

import phonepe.ctx.AppServices;

@Path("/quick")
public class QuickResource {

	private static final Logger LOG = LoggerFactory.getLogger(QuickResource.class);
	
	@Inject
	private AppServices service;
	@Inject
	private BasicsService basics;
	
	public AppServices getService() {
		return service;
	}

	public void setService(AppServices service) {
		this.service = service;
	}

	public BasicsService getBasics() {
		return basics;
	}

	public void setBasics(BasicsService basics) {
		this.basics = basics;
	}

	@GET
	@Path("/twig")
	@Produces(MediaType.TEXT_PLAIN)
	@PermitAll
	public Response twigHelloView() {
		LOG.info("executing twig 'quick-resources'");
		JtwigModel context = JtwigModel.newModel().with("var", "Twig World!!");
		return Response.ok(new Viewable("/hello", context)).build();
	}
	
	@GET
	@Path("/ftl")
	@Produces(MediaType.TEXT_PLAIN)
	@PermitAll
	public Response ftlHelloView() {
		LOG.info("executing ftl 'quick-resources'");
		Map<String, Object> context = new HashMap<>();
		context.put("var", "Ftl World!!");
		return Response.ok(new Viewable("/hello", context)).build();
	}
	
	@GET
	@Path("/blogs")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response fetchAllBlogs() {
		LOG.info("executing 'fetchAllBlogs'");
		Map<String, Object> context = new HashMap<>();
		context.put("blogs", service.getBasicsService().get().fetchBlogs().get());
		return Response.ok(context).build();
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response fetchUserById(@PathParam("id") long id) {
		LOG.info("executing 'fetchUserById'");
		Map<String, Object> context = new HashMap<>();
		context.put("user", basics.findAccount(id).get());
		return Response.ok(context).build();
	}
}
