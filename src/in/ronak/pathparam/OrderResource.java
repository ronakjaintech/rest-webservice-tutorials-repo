package in.ronak.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/pathorders")
public class OrderResource {

    // http://localhost:8081/jaxrs-path-param/api/orders/01-01-2015
    // getOrder with day: 1, month: 1, year: 2015

    @GET
    @Path("{day}-{month}-{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("day") Integer day,
                             @PathParam("month") Integer month,
                             @PathParam("year") Integer year){

        return Response
                .ok()
                .entity("getOrder with day: " + day +
                        ", month: " + month +
                        ", year: " + year)
                .build();
    }

}
