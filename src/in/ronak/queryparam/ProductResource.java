package in.ronak.queryparam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductResource {

    // http://localhost:8081/jaxrs-query-param/api/products

    @GET
    public Response getProducts(@DefaultValue("0") @QueryParam("offset") Integer offset,
                                @DefaultValue("10") @QueryParam("size") Integer size,
                                @DefaultValue("firstName, lastName") @QueryParam("orderBy") List<String> orderBy){

        return Response
                .ok()
                .entity("products with offset: " + offset +
                        ", size: " + size +
                        ", orderBy: " + orderBy)
                .build();
    }

}
