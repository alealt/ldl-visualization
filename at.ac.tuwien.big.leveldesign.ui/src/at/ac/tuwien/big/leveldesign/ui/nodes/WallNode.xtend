package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseNode
import de.fxdiagram.mapping.IMappedElementDescriptor
import javafx.scene.shape.Rectangle
import javafx.scene.image.Image
import javafx.scene.paint.ImagePattern
import at.ac.tuwien.big.leveldesign.levelDesign.Wall
import de.fxdiagram.annotations.properties.ModelNode
import de.fxdiagram.core.behavior.MoveBehavior
import at.ac.tuwien.big.leveldesign.ui.reconcile.PositionReconcileBehavior
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import de.fxdiagram.annotations.properties.FxProperty
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import javafx.scene.Node
import at.ac.tuwien.big.leveldesign.ui.reconcile.WallReconcileBehavior

@ModelNode
class WallNode extends BaseNode<Wall> {
	
	val TILE_SIZE = 32
	@FxProperty CoordinateView fromPosition;
	@FxProperty CoordinateView toPosition;
	
	new(IMappedElementDescriptor<Wall> descriptor) {
		super(descriptor)	
		fromPosition = Domain2ViewModelConverter.coordinate(domainObjectDescriptor.withDomainObject[from])
		toPosition = Domain2ViewModelConverter.coordinate(domainObjectDescriptor.withDomainObject[to])
	}
	
	override protected createNode() {
		
		val fromRow = domainObjectDescriptor.withDomainObject[it.from.row]
		val fromColumn = domainObjectDescriptor.withDomainObject[it.from.column]
		
		val toRow = domainObjectDescriptor.withDomainObject[it.to.row]
		val toColumn = domainObjectDescriptor.withDomainObject[it.to.column]
		
		val rowDistance = Math.abs(fromRow-toRow)
		val columnDistance = Math.abs(fromColumn-toColumn)
		
		val Rectangle wall = new Rectangle(TILE_SIZE*(columnDistance+1),TILE_SIZE*(rowDistance+1));
        val Image wallImg = new Image("images/wall.png");
        wall.setFill(new ImagePattern(wallImg,  0, 0, TILE_SIZE, TILE_SIZE, false));
        
        wall
	}
	
	override doActivate() {
		super.doActivate()
		removeBehavior(MoveBehavior)
		addBehavior(new WallReconcileBehavior(this))
	}
	
	def updateNode() {		
		var Node node = createNode()
		
		children.clear();
		nodeProperty.set(node)
		addNodeAsChild(node)
		
		fromPosition = Domain2ViewModelConverter.coordinate(domainObjectDescriptor.withDomainObject[from])
		toPosition = Domain2ViewModelConverter.coordinate(domainObjectDescriptor.withDomainObject[to])
	}
	
}
