package jobdescription.infra;

import java.util.List;
import jobdescription.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "jobSearches",
    path = "jobSearches"
)
public interface JobSearchRepository
    extends PagingAndSortingRepository<JobSearch, Long> {}
