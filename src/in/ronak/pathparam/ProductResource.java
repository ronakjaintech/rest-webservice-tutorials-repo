package in.ronak.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/pathproducts")
public class ProductResource {

    // http://localhost:8081/jaxrs-path-param/api/products/1
    // getProduct with id: 1

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@Context UriInfo uriInfo){

        String id = uriInfo.getPathParameters().getFirst("id");

        for (String name : uriInfo.getPathParameters().keySet()){
            System.out.println("path param name: " + name + " with value: " + uriInfo.getPathParameters().getFirst(name));
        }

        return Response
                .ok()
                .entity("getProduct with id: " + id)
                .build();
    }

}
