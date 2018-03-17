package in.ronak.httpheaders;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/headerproducts")
public class ProductResource {

    @GET
    public Response getProducts(@Context HttpServletRequest request){

        String userAgent = request.getHeader("user-agent");

        return Response
                .ok()
                .entity("getProducts() user-agent: " + userAgent)
                .build();
    }

}
