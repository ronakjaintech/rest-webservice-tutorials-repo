package in.ronak.jsonpojopost;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("jsonpost")
public class CarResource {

    // http://localhost:8081/jaxrs-path-param/api/cars/bmw/x1/2016
    // getCar with brand: bmw, model: x1, year: 2016

    @POST
    @Path("test")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCar(Car car){
        return Response
                .ok()
                .entity(car.getColour() +" "+ car.getModel())
                .build();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
