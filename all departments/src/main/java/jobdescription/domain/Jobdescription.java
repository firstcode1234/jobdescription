package jobdescription.domain;

import jobdescription.AllDepartmentsApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Jobdescription_table")
@Data

//<<< DDD / Aggregate Root
public class Jobdescription  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String jobname;
    
    
    
    
    private String jobDescription;
    
    
    
    
    private String qualifications;
    
    
    
    
    private String education;
    
    
    
    
    private String completionEducation;

    @PostPersist
    public void onPostPersist(){
    
    }

    public static JobdescriptionRepository repository(){
        JobdescriptionRepository jobdescriptionRepository = AllDepartmentsApplication.applicationContext.getBean(JobdescriptionRepository.class);
        return jobdescriptionRepository;
    }



//<<< Clean Arch / Port Method
    public void enter(EnterCommand enterCommand){
        
        //implement business logic here:
        
        Created created = new Created(this);
        created.publishAfterCommit();


    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void modify(ModifyCommand modifyCommand){
        
        //implement business logic here:
        
        Modified modified = new Modified(this);
        modified.publishAfterCommit();


        jobdescription.external.JobdescriptionQuery jobdescriptionQuery = new jobdescription.external.JobdescriptionQuery();
        JobdescriptionApplication.applicationContext
            .getBean(jobdescription.external.Service.class)
            .( jobdescriptionQuery);
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void delete(DeleteCommand deleteCommand){
        
        //implement business logic here:
        
        Deleted deleted = new Deleted(this);
        deleted.publishAfterCommit();


        jobdescription.external.JobdescriptionQuery jobdescriptionQuery = new jobdescription.external.JobdescriptionQuery();
        JobdescriptionApplication.applicationContext
            .getBean(jobdescription.external.Service.class)
            .( jobdescriptionQuery);
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
