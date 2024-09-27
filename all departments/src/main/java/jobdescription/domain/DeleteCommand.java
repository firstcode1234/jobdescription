package jobdescription.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteCommand {

    private Long id;
    private String jobname;
    private String jobDescription;
    private String qualifications;
    private String education;
    private String completionEducation;
}
