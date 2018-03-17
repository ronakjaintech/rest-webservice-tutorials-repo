package in.ronak.httpheaders;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/headerusers")
public class UserResource {

    @GET
    public Response getUser(@Context HttpHeaders headers){

        String userAgent = headers.getRequestHeader("user-agent").get(0);

        return Response
                .ok()
                .entity("getUser() user-agent: " + userAgent)
                .build();
    }

}
