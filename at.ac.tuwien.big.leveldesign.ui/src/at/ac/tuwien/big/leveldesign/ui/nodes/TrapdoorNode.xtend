package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseNode
import de.fxdiagram.mapping.IMappedElementDescriptor
import javafx.scene.image.ImageView
import javafx.scene.image.Image
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor
import de.fxdiagram.annotations.properties.ModelNode
import de.fxdiagram.core.behavior.MoveBehavior
import de.fxdiagram.annotations.properties.FxProperty
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior

@ModelNode
class TrapdoorNode extends BaseNode<Trapdoor> {
	@FxProperty CoordinateView position;
		
	new(IMappedElementDescriptor<Trapdoor> descriptor) {
		super(descriptor)	
		position = Domain2ViewModelConverter.coordinate(descriptor.withDomainObject[position])
	}
	
	override protected createNode() {
		var mon = new ImageView(new Image("images/SmallCrate.png"))
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
