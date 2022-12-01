package com.academia.placementhistory.Controller;

import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.Bean.PlacementStudent;
import com.academia.placementhistory.Bean.Student;
import com.academia.placementhistory.DAO.DAOImpl.OrganisationImpl;
import com.academia.placementhistory.DAO.DAOImpl.PlacementStudentImpl;
import com.academia.placementhistory.DAO.DAOImpl.StudentImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/placement")
public class PlacementController {
    @Path("/getStudents")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Student>> getStudentList(){
        List<List<Student>> lists = new StudentImpl().listStudents();
        Map<String, List<Student>> map = new HashMap<>();
        map.put("placed", lists.get(0));
        map.put("unplaced", lists.get(1));
        return map;
    }

    @Path("/getByOrg/{org_name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getStudentByOrganisation(@PathParam("org_name") String name){
        Organisation org = new Organisation();
        org.setName(name);
        List<Object> list = new StudentImpl().getStudentByOrganisation(org);
        return list;
    }

    @Path("/getByDate/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getStudentByDate(@PathParam("year") String year){
        PlacementStudent ps = new PlacementStudent();
        ps.setDate(year);
        List<Object> list = new StudentImpl().getStudentByDate(ps);
        return list;
    }
    @Path("/getByDomain/{domain}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getStudentByDomain(@PathParam("domain") String domain){
        Student st = new Student();
        st.setDomain(domain);
        List<Object> list = new StudentImpl().getStudentByDomain(st);
        return list;
    }

    @GET
    @Path("/getDomain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomain() {
        List<String> domains = new StudentImpl().getDomain();
        return Response.ok().entity(domains).build();
    }

    @GET
    @Path("/getOrg")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisation() {
        List<String> organisations = new OrganisationImpl().getOrganisation();
        return Response.ok().entity(organisations).build();
    }

    @GET
    @Path("/getYear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYear() {
        List<String> organisations = new PlacementStudentImpl().getYear();
        return Response.ok().entity(organisations).build();
    }
}
