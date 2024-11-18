package com.example.nosuchmethodexception.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;

/**
 * The OperatorResource.
 */
@Log
@Path("/operator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperatorResource {

  @POST
  public Uni<Response> postOperator(Operator operator) {
    return Uni.createFrom().item(Response.status(Response.Status.OK)
        .entity("Hello " + operator.getName()).build());
  }

  @GET
  public Uni<Response> getOperator() {
    final Operator operator = new Operator();
    operator.setName("Can you give me number nine?");
    return Uni.createFrom().item(Response.status(Response.Status.OK)
        .entity(operator).build());
  }
}
