package com.aidar.title.fight.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.aidar.title.fight.api.Saying;
import com.google.common.base.Optional;

@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
public class TitleFightResource {

	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	
	public TitleFightResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
	
	@GET
	@Path("/test")
	@Timed
	public String sayHelloTest() {
		return "test";
	}
}

