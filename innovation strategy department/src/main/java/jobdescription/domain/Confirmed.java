package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import jobdescription.domain.*;
import jobdescription.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Confirmed extends AbstractEvent {

    private Long id;

    public Confirmed(Organization aggregate) {
        super(aggregate);
    }

    public Confirmed() {
        super();
    }
}
//>>> DDD / Domain Event
