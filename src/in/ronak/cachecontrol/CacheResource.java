package in.ronak.cachecontrol;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/*\
 *Cache-Control tokens and their meaning:

private only clients (mostly the browser) and no one else in the chain (like a proxy) should cache this
public any entity in the chain can cache this
no-cache should not be cached anyway
no-store can be cached but should not be stored on disk (most browsers will hold the resources in memory until they will be quit)
no-transform the resource should not be modified (for example shrink image by proxy)
max-age how long the resource is valid (measured in seconds)
s-maxage same like max-age but this value is just for non client
 */
@Path("cache")
public class CacheResource {
	@Path("/book/{id}")
	@GET
	public Response getBook(@PathParam("id") long id){

	    Book myBook = Book.getBookFromDB(id);

	    CacheControl cc = new CacheControl();
	    cc.setMaxAge(86400);
	    cc.setPrivate(true);

	    ResponseBuilder builder = Response.ok("done");
	    builder.cacheControl(cc);
	    return builder.build();
	}

	@Path("/book/test2Bo/{id}")
	@GET
	public Response getBook(@PathParam("id") long id, @Context Request request){

	    Book myBook = Book.getBookFromDB(id);
	    CacheControl cc = new CacheControl();
	    cc.setMaxAge(86400);

	    EntityTag etag = new EntityTag(Integer.toString(myBook.hashCode()));
	    ResponseBuilder builder = request.evaluatePreconditions(etag);

	    // cached resource did change -> serve updated content
	    if(builder == null){
	        builder = Response.ok(myBook);
	        builder.tag(etag);
	    }

	    builder.cacheControl(cc);
	    return builder.build();
	}
	
}
