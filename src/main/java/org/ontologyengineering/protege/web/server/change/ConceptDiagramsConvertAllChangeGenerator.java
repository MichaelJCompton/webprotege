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
import org.ontologyengineering.conceptdiagrams.web.shared.diagrams.DiagramSet;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.util.ArrayList;

/**
 * Created by Michael on 15/06/2016.
 */
public class ConceptDiagramsConvertAllChangeGenerator implements ChangeListGenerator<OWLClass> {

    private ArrayList<Command> history;
    private DiagramSet diagrams;

    public ConceptDiagramsConvertAllChangeGenerator(ArrayList<Command> history, DiagramSet diagrams) {
        this.history = history;
        this.diagrams = diagrams;
    }


    @Override
    public OntologyChangeList<OWLClass> generateChanges(OWLAPIProject project, ChangeGenerationContext context) {

        // FIXME ... need to bundle this better so that both the standard and this are calling same fn()
        // -----
        TransformationManager manger = new TransformationManager(history);

        OWLOntologyManager owlManager = project.getRootOntology().getOWLOntologyManager();
        OWLAPIOutputBuilder OWLbuilder = new OWLAPIOutputBuilder(project.getRootOntology(), owlManager.getOWLDataFactory());

        manger.translateAll(OWLbuilder);
        // ----



        // Don't know what a sensible type parameter is here?
        // I'm taking it that the Option in OntologyChange list means that it's not required
        OntologyChangeList.Builder<OWLClass> builder = new OntologyChangeList.Builder<OWLClass>();
        builder.addAll(OWLbuilder.getChanges());
        return builder.build();
    }

    @Override
    public OWLClass getRenamedResult(OWLClass result, RenameMap renameMap) {
        return renameMap.getRenamedEntity(result);
    }
}
