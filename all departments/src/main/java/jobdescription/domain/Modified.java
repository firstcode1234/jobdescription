package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import jobdescription.domain.*;
import jobdescription.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Modified extends AbstractEvent {

    private Long id;

    public Modified(Jobdescription aggregate) {
        super(aggregate);
    }

    public Modified() {
        super();
    }
}
//>>> DDD / Domain Event
