package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType;
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
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@ModelNode
@SuppressWarnings("all")
public class MonsterNode extends BaseNode<Monster> {
  public MonsterNode(final IMappedElementDescriptor<Monster> descriptor) {
    super(descriptor);
    final Function1<Monster, Coordinate> _function = (Monster it) -> {
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
      Sprite sprite = new Sprite(SpriteType.MAGE);
      ImageView mon = sprite.getImageView();
      mon.setFitHeight(32);
      mon.setFitWidth(32);
      _xblockexpression = mon;
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
  public MonsterNode() {
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