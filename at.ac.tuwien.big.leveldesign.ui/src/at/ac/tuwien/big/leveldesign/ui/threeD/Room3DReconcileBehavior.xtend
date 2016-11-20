package at.ac.tuwien.big.leveldesign.ui.threeD

import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior
import de.fxdiagram.core.XNode
import de.fxdiagram.mapping.AbstractMapping
import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DNode

class Room3DReconcileBehavior<T> extends NodeReconcileBehavior<T> {
	
	val TILE_SIZE = 32
	
	new(XNode host) {
		super(host)
	}
	
	override protected reconcile(AbstractMapping<T> mapping, T domainObject, UpdateAcceptor acceptor) {
		super.reconcile(mapping,domainObject,acceptor);	
		(host as Room3DNode).updateNode()
		
	}	
}