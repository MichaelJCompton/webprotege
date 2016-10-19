package org.ontologyengineering.protege.web.server.dispatch.handlers;

import edu.stanford.bmir.protege.web.server.change.ChangeApplicationResult;
import edu.stanford.bmir.protege.web.server.change.ChangeDescriptionGenerator;
import edu.stanford.bmir.protege.web.server.change.ChangeListGenerator;
import edu.stanford.bmir.protege.web.server.change.FixedMessageChangeDescriptionGenerator;
import edu.stanford.bmir.protege.web.server.dispatch.AbstractProjectChangeHandler;
import edu.stanford.bmir.protege.web.server.dispatch.ExecutionContext;
import edu.stanford.bmir.protege.web.server.dispatch.RequestContext;
import edu.stanford.bmir.protege.web.server.dispatch.RequestValidator;
import edu.stanford.bmir.protege.web.server.dispatch.validators.UserHasProjectWritePermissionValidator;
import edu.stanford.bmir.protege.web.server.owlapi.OWLAPIProject;
import edu.stanford.bmir.protege.web.server.owlapi.OWLAPIProjectManager;
import edu.stanford.bmir.protege.web.shared.event.ProjectEvent;
import edu.stanford.bmir.protege.web.shared.events.EventList;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllAction;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllResult;
import org.ontologyengineering.protege.web.server.change.ConceptDiagramsConvertAllChangeGenerator;
import org.semanticweb.owlapi.model.OWLClass;

import javax.inject.Inject;

/**
 * Created by Michael on 15/06/2016.
 */
public class ConceptDiagramsConvertAllActionHandler extends AbstractProjectChangeHandler<OWLClass, ConceptDiagramsConvertAllAction, ConceptDiagramsConvertAllResult> {

    @Inject
    public ConceptDiagramsConvertAllActionHandler(OWLAPIProjectManager projectManager) {
        super(projectManager);
    }

    @Override
    protected ChangeListGenerator<OWLClass> getChangeListGenerator(ConceptDiagramsConvertAllAction action, OWLAPIProject project, ExecutionContext executionContext) {
        return new ConceptDiagramsConvertAllChangeGenerator(action.getHistories(), action.getDiagrams());
    }

    @Override
    protected ChangeDescriptionGenerator<OWLClass> getChangeDescription(ConceptDiagramsConvertAllAction action, OWLAPIProject project, ExecutionContext executionContext) {
        return new FixedMessageChangeDescriptionGenerator<>("Generated OWL from Concept Diagram");
    }

    @Override
    protected ConceptDiagramsConvertAllResult createActionResult(ChangeApplicationResult<OWLClass> changeApplicationResult, ConceptDiagramsConvertAllAction action, OWLAPIProject project, ExecutionContext executionContext, EventList<ProjectEvent<?>> eventList) {
        return new ConceptDiagramsConvertAllResult(eventList);
    }


    @Override
    protected RequestValidator<ConceptDiagramsConvertAllAction> getAdditionalRequestValidator(ConceptDiagramsConvertAllAction action, RequestContext requestContext) {
        return UserHasProjectWritePermissionValidator.get();
    }

    @Override
    public Class<ConceptDiagramsConvertAllAction> getActionClass() {
        return ConceptDiagramsConvertAllAction.class;
    }
}
