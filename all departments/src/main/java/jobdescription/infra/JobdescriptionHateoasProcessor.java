package jobdescription.infra;

import jobdescription.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class JobdescriptionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Jobdescription>> {

    @Override
    public EntityModel<Jobdescription> process(
        EntityModel<Jobdescription> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//enter")
                .withRel("/enter")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//modify")
                .withRel("/modify")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//delete")
                .withRel("/delete")
        );

        return model;
    }
}
