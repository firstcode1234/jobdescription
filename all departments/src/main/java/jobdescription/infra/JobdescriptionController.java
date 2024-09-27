package jobdescription.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import jobdescription.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/jobdescriptions")
@Transactional
public class JobdescriptionController {

    @Autowired
    JobdescriptionRepository jobdescriptionRepository;

    @RequestMapping(
        value = "/jobdescriptions/{id}//enter",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Jobdescription enter(
        @PathVariable(value = "id") Long id,
        @RequestBody EnterCommand enterCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /jobdescription/enter  called #####");
        Optional<Jobdescription> optionalJobdescription = jobdescriptionRepository.findById(
            id
        );

        optionalJobdescription.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        Jobdescription jobdescription = optionalJobdescription.get();
        jobdescription.enter(enterCommand);

        jobdescriptionRepository.save(jobdescription);
        return jobdescription;
    }

    @RequestMapping(
        value = "/jobdescriptions/{id}//modify",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Jobdescription modify(
        @PathVariable(value = "id") Long id,
        @RequestBody ModifyCommand modifyCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /jobdescription/modify  called #####");
        Optional<Jobdescription> optionalJobdescription = jobdescriptionRepository.findById(
            id
        );

        optionalJobdescription.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        Jobdescription jobdescription = optionalJobdescription.get();
        jobdescription.modify(modifyCommand);

        jobdescriptionRepository.save(jobdescription);
        return jobdescription;
    }

    @RequestMapping(
        value = "/jobdescriptions/{id}//delete",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Jobdescription delete(
        @PathVariable(value = "id") Long id,
        @RequestBody DeleteCommand deleteCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /jobdescription/delete  called #####");
        Optional<Jobdescription> optionalJobdescription = jobdescriptionRepository.findById(
            id
        );

        optionalJobdescription.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        Jobdescription jobdescription = optionalJobdescription.get();
        jobdescription.delete(deleteCommand);

        jobdescriptionRepository.delete(jobdescription);
        return jobdescription;
    }
}
//>>> Clean Arch / Inbound Adaptor
