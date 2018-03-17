package in.ronak.pathsegmentsandmatrixparam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/matrixproducts")
public class ProductResource {

    // GET /products/4492;delivery=immediate/active;delivery=delayed
    @GET
    @Path("{id}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@PathParam("id") String id,
                                @MatrixParam("delivery") String delivery,
                                @PathParam("status") String status){

        System.out.println("id: " + id);
        System.out.println("delivery: " + delivery);
        System.out.println("status: " + status);

        return Response.ok().build();
    }

}
