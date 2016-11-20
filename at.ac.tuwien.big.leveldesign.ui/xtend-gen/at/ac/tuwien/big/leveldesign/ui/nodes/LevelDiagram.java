package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Level;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.ui.action.ChartPowerAction;
import at.ac.tuwien.big.leveldesign.ui.action.ChartTraversalHPAction;
import at.ac.tuwien.big.leveldesign.ui.dialog.DialogHandler;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.interpretation.ChartInterpretation;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.extensions.CoreExtensions;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.core.tools.actions.DiagramAction;
import de.fxdiagram.core.tools.actions.DiagramActionRegistry;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.shapes.BaseDiagram;
import java.util.Collections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@ModelNode
@SuppressWarnings("all")
public class LevelDiagram extends BaseDiagram<Level> {
  private IMappedElementDescriptor<Level> descriptor;
  
  private Node traversalHpChart;
  
  private Node powerChart;
  
  private Node traversalHPDialog;
  
  public LevelDiagram(final IMappedElementDescriptor<Level> descriptor) {
    super(descriptor);
    this.descriptor = descriptor;
    this.setLayoutOnActivate(true);
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    XRoot _root = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry = _root.getDiagramActionRegistry();
    ChartTraversalHPAction _chartTraversalHPAction = new ChartTraversalHPAction();
    _diagramActionRegistry.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_chartTraversalHPAction)));
    XRoot _root_1 = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry_1 = _root_1.getDiagramActionRegistry();
    ChartPowerAction _chartPowerAction = new ChartPowerAction();
    _diagramActionRegistry_1.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_chartPowerAction)));
  }
  
  public void hideAll() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      n.setVisible(false);
    }
  }
  
  public void showAll() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      n.setVisible(true);
    }
  }
  
  public boolean showTraversalDialog() {
    boolean _xblockexpression = false;
    {
      this.hideAll();
      BorderPane _specificationForm = DialogHandler.getSpecificationForm(this);
      this.traversalHPDialog = _specificationForm;
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _xblockexpression = _children.add(this.traversalHPDialog);
    }
    return _xblockexpression;
  }
  
  public boolean showTraversalHPGraph(final HeroView heroSpecs) {
    boolean _xblockexpression = false;
    {
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _children.remove(this.traversalHPDialog);
      final Function1<Level, Room> _function = (Level it) -> {
        return it.getSpawnRoom();
      };
      Room _withDomainObject = this.descriptor.<Room>withDomainObject(_function);
      RoomView startRoom = Domain2ViewModelConverter.room(_withDomainObject);
      final Function1<Level, Room> _function_1 = (Level it) -> {
        return it.getGoalRoom();
      };
      Room _withDomainObject_1 = this.descriptor.<Room>withDomainObject(_function_1);
      RoomView goalRoom = Domain2ViewModelConverter.room(_withDomainObject_1);
      ChartInterpretation _chartInterpretation = new ChartInterpretation(startRoom, goalRoom);
      Node _traversalHpChart = _chartInterpretation.traversalHpChart(heroSpecs);
      this.traversalHpChart = _traversalHpChart;
      Group _nodeLayer_1 = this.getNodeLayer();
      ObservableList<Node> _children_1 = _nodeLayer_1.getChildren();
      _xblockexpression = _children_1.add(this.traversalHpChart);
    }
    return _xblockexpression;
  }
  
  public void hideTraversalHPGraph() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    _children.remove(this.traversalHPDialog);
    Group _nodeLayer_1 = this.getNodeLayer();
    ObservableList<Node> _children_1 = _nodeLayer_1.getChildren();
    _children_1.remove(this.traversalHpChart);
    this.showAll();
  }
  
  public boolean showPowerGraph() {
    boolean _xblockexpression = false;
    {
      this.hideAll();
      final Function1<Level, Room> _function = (Level it) -> {
        return it.getSpawnRoom();
      };
      Room _withDomainObject = this.descriptor.<Room>withDomainObject(_function);
      RoomView startRoom = Domain2ViewModelConverter.room(_withDomainObject);
      final Function1<Level, Room> _function_1 = (Level it) -> {
        return it.getGoalRoom();
      };
      Room _withDomainObject_1 = this.descriptor.<Room>withDomainObject(_function_1);
      RoomView goalRoom = Domain2ViewModelConverter.room(_withDomainObject_1);
      ChartInterpretation _chartInterpretation = new ChartInterpretation(startRoom, goalRoom);
      Node _requiredPowerChart = _chartInterpretation.requiredPowerChart();
      this.powerChart = _requiredPowerChart;
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _xblockexpression = _children.add(this.powerChart);
    }
    return _xblockexpression;
  }
  
  public void hidePowerGraph() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    _children.remove(this.powerChart);
    this.showAll();
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public LevelDiagram() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public String toString() {
    return ToString.toString(this);
  }
}
