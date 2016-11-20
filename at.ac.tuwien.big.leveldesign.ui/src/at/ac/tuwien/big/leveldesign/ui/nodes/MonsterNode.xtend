package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseNode
import de.fxdiagram.mapping.IMappedElementDescriptor
import javafx.scene.shape.Rectangle
import javafx.scene.paint.Color
import javafx.scene.image.ImageView
import javafx.scene.image.Image
import at.ac.tuwien.big.leveldesign.levelDesign.Monster
import de.fxdiagram.annotations.properties.ModelNode
import de.fxdiagram.core.behavior.MoveBehavior
import de.fxdiagram.core.XNode
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType
import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import de.fxdiagram.annotations.properties.FxProperty
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior

@ModelNode
class MonsterNode extends BaseNode<Monster> {
	
	@FxProperty CoordinateView position;
	
	new(IMappedElementDescriptor<Monster> descriptor) {
		super(descriptor)	
		position = Domain2ViewModelConverter.coordinate(descriptor.withDomainObject[position])
	}
	
	override protected createNode() {
		var Sprite sprite = new Sprite(SpriteType.MAGE)
		var mon = sprite.imageView
		mon.setFitHeight(32)
		mon.setFitWidth(32)		
		mon
	}
	
	override doActivate() {
		super.doActivate()
		removeBehavior(MoveBehavior)
		addBehavior(new PositionReconcileBehavior(this))
	}
}
