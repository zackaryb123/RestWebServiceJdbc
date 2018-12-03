package com.zack.config;

import com.zack.model.Emp;
import com.zack.service.EmpService;
import com.zack.service.EmpServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/emp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpResource {

    private EmpService empService = new EmpServiceImpl();

    @GET
    public  List<Emp> getEmps(){
        return empService.getAllEmp();
    }

    @POST
    @Path("/add")
    public Emp postEmp(Emp emp) {
        return empService.addEmp(emp);
    }

    @GET
    @Path("/get/{id}")
    public Emp getEmpById(@PathParam("id") int id) {
        return empService.getEmpById(id);
    }

    @PUT
    @Path("/update/{id}")
    public Emp updateEmp(@PathParam("id") int id, Emp emp){
        return empService.updateEmp(id, emp);
    }

    @DELETE
    @Path("/delete/{id}")
    public int removeEmp(@PathParam ("id") int id ){
        return empService.deleteEmp(id);
    }
}
