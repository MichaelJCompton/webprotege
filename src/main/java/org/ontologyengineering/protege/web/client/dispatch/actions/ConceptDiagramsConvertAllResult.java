package org.ontologyengineering.protege.web.client.dispatch.actions;

import edu.stanford.bmir.protege.web.shared.dispatch.Result;
import edu.stanford.bmir.protege.web.shared.event.HasEventList;
import edu.stanford.bmir.protege.web.shared.event.ProjectEvent;
import edu.stanford.bmir.protege.web.shared.events.EventList;

/**
 * Created by Michael on 15/06/2016.
 */
public class ConceptDiagramsConvertAllResult implements Result, HasEventList<ProjectEvent<?>> {

    private EventList<ProjectEvent<?>> eventList;

    private ConceptDiagramsConvertAllResult() {
    }

    public ConceptDiagramsConvertAllResult(EventList<ProjectEvent<?>> eventList) {
        this.eventList = eventList;
    }

    @Override
    public EventList<ProjectEvent<?>> getEventList() {
        return eventList;
    }
}
