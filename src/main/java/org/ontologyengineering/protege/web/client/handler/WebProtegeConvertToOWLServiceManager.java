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
import org.ontologyengineering.conceptdiagrams.web.shared.WebProtegeClientContext;
import org.ontologyengineering.conceptdiagrams.web.shared.commands.Command;
import org.ontologyengineering.conceptdiagrams.web.shared.concretesyntax.DiagramSet;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllAction;
import org.ontologyengineering.protege.web.client.dispatch.actions.ConceptDiagramsConvertAllResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: Michael Compton<br>
 * Date: June 2016<br>
 * See license information in base directory.
 */
public class WebProtegeConvertToOWLServiceManager extends ConvertToOWLServiceManager {

    private ProjectId projectID;

    public WebProtegeConvertToOWLServiceManager() {

    }

    public WebProtegeConvertToOWLServiceManager(ProjectId projectID) {
        this.projectID = projectID;
    }



    // portlet can tell me project Id with getProjectId()
    public void convertAllToOWL(HashSet<ArrayList<Command>> histories, HashMap<String, DiagramSet> diagrams) {

        DispatchServiceManager.get().execute(new ConceptDiagramsConvertAllAction(projectID, histories, diagrams), getCreateClassesActionAsyncHandler());

    }

    @Override
    public ClientContext getContext() {
        return new WebProtegeClientContext();
    }


//    // portlet can tell me project Id with getProjectId()
//    public void convertAllToOWL(ArrayList<Command> history, DiagramSet diagrams) {
//
//        DispatchServiceManager.get().execute(new ConceptDiagramsConvertAllAction(projectID, history, diagrams), getCreateClassesActionAsyncHandler());
//
//    }

    private DispatchServiceCallback<ConceptDiagramsConvertAllResult> getCreateClassesActionAsyncHandler() {
        return new DispatchServiceCallback<ConceptDiagramsConvertAllResult>() {
            @Override
            public void handleSuccess(ConceptDiagramsConvertAllResult result) {

            }
        };
    }

}
