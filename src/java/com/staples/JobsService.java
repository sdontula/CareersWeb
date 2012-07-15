package com.staples;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Author donsa001
 */
@Path("/jobs")
public class JobsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JobsList getAllJobs() {
        return ServiceHelper.getAllJobs();
    }        
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{jobNumber}")
    public JobsList getJobsByNumber(@PathParam("jobNumber") String jobNumber) throws Exception{
        return ServiceHelper.getJobByNumber(jobNumber);
    }    
}