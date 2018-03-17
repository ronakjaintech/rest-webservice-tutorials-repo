package in.ronak.chunkedoutput;

import org.glassfish.jersey.server.ChunkedOutput;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/chunkednumbers")
public class NumbersResource {

    @GET
    public Response sendChunkedOutput(){
        final ChunkedOutput<String> output = new ChunkedOutput<String>(String.class);

        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000 ; i++){
                        output.write(i + " ");
                    }
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try {
                        output.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return Response.ok().entity(output).build();
    }

}
