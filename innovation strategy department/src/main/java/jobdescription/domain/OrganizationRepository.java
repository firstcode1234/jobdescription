package jobdescription.domain;

import jobdescription.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "organizations",
    path = "organizations"
)
public interface OrganizationRepository
    extends PagingAndSortingRepository<Organization, Long> {}
