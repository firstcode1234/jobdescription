package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import jobdescription.domain.*;
import jobdescription.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Staffed extends AbstractEvent {

    private Long id;

    public Staffed(Employee aggregate) {
        super(aggregate);
    }

    public Staffed() {
        super();
    }
}
//>>> DDD / Domain Event
