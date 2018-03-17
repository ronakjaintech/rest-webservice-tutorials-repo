package in.ronak.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pathcars")
public class CarResource {

    // http://localhost:8081/jaxrs-path-param/api/cars/bmw/x1/2016
    // getCar with brand: bmw, model: x1, year: 2016

    @GET
    @Path("{brand}/{model}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCar(@PathParam("brand") String brand,
                           @PathParam("model") String model,
                           @PathParam("year") Integer year){

        return Response
                .ok()
                .entity("getCar with brand: " + brand +
                        ", model: " + model +
                        ", year: " + year)
                .build();
    }

}
