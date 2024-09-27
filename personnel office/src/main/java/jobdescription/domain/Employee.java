package jobdescription.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import jobdescription.PersonnelOfficeApplication;
import jobdescription.domain.Staffed;
import lombok.Data;

@Entity
@Table(name = "Employee_table")
@Data
//<<< DDD / Aggregate Root
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employeenumber;

    private Integer jobId;

    @PostPersist
    public void onPostPersist() {
        Staffed staffed = new Staffed(this);
        staffed.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = PersonnelOfficeApplication.applicationContext.getBean(
            EmployeeRepository.class
        );
        return employeeRepository;
    }

    public void staff() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
