package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.behavior.MoveBehavior;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.shapes.BaseNode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@ModelNode
@SuppressWarnings("all")
public class EntryNode extends BaseNode<Entry> {
  public EntryNode(final IMappedElementDescriptor<Entry> descriptor) {
    super(descriptor);
    final Function1<Entry, Coordinate> _function = (Entry it) -> {
      return it.getPosition();
    };
    Coordinate _withDomainObject = descriptor.<Coordinate>withDomainObject(_function);
    CoordinateView _coordinate = Domain2ViewModelConverter.coordinate(_withDomainObject);
    this.setPosition(_coordinate);
  }
  
  @Override
  protected Node createNode() {
    ImageView _xblockexpression = null;
    {
      final Image tilemap = new Image("images/tilemap.png");
      final ImageView doorView = new ImageView(tilemap);
      Rectangle2D _rectangle2D = new Rectangle2D((32 * 6), (32 * 1), 32, 32);
      doorView.setViewport(_rectangle2D);
      doorView.setFitHeight(32);
      doorView.setFitWidth(32);
      _xblockexpression = doorView;
    }
    return _xblockexpression;
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    this.removeBehavior(MoveBehavior.class);
    PositionReconcileBehavior<Object> _positionReconcileBehavior = new PositionReconcileBehavior<Object>(this);
    this.addBehavior(_positionReconcileBehavior);
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public EntryNode() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public String toString() {
    return ToString.toString(this);
  }
  
  private SimpleObjectProperty<CoordinateView> positionProperty = new SimpleObjectProperty<CoordinateView>(this, "position");
  
  public CoordinateView getPosition() {
    return this.positionProperty.get();
  }
  
  public void setPosition(final CoordinateView position) {
    this.positionProperty.set(position);
  }
  
  public ObjectProperty<CoordinateView> positionProperty() {
    return this.positionProperty;
  }
}
