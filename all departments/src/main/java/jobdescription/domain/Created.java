package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import jobdescription.domain.*;
import jobdescription.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Created extends AbstractEvent {

    private Long id;

    public Created(Jobdescription aggregate) {
        super(aggregate);
    }

    public Created() {
        super();
    }
}
//>>> DDD / Domain Event
