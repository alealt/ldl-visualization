package at.ac.tuwien.big.leveldesign.ui.reconcile

import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior
import de.fxdiagram.core.XNode
import de.fxdiagram.mapping.AbstractMapping
import java.util.List
import de.fxdiagram.core.XLabel
import at.ac.tuwien.big.leveldesign.levelDesign.Monster
import de.fxdiagram.mapping.IMappedElementDescriptor
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode

import static de.fxdiagram.core.behavior.DirtyState.*
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode
import at.ac.tuwien.big.leveldesign.levelDesign.Exit
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode
import at.ac.tuwien.big.leveldesign.levelDesign.Entry
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor

class PositionReconcileBehavior<T> extends NodeReconcileBehavior<T> {
	
	new(XNode host) {
		super(host)
	}
	
	override getDirtyState() {
		if(host instanceof MonsterNode) {
			var domainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Monster>).withDomainObject[position])
			if(!(host as MonsterNode).position.equals(domainPosition)) return DIRTY
		} else if(host instanceof EntryNode) {
			var domainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Entry>).withDomainObject[position])
			if(!(host as EntryNode).position.equals(domainPosition)) return DIRTY
		} else if(host instanceof ExitNode) {
			var domainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Exit>).withDomainObject[position])
			if(!(host as ExitNode).position.equals(domainPosition)) return DIRTY
		} else if(host instanceof TrapdoorNode) {
			var domainPosition = Domain2ViewModelConverter.coordinate((host.domainObjectDescriptor as IMappedElementDescriptor<Trapdoor>).withDomainObject[position])
			if(!(host as TrapdoorNode).position.equals(domainPosition)) return DIRTY
		}
		
		super.dirtyState
	}
	
	override protected reconcile(AbstractMapping<T> mapping, T domainObject, UpdateAcceptor acceptor) {
		super.reconcile(mapping,domainObject,acceptor);
	}
	
}