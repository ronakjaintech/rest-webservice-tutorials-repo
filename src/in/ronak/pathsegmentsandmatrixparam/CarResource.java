package in.ronak.pathsegmentsandmatrixparam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/matrixcars")
public class CarResource {

    // GET /cars/BMW/3;color=black

    @GET
    @Path("{brand}/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars(@PathParam("brand") String brand,
                            @PathParam("model") PathSegment car){

        String model = car.getPath();
        String color = car.getMatrixParameters().getFirst("color");

        System.out.println("brand: " + brand);
        System.out.println("model: " + model);
        System.out.println("color: " + color);

        return Response.ok().build();
    }

    // GET /cars/BMW/E92;color=black/M3;maker=john/2015

    @GET
    @Path("{brand}/{model: .+}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars(@PathParam("brand") String brand,
                            @PathParam("model") List<PathSegment> cars,
                            @PathParam("year") Integer year){

        System.out.println("brand: " + brand);
        for (PathSegment segment : cars){
            System.out.println("model: " + segment.getPath());
            for (String name : segment.getMatrixParameters().keySet()){
                String value = segment.getMatrixParameters().getFirst(name);
                System.out.println("\tmatrix param name: " + name + " value: " + value);
            }
        }
        System.out.println("year: " + year);

        return Response.ok().build();
    }

}
