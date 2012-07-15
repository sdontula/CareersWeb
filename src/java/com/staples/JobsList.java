/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staples;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="JobsList")
public class JobsList {       
    private List<Job> jobsList;
    
    public JobsList(){
        this.jobsList = new ArrayList<Job>();
    }

    @XmlElement(name="Job")
    public List<Job> getJobList() {
        return jobsList;
    }

    public void setJobList(List<Job> jobsList) {
        this.jobsList = jobsList;
    }        
}
