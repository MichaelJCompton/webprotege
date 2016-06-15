package org.ontologyengineering.protege.web.client.dispatch.actions;

import edu.stanford.bmir.protege.web.client.dispatch.AbstractHasProjectAction;
import edu.stanford.bmir.protege.web.client.dispatch.actions.CreateClassResult;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.ontologyengineering.conceptdiagrams.web.shared.commands.Command;
import org.ontologyengineering.conceptdiagrams.web.shared.diagrams.DiagramSet;
import org.semanticweb.owlapi.model.OWLClass;

import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;


// Based on CreateClassAction

/**
 * Created by Michael on 15/06/2016.
 */
public class ConceptDiagramsConvertAllAction extends AbstractHasProjectAction<ConceptDiagramsConvertAllResult> {

    private ArrayList<Command> history;
    private DiagramSet diagrams;

    /**
     * For serialization only
     */
    private ConceptDiagramsConvertAllAction() {
    }

    public ConceptDiagramsConvertAllAction(ProjectId projectId, ArrayList<Command> history, DiagramSet diagrams) {
        super(checkNotNull(projectId));
        this.history = history;
        this.diagrams = diagrams;
    }

    public ArrayList<Command> getHistory() {
        return history;
    }

    public DiagramSet getDiagrams() {
        return diagrams;
    }
}
