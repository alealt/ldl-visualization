package at.ac.tuwien.big.leveldesign.ui.reconcile

import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior
import de.fxdiagram.core.XNode
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import de.fxdiagram.mapping.IMappedElementDescriptor
import at.ac.tuwien.big.leveldesign.levelDesign.Wall

import static de.fxdiagram.core.behavior.DirtyState.*
import de.fxdiagram.mapping.AbstractMapping

import javafx.scene.image.Image
import javafx.scene.paint.ImagePattern
import javafx.scene.shape.Rectangle

class WallReconcileBehavior<T> extends NodeReconcileBehavior<T> {
	
	val TILE_SIZE = 32
	
	new(XNode host) {
		super(host)
	}
	
	override getDirtyState() {
		if(host instanceof WallNode) {
			var fromDomainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Wall>).withDomainObject[from])
			var toDomainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Wall>).withDomainObject[to])
		
			if(!(host as WallNode).fromPosition.equals(fromDomainPosition) ||
				!(host as WallNode).toPosition.equals(toDomainPosition))  return DIRTY
		}
		
		super.dirtyState
	}
	
	override protected reconcile(AbstractMapping<T> mapping, T domainObject, UpdateAcceptor acceptor) {
		super.reconcile(mapping,domainObject,acceptor);	
		(host as WallNode).updateNode()
		
	}
	
}