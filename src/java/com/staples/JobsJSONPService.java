package com.staples;

import com.sun.jersey.api.json.JSONWithPadding;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author DonSa001
 */
@Path("/jobs/jsonp")
public class JobsJSONPService {
    
    @GET
    @Produces("application/x-javascript")
    public JSONWithPadding getAllJobs(@QueryParam("callback") String callback) {
        return new JSONWithPadding(ServiceHelper.getAllJobs(), callback);
    }                
    
    @Path("/{jobNumber}")
    @GET
    @Produces("application/x-javascript")    
    public JSONWithPadding getJobsByNumber(@PathParam("jobNumber") String jobNumber, @QueryParam("callback") String callback) throws Exception{        
        return new JSONWithPadding(ServiceHelper.getJobByNumber(jobNumber), callback);        
        //URL to call: http://localhost:8084/StaplesCareers/resources/jobs/jsonp/835237?callback=callback
    }    
}
