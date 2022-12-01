package com.academia.placementhistory.Controller;

import com.academia.placementhistory.Bean.Employee;
import com.academia.placementhistory.DAO.DAOImpl.EmployeeImpl;
import com.academia.placementhistory.DAO.EmployeeDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/employee")
public class EmployeeController {

    EmployeeDAO employeeDAO = new EmployeeImpl();

    @Path("/login")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginEmployee(Employee e) {
        if(employeeDAO.verifyEmail(e)){
            return Response.ok().build();

        }
        else return Response.status(203).build();
    }

    @GET
    @Path("/options")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptions() {
        List<String> options = new ArrayList<>();
        options.add("Placed");
        options.add("Not Placed");
        options.add("Organisation");
        options.add("Year");
        options.add("Domain");
        options.add("Specialisation");
        return Response.ok().entity(options).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartments() {
        List<String> departments = new ArrayList<>();
        departments.add("IT");
        departments.add("Management");
        departments.add("Admission");
        departments.add("outreach");
        departments.add("Library");
        return Response.ok().entity(departments).build();
    }

}
