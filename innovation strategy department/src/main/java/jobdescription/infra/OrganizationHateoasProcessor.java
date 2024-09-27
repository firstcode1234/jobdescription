package jobdescription.infra;

import jobdescription.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrganizationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Organization>> {

    @Override
    public EntityModel<Organization> process(EntityModel<Organization> model) {
        return model;
    }
}
