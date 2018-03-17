package in.ronak.chunkedoutput;

import org.glassfish.jersey.client.ChunkedInput;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class RunClient {

    public static void main(String... args){
        Client client = ClientBuilder.newClient();

        Response response = client
                .target("http://localhost:8081/jaxrs-chuncked/api")
                .path("numbers")
                .request()
                .get();


        final ChunkedInput<String> input = response.readEntity(new GenericType<ChunkedInput<String>>() {});
        String chunk;
        while ((chunk = input.read()) != null){
            System.out.println("chunk: " + chunk);
        }
    }

}
