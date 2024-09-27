package jobdescription.domain;

import jobdescription.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository
    extends PagingAndSortingRepository<Employee, Long> {}
