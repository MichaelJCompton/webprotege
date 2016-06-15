package org.ontologyengineering.protege.web.client.handler;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.stanford.bmir.protege.web.client.dispatch.DispatchServiceCallback;
import edu.stanford.bmir.protege.web.client.dispatch.DispatchServiceManager;
import edu.stanford.bmir.protege.web.client.dispatch.actions.CreateClassAction;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.ontologyengineering.conceptdiagrams.web.client.handler.ConvertAllToOWLService;
import org.ontologyengineering.conceptdiagrams.web.client.handler.ConvertAllToOWLServiceAsync;
import org.ontologyengineering.conceptdiagrams.web.client.handler.ConvertToOWLServiceManager;
import org.ontologyengineering.conceptdiagrams.web.shared.ClientContext;
import org.ontologyengineering.conceptdiagrams.web.shared.commands.Command;
import org.ontologyengineering.conceptdiagrams.web.shared.diagrams.DiagramSet;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllAction;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllResult;

import java.util.ArrayList;

/**
 * Created by Michael on 15/06/2016.
 */
public class WebProtegeConvertToOWLServiceManager extends ConvertToOWLServiceManager {

    private ProjectId projectID;

    public WebProtegeConvertToOWLServiceManager() {

    }

    public WebProtegeConvertToOWLServiceManager(ProjectId projectID) {
        this.projectID = projectID;
    }

    // portlet can tell me project Id with getProjectId()
    public void convertAllToOWL(ArrayList<Command> history, DiagramSet diagrams) {

        DispatchServiceManager.get().execute(new ConceptDiagramsConvertAllAction(projectID, history, diagrams), getCreateClassesActionAsyncHandler());

    }

    private DispatchServiceCallback<ConceptDiagramsConvertAllResult> getCreateClassesActionAsyncHandler() {
        return new DispatchServiceCallback<ConceptDiagramsConvertAllResult>() {
            @Override
            public void handleSuccess(ConceptDiagramsConvertAllResult result) {

            }
        };
    }

}
