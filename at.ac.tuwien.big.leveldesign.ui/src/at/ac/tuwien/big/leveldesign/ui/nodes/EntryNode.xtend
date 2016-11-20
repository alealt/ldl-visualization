package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseNode
import de.fxdiagram.mapping.IMappedElementDescriptor
import javafx.scene.image.ImageView
import javafx.scene.image.Image
import javafx.geometry.Rectangle2D
import at.ac.tuwien.big.leveldesign.levelDesign.Entry
import de.fxdiagram.annotations.properties.ModelNode
import de.fxdiagram.core.behavior.MoveBehavior
import de.fxdiagram.annotations.properties.FxProperty
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior

@ModelNode
class EntryNode extends BaseNode<Entry> {
	
	@FxProperty CoordinateView position;
	
	new(IMappedElementDescriptor<Entry> descriptor) {
		super(descriptor)	
		position = Domain2ViewModelConverter.coordinate(descriptor.withDomainObject[position])
	}
	
	override protected createNode() {
		val Image tilemap = new Image("images/tilemap.png");
        val ImageView doorView = new ImageView(tilemap);
        doorView.setViewport(new Rectangle2D(32*6,32*1, 32, 32));
        doorView.setFitHeight(32);
        doorView.setFitWidth(32);	
            
		doorView
	}
	
	override doActivate() {
		super.doActivate()
		removeBehavior(MoveBehavior)
		addBehavior(new PositionReconcileBehavior(this))
	}
}
