package org.ontologyengineering.protege.web.server.change;

import edu.stanford.bmir.protege.web.server.change.ChangeGenerationContext;
import edu.stanford.bmir.protege.web.server.change.ChangeListGenerator;
import edu.stanford.bmir.protege.web.server.change.OntologyChangeList;
import edu.stanford.bmir.protege.web.server.owlapi.OWLAPIProject;
import edu.stanford.bmir.protege.web.server.owlapi.RenameMap;
import edu.stanford.bmir.protege.web.shared.DataFactory;
import org.ontologyengineering.conceptdiagrams.web.server.owlOutput.ConvertDiagramsToOWL;
import org.ontologyengineering.conceptdiagrams.web.server.owlOutput.OWLAPIOutputBuilder;
import org.ontologyengineering.conceptdiagrams.web.server.transformations.TransformationManager;
import org.ontologyengineering.conceptdiagrams.web.shared.commands.Command;
import org.ontologyengineering.conceptdiagrams.web.shared.concretesyntax.DiagramSet;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: Michael Compton<br>
 * Date: June 2016<br>
 * See license information in base directory.
 */
public class ConceptDiagramsConvertAllChangeGenerator implements ChangeListGenerator<OWLClass> {

    private HashSet<ArrayList<Command>> histories;
    private HashMap<String, DiagramSet> diagrams;


    public ConceptDiagramsConvertAllChangeGenerator(HashSet<ArrayList<Command>> histories, HashMap<String, DiagramSet> diagrams) {
        this.histories = histories;
        this.diagrams = diagrams;
    }


    @Override
    public OntologyChangeList<OWLClass> generateChanges(OWLAPIProject project, ChangeGenerationContext context) {

        // Don't know what a sensible type parameter is here?
        // I'm taking it that the Option in OntologyChange list means that it's not required
        OntologyChangeList.Builder<OWLClass> builder = new OntologyChangeList.Builder<OWLClass>();

        // FIXME ... need to bundle this better so that both the standard and this are calling same fn()
        // -----
        // was cobbled together from ConvertAllToOWLServiceImpl and ConvertDiagramsToOWL
        for(ArrayList<Command> history : histories) {
            if(history.size() > 0) {
                // just property diagrams for now
                if(history.get(0).getDiagram().getDiagramSet().isPropertyDiagramSet()) {

                    TransformationManager manger = new TransformationManager(history);

                    OWLOntologyManager owlManager = project.getRootOntology().getOWLOntologyManager();
                    OWLAPIOutputBuilder OWLbuilder = new OWLAPIOutputBuilder(project.getRootOntology(), owlManager.getOWLDataFactory());

                    manger.translateAll(OWLbuilder);


                    builder.addAll(OWLbuilder.getChanges());

                }
            }
        }

        return builder.build();
    }

    @Override
    public OWLClass getRenamedResult(OWLClass result, RenameMap renameMap) {
        return renameMap.getRenamedEntity(result);
    }
}
