package in.ronak.queryparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/orders")
public class OrderResource {

    // http://localhost:8081/jaxrs-query-param/api/orders?offset=10&size=10&orderBy=name&orderBy=price

    @GET
    public Response getOrders(@Context UriInfo info){

        String offset = info.getQueryParameters().getFirst("offset");
        String size = info.getQueryParameters().getFirst("size");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        for (String name : info.getQueryParameters().keySet()){
            System.out.println("query param name: " + name + " value: " + info.getQueryParameters().getFirst(name));
        }

        return Response
                .ok()
                .entity("orders with offset: " + offset +
                        ", size: " + size +
                        ", orderBy: " + orderBy)
                .build();
    }

}
