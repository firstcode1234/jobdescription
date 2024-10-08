package jobdescription.domain;

import java.util.Date;
import java.util.List;
import jobdescription.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "jobdescriptions",
    path = "jobdescriptions"
)
public interface JobdescriptionRepository
    extends PagingAndSortingRepository<Jobdescription, Long> {}
