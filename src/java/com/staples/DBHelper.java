package com.staples;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DonSa001
 */
public class DBHelper {

    private Mongo m;
    private DB db;
    private DBCollection jobs;

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public Mongo getM() {
        return m;
    }

    public void setM(Mongo m) {
        this.m = m;
    }

    public DBCollection getJobs() {
        return jobs;
    }

    public void setJobs(DBCollection jobs) {
        this.jobs = jobs;
    }    
        
    public DBHelper() {
        if (m == null || db == null || jobs==null) {
            try {
                m = new Mongo("localhost");
                db = m.getDB("taleo");
                jobs = db.getCollection("JobPostings");                
            } catch (UnknownHostException ex) {
                Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MongoException ex) {
                Logger.getLogger(JobsService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Job createJobFromIterator(DBObject object){
            Job job = new Job();
            job.setJobNumber(object.get(Keys.JOBNUMBER).toString());
            job.setManagerFirst(object.get(Keys.MANAGERFIRST).toString());
            job.setManagerLast(object.get(Keys.MANAGERLAST).toString());
            job.setRecruiterFirst(object.get(Keys.RECRUITERFIRST).toString());
            job.setRecruiterLast(object.get(Keys.RECRUITERLAST).toString());
            job.setContactEmail(object.get(Keys.INTERNALCONTACTEMAIL).toString());
            job.setPostingDate(object.get(Keys.POSTINGDATE).toString());
            job.setEmpStatus(object.get(Keys.EMPLOYEESTATUS).toString());
            job.setBonusAvail(object.get(Keys.BONUSAVAILABLE).toString());
            job.setBonusAmt(object.get(Keys.BONUSAMOUNT).toString());
            job.setJobLevel(object.get(Keys.JOBLEVEL).toString());
            job.setJobSchedule(object.get(Keys.JOBSCHEDULE).toString());
            job.setJobShift(object.get(Keys.JOBSHIFT).toString());
            job.setJobType(object.get(Keys.JOBTYPE).toString());
            job.setOverTime(object.get(Keys.OVERTIME).toString());
            job.setWillTravel(object.get(Keys.WILLTRAVEL).toString());
            job.setJobField(object.get(Keys.JOBFIELD).toString());
            job.setJobFieldSub(object.get(Keys.JOBFIELDSUB).toString());
            job.setOrganization(object.get(Keys.ORGANIZATION).toString());
            job.setLevel1(object.get(Keys.JOBLEVEL1).toString());
            job.setLevel2(object.get(Keys.JOBLEVEL2).toString());
            job.setLevel3(object.get(Keys.JOBLEVEL3).toString());
            job.setLevel4(object.get(Keys.JOBLEVEL4).toString());
            job.setLevel5(object.get(Keys.JOBLEVEL5).toString());
            job.setLevel5Zip(object.get(Keys.JOBLEVEL5ZIP).toString());
            job.setOtherLevel1(object.get(Keys.OTHERLEVEL1).toString());
            job.setOtherLevel2(object.get(Keys.OTHERLEVEL2).toString());
            job.setOtherLevel3(object.get(Keys.OTHERLEVEL3).toString());
            job.setOtherLevel4(object.get(Keys.OTHERLEVEL4).toString());
            job.setOtherLevel5(object.get(Keys.OTHERLEVEL5).toString());
            job.setOtherLevel5Zip(object.get(Keys.OTHERLEVEL5ZIP).toString());
            job.setTitleEng(object.get(Keys.TITLEENG).toString());
            job.setTitleFr(object.get(Keys.TITLEFR).toString());
            job.setDescEng(object.get(Keys.DESCENG).toString());
            job.setDescFr(object.get(Keys.DESCFR).toString());
            job.setQualificationEng(object.get(Keys.QUALIFICATIONENG).toString());
            job.setQualificationFr(object.get(Keys.QUALIFICATIONFR).toString());
            job.setApplyUrl(object.get(Keys.APPLYURL).toString());
            job.setReferralUrl(object.get(Keys.REFERRALURL).toString());
            return job;
    }    
    
    public static JobsList getJsonJobsData(DBCursor jobCursor){
        ArrayList jobsList = new ArrayList();
        while (jobCursor != null && jobCursor.hasNext()) {
            jobsList.add(DBHelper.createJobFromIterator(jobCursor.next()));
        }
        JobsList list = new JobsList();
        list.setJobList(jobsList);
        return list;
    }
    
    public void closeDB(){
        m.close();
    }
}
