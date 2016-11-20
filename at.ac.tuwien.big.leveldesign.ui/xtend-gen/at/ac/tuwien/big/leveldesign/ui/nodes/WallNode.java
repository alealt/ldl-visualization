package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.reconcile.WallReconcileBehavior;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.behavior.MoveBehavior;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.shapes.BaseNode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@ModelNode
@SuppressWarnings("all")
public class WallNode extends BaseNode<Wall> {
  private final int TILE_SIZE = 32;
  
  public WallNode(final IMappedElementDescriptor<Wall> descriptor) {
    super(descriptor);
    IMappedElementDescriptor<Wall> _domainObjectDescriptor = this.getDomainObjectDescriptor();
    final Function1<Wall, Coordinate> _function = (Wall it) -> {
      return it.getFrom();
    };
    Coordinate _withDomainObject = _domainObjectDescriptor.<Coordinate>withDomainObject(_function);
    CoordinateView _coordinate = Domain2ViewModelConverter.coordinate(_withDomainObject);
    this.setFromPosition(_coordinate);
    IMappedElementDescriptor<Wall> _domainObjectDescriptor_1 = this.getDomainObjectDescriptor();
    final Function1<Wall, Coordinate> _function_1 = (Wall it) -> {
      return it.getTo();
    };
    Coordinate _withDomainObject_1 = _domainObjectDescriptor_1.<Coordinate>withDomainObject(_function_1);
    CoordinateView _coordinate_1 = Domain2ViewModelConverter.coordinate(_withDomainObject_1);
    this.setToPosition(_coordinate_1);
  }
  
  @Override
  protected Node createNode() {
    Rectangle _xblockexpression = null;
    {
      IMappedElementDescriptor<Wall> _domainObjectDescriptor = this.getDomainObjectDescriptor();
      final Function1<Wall, Integer> _function = (Wall it) -> {
        Coordinate _from = it.getFrom();
        return Integer.valueOf(_from.getRow());
      };
      final Integer fromRow = _domainObjectDescriptor.<Integer>withDomainObject(_function);
      IMappedElementDescriptor<Wall> _domainObjectDescriptor_1 = this.getDomainObjectDescriptor();
      final Function1<Wall, Integer> _function_1 = (Wall it) -> {
        Coordinate _from = it.getFrom();
        return Integer.valueOf(_from.getColumn());
      };
      final Integer fromColumn = _domainObjectDescriptor_1.<Integer>withDomainObject(_function_1);
      IMappedElementDescriptor<Wall> _domainObjectDescriptor_2 = this.getDomainObjectDescriptor();
      final Function1<Wall, Integer> _function_2 = (Wall it) -> {
        Coordinate _to = it.getTo();
        return Integer.valueOf(_to.getRow());
      };
      final Integer toRow = _domainObjectDescriptor_2.<Integer>withDomainObject(_function_2);
      IMappedElementDescriptor<Wall> _domainObjectDescriptor_3 = this.getDomainObjectDescriptor();
      final Function1<Wall, Integer> _function_3 = (Wall it) -> {
        Coordinate _to = it.getTo();
        return Integer.valueOf(_to.getColumn());
      };
      final Integer toColumn = _domainObjectDescriptor_3.<Integer>withDomainObject(_function_3);
      final int rowDistance = Math.abs(((fromRow).intValue() - (toRow).intValue()));
      final int columnDistance = Math.abs(((fromColumn).intValue() - (toColumn).intValue()));
      final Rectangle wall = new Rectangle((this.TILE_SIZE * (columnDistance + 1)), (this.TILE_SIZE * (rowDistance + 1)));
      final Image wallImg = new Image("images/wall.png");
      ImagePattern _imagePattern = new ImagePattern(wallImg, 0, 0, this.TILE_SIZE, this.TILE_SIZE, false);
      wall.setFill(_imagePattern);
      _xblockexpression = wall;
    }
    return _xblockexpression;
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    this.removeBehavior(MoveBehavior.class);
    WallReconcileBehavior<Object> _wallReconcileBehavior = new WallReconcileBehavior<Object>(this);
    this.addBehavior(_wallReconcileBehavior);
  }
  
  public void updateNode() {
    Node node = this.createNode();
    ObservableList<Node> _children = this.getChildren();
    _children.clear();
    ObjectProperty<Node> _nodeProperty = this.nodeProperty();
    _nodeProperty.set(node);
    this.addNodeAsChild(node);
    IMappedElementDescriptor<Wall> _domainObjectDescriptor = this.getDomainObjectDescriptor();
    final Function1<Wall, Coordinate> _function = (Wall it) -> {
      return it.getFrom();
    };
    Coordinate _withDomainObject = _domainObjectDescriptor.<Coordinate>withDomainObject(_function);
    CoordinateView _coordinate = Domain2ViewModelConverter.coordinate(_withDomainObject);
    this.setFromPosition(_coordinate);
    IMappedElementDescriptor<Wall> _domainObjectDescriptor_1 = this.getDomainObjectDescriptor();
    final Function1<Wall, Coordinate> _function_1 = (Wall it) -> {
      return it.getTo();
    };
    Coordinate _withDomainObject_1 = _domainObjectDescriptor_1.<Coordinate>withDomainObject(_function_1);
    CoordinateView _coordinate_1 = Domain2ViewModelConverter.coordinate(_withDomainObject_1);
    this.setToPosition(_coordinate_1);
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public WallNode() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public String toString() {
    return ToString.toString(this);
  }
  
  private SimpleObjectProperty<CoordinateView> fromPositionProperty = new SimpleObjectProperty<CoordinateView>(this, "fromPosition");
  
  public CoordinateView getFromPosition() {
    return this.fromPositionProperty.get();
  }
  
  public void setFromPosition(final CoordinateView fromPosition) {
    this.fromPositionProperty.set(fromPosition);
  }
  
  public ObjectProperty<CoordinateView> fromPositionProperty() {
    return this.fromPositionProperty;
  }
  
  private SimpleObjectProperty<CoordinateView> toPositionProperty = new SimpleObjectProperty<CoordinateView>(this, "toPosition");
  
  public CoordinateView getToPosition() {
    return this.toPositionProperty.get();
  }
  
  public void setToPosition(final CoordinateView toPosition) {
    this.toPositionProperty.set(toPosition);
  }
  
  public ObjectProperty<CoordinateView> toPositionProperty() {
    return this.toPositionProperty;
  }
}
