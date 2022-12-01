package com.academia.placementhistory.Controller;

import com.academia.placementhistory.Bean.Alumni;
import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.DAO.DAOImpl.AlumniImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/alumni")
public class AlumniController {

    @Path("/details/{org}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getAlumniDetails(@PathParam("org") String org){
        Organisation o = new Organisation();
        o.setName(org);
        List<Object> list = new AlumniImpl().getAlumniDetails(o);
        return list;
    }
}
