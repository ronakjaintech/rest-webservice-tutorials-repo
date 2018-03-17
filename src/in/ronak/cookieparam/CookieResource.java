package  in.ronak.cookieparam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/cookies")
public class CookieResource {

    @GET
    @Path("/test")
    public Response getCookie(@CookieParam("name") Cookie cookie){
        return Response.ok(cookie.toString()).build();
    }

    @GET
    @Path("/value")
    public Response getCookieValue(@CookieParam("name") String cookie){
        return Response.ok(cookie.toString()).build();
    }

    @POST
    public Response createCookie(){
        return Response
                .ok()
                .cookie(new NewCookie("name", "value"))
                .build();
    }

    @PUT
    public Response updateCookie(@CookieParam("name") Cookie cookie){
        if (cookie != null){
            return Response
                    .ok()
                    .cookie(new NewCookie("name", "new-value"))
                    .build();
        }
        return Response.ok().build();
    }

    @DELETE
    public Response deleteCookie(@CookieParam("name") Cookie cookie){
        if (cookie != null){
            NewCookie newCookie = new NewCookie(cookie, "delete cookie", 0, false);
            return Response
                    .ok()
                    .cookie(newCookie)
                    .build();
        }
        return Response.ok().build();
    }

    @GET
    public Response list(@Context HttpHeaders headers){
        for (String name : headers.getCookies().keySet()) {
            Cookie cookie = headers.getCookies().get(name);
            System.out.println("Cookie: " + name + "=" + cookie.getValue());
        }
        return Response.ok().build();
    }

}
