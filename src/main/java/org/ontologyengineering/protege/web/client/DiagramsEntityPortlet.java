package org.ontologyengineering.protege.web.client;

//import com.ait.lienzo.client.core.event.NodeMouseDownEvent;
//import com.ait.lienzo.client.core.event.NodeMouseDownHandler;
//import com.ait.lienzo.client.core.shape.Layer;
//import com.ait.lienzo.client.core.shape.Rectangle;
//import com.ait.lienzo.client.core.types.Transform;
//import com.ait.lienzo.client.widget.LienzoPanel;
//import com.ait.lienzo.shared.core.types.Color;
//import com.ait.lienzo.shared.core.types.ColorName;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.widgets.*;
import edu.stanford.bmir.protege.web.client.project.Project;
import edu.stanford.bmir.protege.web.client.ui.portlet.AbstractOWLEntityPortlet;
import edu.stanford.bmir.protege.web.shared.selection.SelectionModel;
import org.ontologyengineering.conceptdiagrams.web.client.ui.LienzoDiagramCanvas;
import org.ontologyengineering.protege.web.client.handler.WebProtegeConvertToOWLServiceManager;


import java.util.*;


/**
 * Created by Michael on 24/08/2015.
 */
public class DiagramsEntityPortlet extends AbstractOWLEntityPortlet {



    private LienzoDiagramCanvas diagramCanvas;

    public DiagramsEntityPortlet(SelectionModel selectionModel, Project project) {
        super(selectionModel, project);
    }

    @Override
    public void initialize() {
        final com.gwtext.client.widgets.Panel bogusPanel = new com.gwtext.client.widgets.Panel();
        bogusPanel.setId("placeHolderPanel");
        add(bogusPanel);
    }

    protected void afterRender() {
        remove("placeHolderPanel");
        createCanvas();
    }


    private void createCanvas() {

        int width = getInnerWidth();
        int height = getInnerHeight();
        Panel test = new AbsolutePanel();
        add(test);
        diagramCanvas = new LienzoDiagramCanvas(width, height, test, new WebProtegeConvertToOWLServiceManager(getProjectId()));

//        com.gwtext.client.widgets.Panel test = new com.gwtext.client.widgets.Panel();
//        diagramCanvas = new LienzoDiagramCanvas(width, height, test);
    }


}

//
//    private org.ontologyengineering.conceptdiagrams.web.client.LienzoDiagramCanvas
//
//
//    private LienzoPanel panel;
//    private Layer boundaryRectangleLayer;
//    private Layer curveLayer;
//    private Layer zoneLayer;
//    private VerticalPanel mainPanel;
//    private HorizontalPanel buttonPanel;
//
//
//    // quick debugging output
//    private Label textOutLabel;
//    private DateTimeFormat dateFormat;
//
//
//
//    // just for curves.  I think I get the intersections the way we need them either for free or pretty quickly
//    // for everything else on the canvas.
//    //
//    // Lists because the size can change as the layer gets bigger because of pans and more things being drawn
//    // FIXME : this should be per boundary rectangle in the end
//    private List<List<AbstractSet<Object>>> intersectionGrid;
//    private static final double gridSquareSize = 400;
//
//    // need all this to be dynamic in the end
//    private static final int panelWidth = 900;
//    private static final int panelHeight = 600;
//
//    private static final double initBoundaryRectangleXoffset = 20;
//    private static final double initBoundaryRectangleYoffset = 20;
//    private static final double initBoundaryRectangleWidth = panelWidth - (2 * initBoundaryRectangleXoffset);
//    private static final double initBoundaryRectangleHeight = panelHeight - (2 * initBoundaryRectangleYoffset);
//
//
//    private static final ColorName rubberbandRetangleColorName = ColorName.LIGHTSLATEGREY;
//    private static final Color rubberbandRetangleColor = rubberbandRetangleColorName.getColor();
//
//
//    public DiagramsEntityPortlet(SelectionModel selectionModel, Project project) {
//        super(selectionModel, project);
//    }
//
//    @Override
//    public void initialize() {
//        final com.gwtext.client.widgets.Panel bogusPanel = new com.gwtext.client.widgets.Panel();
//        bogusPanel.setId("placeHolderPanel");
//        add(bogusPanel);
//    }
//
//    protected void afterRender() {
//        createCanvas();
//    }
//
//
//    private void createCanvas() {
//
//        remove("placeHolderPanel");
//
//        mainPanel = new VerticalPanel();
//        buttonPanel = new HorizontalPanel();
//        textOutLabel = new Label();
//
//
//        // FIXME : find the size of the viewable area first ... so add the other panel then mine
//        panel = new LienzoPanel(500,500);  //panelWidth, panelHeight);
//
//        // Display timestamp showing last refresh.
//        dateFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
//
//        addToolMenu(buttonPanel);
//
//        curveLayer = new Layer();
//        //addLayerHandlers();
//        panel.add(curveLayer);
//
//        zoneLayer = new Layer();
//        panel.add(zoneLayer);
//        boundaryRectangleLayer = new Layer();
//        panel.add(boundaryRectangleLayer);
//
//
//
//        zoneLayer.moveToTop();
//        curveLayer.moveToTop();
//
//        //addInitialBoundaryRectangle(curveLayer, zoneLayer, boundaryRectangleLayer);
//
//        mainPanel.add(buttonPanel);
//        mainPanel.add(textOutLabel);
//        mainPanel.add(panel);
//        //RootPanel.get().add(mainPanel);
//
//
//
//
//        // want a class hierachy on left ... my panel taking up two columns?
//
//        final AbsolutePanel vPanel = new AbsolutePanel();
//        //vPanel.getElement().getStyle().setProperty("height", "100%");
//        //vPanel.getElement().getStyle().setProperty("width", "100%");
//
//        this.add(vPanel);
//
//        vPanel.add(mainPanel, 0, 0);
//
//        //int height = panel.getHeight();
//        //int width = panel.getWidth();
//
//
//        //Transform t = Transform.createViewportTransform(300, 300, width, height, panel.getViewport().getWidth(), panel.getViewport().getHeight());
//
//        //panel.getViewport().setTransform(t);
//
//        panel.draw();
//        boundaryRectangleLayer.draw();
//
//        int width = getInnerWidth();
//        int height = getInnerHeight();
//
//        final Rectangle theRectangle = new Rectangle(width - 20, height - 20);
//        theRectangle.setX(0);
//        theRectangle.setY(0);
//        theRectangle.setStrokeWidth(10);
//        theRectangle.setDraggable(true);
//        boundaryRectangleLayer.add(theRectangle);
//
//        final Rectangle theRectangle2 = new Rectangle(width - 20, height - 20);
//        theRectangle2.setX(500);
//        theRectangle2.setY(500);
//        theRectangle2.setStrokeWidth(10);
//        theRectangle2.setDraggable(true);
//        boundaryRectangleLayer.add(theRectangle2);
//
//
//        final Rectangle theRectangle23 = new Rectangle(width - 20, height - 20);
//        theRectangle23.setX(900);
//        theRectangle23.setY(1000);
//        theRectangle23.setStrokeWidth(10);
//        theRectangle23.setDraggable(true);
//        boundaryRectangleLayer.add(theRectangle23);
//
//
//
//        //height = boundaryRectangleLayer.getHeight();
//        //width = boundaryRectangleLayer.getWidth();
//        textOutLabel.setText("Nothing to say yet. " + height + " " + width);
//
//
//        curveLayer.addNodeMouseDownHandler(new NodeMouseDownHandler() {
//            //int height = boundaryRectangleLayer.getHeight();
//            //int width = boundaryRectangleLayer.getWidth();
//
//            @Override
//            public void onNodeMouseDown(NodeMouseDownEvent event) {
//                int clickX = event.getX();
//                int clickY = event.getY();
//
//                int width = getInnerWidth();
//                int height = getInnerHeight();
//                textOutLabel.setText("Nothing to say yet bla bla. " + width + " " + height);
//
//                //textOutLabel.setText("Nothing to say yet. " + height + " " + width + " But click at " + clickX + " " + clickY);
//
//                //panel.getViewport().getTransform().scale(.99);
//
//                final Rectangle theRectangle = new Rectangle(width - 30, height - 100);
//                theRectangle.setX(10);
//                theRectangle.setY(10);
//                theRectangle.setStrokeWidth(10);
//                theRectangle.setDraggable(true);
//                boundaryRectangleLayer.add(theRectangle);
//
//                boundaryRectangleLayer.batch();
//                curveLayer.batch();
//                zoneLayer.batch();
//            }
//        });
//
//
//                // create the grid for faster intersection checking
//                intersectionGrid = new ArrayList<List<AbstractSet<Object>>>();
//        for (int i = 0; i < (int) Math.ceil(curveLayer.getHeight() / gridSquareSize); i++) {
//            intersectionGrid.add(new ArrayList<AbstractSet<Object>>());
//            for (int j = 0; j < (int) Math.ceil(curveLayer.getWidth() / gridSquareSize); j++) {
//                intersectionGrid.get(i).add(new HashSet<Object>());
//            }
//        }
//
//        boundaryRectangleLayer.batch();
//        curveLayer.batch();
//        zoneLayer.batch();
//    }
//
//    //protected void afterRender() {
//    //    int width = getInnerWidth();
//    //    int height = getHeight();
//    //    textOutLabel.setText("Nothing to say yet. " + height + " " + width);
//    //}
//
//            private void addInitialBoundaryRectangle(Layer curveLayer, Layer zoneLayer, Layer boundaryRectangleLayer) {
//                final Rectangle theRectangle = new Rectangle(initBoundaryRectangleWidth, initBoundaryRectangleHeight);
//                theRectangle.setX(initBoundaryRectangleXoffset);
//                theRectangle.setY(initBoundaryRectangleYoffset);
//                theRectangle.setStrokeWidth(10);
//                theRectangle.setDraggable(true);
//                boundaryRectangleLayer.add(theRectangle);
//            }
//
//
//            private void addToolMenu(Panel toolPanel) {
//
//
//                // FIXME : ...maybe all things should just be dragable false anyway, cause I want to implement my own dragging
//                //
//
//                Button PanModeButton = new Button("Pan");
//                toolPanel.add(PanModeButton);
//                PanModeButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//                Button selectModeButton = new Button("Select");
//                toolPanel.add(selectModeButton);
//                selectModeButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                    }
//                });
//
//                Button drawCurveButton = new Button("Curve");
//                toolPanel.add(drawCurveButton);
//                drawCurveButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//
//                Button drawSpiderButton = new Button("Spider");
//                toolPanel.add(drawSpiderButton);
//                drawSpiderButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//
//                Button drawArrowButton = new Button("Arrow");
//                toolPanel.add(drawArrowButton);
//                drawArrowButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//
//                Button shadeButton = new Button("Shade");
//                toolPanel.add(shadeButton);
//                shadeButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//                Button boundaryRectangleButton = new Button("Rectangle");
//                toolPanel.add(boundaryRectangleButton);
//                boundaryRectangleButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//
//                Button deleteButton = new Button("Delete");
//                toolPanel.add(deleteButton);
//                deleteButton.addClickHandler(new ClickHandler() {
//                    @Override
//                    public void onClick(ClickEvent event) {
//
//                        curveLayer.setListening(true);
//                    }
//                });
//            }
//        }
