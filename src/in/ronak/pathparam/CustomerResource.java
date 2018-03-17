package in.ronak.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pathcustomers")
public class CustomerResource {

    // http://localhost:8081/jaxrs-path-param/api/customers/1
    // customer with id: 1

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id){
        return Response
                .ok()
                .entity("customer with id: " + id)
                .build();
    }


}
