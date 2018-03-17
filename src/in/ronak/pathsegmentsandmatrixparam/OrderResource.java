package in.ronak.pathsegmentsandmatrixparam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/matrixorders")
public class OrderResource {

    // GET /orders/4492;delivery=immediate

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(@Context UriInfo info){

        PathSegment model = info.getPathSegments().get(1);
        System.out.println("id: " + model.getPath());
        for (String name : model.getMatrixParameters().keySet()){
            String value = model.getMatrixParameters().getFirst(name);
            System.out.println("\tmatrix param name: " + name + " value: " + value);
        }

        return Response.ok().build();
    }

}
