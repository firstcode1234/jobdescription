package jobdescription.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import jobdescription.config.kafka.KafkaProcessor;
import jobdescription.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class JobSearchViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private JobSearchRepository jobSearchRepository;
    //>>> DDD / CQRS
}
