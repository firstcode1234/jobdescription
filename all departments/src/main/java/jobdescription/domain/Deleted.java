package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import jobdescription.domain.*;
import jobdescription.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Deleted extends AbstractEvent {

    private Long id;

    public Deleted(Jobdescription aggregate) {
        super(aggregate);
    }

    public Deleted() {
        super();
    }
}
//>>> DDD / Domain Event
