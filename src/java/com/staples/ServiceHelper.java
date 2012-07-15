/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staples;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author DonSa001
 */
public class ServiceHelper {
    public static JobsList getAllJobs(){
        DBHelper dbHelper = new DBHelper();        
        DBCursor jobCursor = dbHelper.getJobs().find();
        JobsList list = DBHelper.getJsonJobsData(jobCursor);
        dbHelper.closeDB();
        return list;
    }
    
    public static JobsList getJobByNumber(String jobNumber){
        DBHelper dbHelper = new DBHelper();        
        BasicDBObject query = new BasicDBObject();
        query.put(Keys.JOBNUMBER, jobNumber);
        DBCursor jobCursor = dbHelper.getJobs().find(query);
        JobsList list = DBHelper.getJsonJobsData(jobCursor);
        dbHelper.closeDB();
        return list;        
    }
}
