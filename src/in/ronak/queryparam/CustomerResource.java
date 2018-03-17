package in.ronak.queryparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/querycustomers")
public class CustomerResource {

    // http://localhost:8081/jaxrs-query-param/api/customers?offset=100&size=10&orderBy=firstName,lastName

    @GET
    public Response getCustomers(@QueryParam("offset") Integer offset,
                                 @QueryParam("size") Integer size,
                                 @QueryParam("orderBy") List<String> orderBy){

        return Response
                .ok()
                .entity("customers with offset: " + offset +
                        ", size: " + size +
                        ", orderBy: " + orderBy)
                .build();
    }

}
