package org.ontologyengineering.protege.web.client.dispatch.actions;

import edu.stanford.bmir.protege.web.client.dispatch.AbstractHasProjectAction;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.ontologyengineering.conceptdiagrams.web.shared.commands.Command;
import org.ontologyengineering.conceptdiagrams.web.shared.concretesyntax.DiagramSet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static com.google.common.base.Preconditions.checkNotNull;


// Based on CreateClassAction

/**
 * Author: Michael Compton<br>
 * Date: June 2016<br>
 * See license information in base directory.
 */

public class ConceptDiagramsConvertAllAction extends AbstractHasProjectAction<ConceptDiagramsConvertAllResult> {

    private HashSet<ArrayList<Command>> histories;
    private HashMap<String, DiagramSet> diagrams;



    /**
     * For serialization only
     */
    private ConceptDiagramsConvertAllAction() {
    }

    public ConceptDiagramsConvertAllAction(ProjectId projectId, HashSet<ArrayList<Command>> histories, HashMap<String, DiagramSet> diagrams) {
        super(checkNotNull(projectId));
        this.histories = histories;
        this.diagrams = diagrams;
    }

    public HashSet<ArrayList<Command>> getHistories() {
        return histories;
    }

    public HashMap<String, DiagramSet> getDiagrams() {
        return diagrams;
    }
}
