package jobdescription.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import jobdescription.InnovationStrategyDepartmentApplication;
import jobdescription.domain.Confirmed;
import lombok.Data;

@Entity
@Table(name = "Organization_table")
@Data
//<<< DDD / Aggregate Root
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer jobId;

    private Integer number;

    @PostPersist
    public void onPostPersist() {
        Confirmed confirmed = new Confirmed(this);
        confirmed.publishAfterCommit();
    }

    public static OrganizationRepository repository() {
        OrganizationRepository organizationRepository = InnovationStrategyDepartmentApplication.applicationContext.getBean(
            OrganizationRepository.class
        );
        return organizationRepository;
    }

    public void check() {
        //implement business logic here:

    }
}
//>>> DDD / Aggregate Root
