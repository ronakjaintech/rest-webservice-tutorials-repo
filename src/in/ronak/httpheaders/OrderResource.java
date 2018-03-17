package in.ronak.httpheaders;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/headerorders")
public class OrderResource {

    @GET
    public Response getOrders(@HeaderParam("user-agent") String userAgent){

        return Response
                .ok()
                .entity("getOrders() user-agent: " + userAgent)
                .build();
    }

}
