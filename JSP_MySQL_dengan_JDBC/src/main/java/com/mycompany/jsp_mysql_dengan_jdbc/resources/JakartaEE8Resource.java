package com.mycompany.jsp_mysql_dengan_jdbc.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * REST resource sederhana untuk testing koneksi REST.
 */
@Path("rest")
public class JakartaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
