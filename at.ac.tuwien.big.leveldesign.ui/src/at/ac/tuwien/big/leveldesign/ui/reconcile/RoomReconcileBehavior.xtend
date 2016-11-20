package at.ac.tuwien.big.leveldesign.ui.reconcile

import de.fxdiagram.mapping.reconcile.DiagramReconcileBehavior
import de.fxdiagram.mapping.shapes.BaseDiagram
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram
import de.fxdiagram.mapping.IMappedElementDescriptor
import at.ac.tuwien.big.leveldesign.levelDesign.Room

import static de.fxdiagram.core.behavior.DirtyState.*
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode
import de.fxdiagram.core.XNode
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode
import javafx.scene.shape.Rectangle
import javafx.scene.image.Image
import javafx.scene.paint.ImagePattern

class RoomReconcileBehavior<T> extends DiagramReconcileBehavior<T> {
	
	val TILE_SIZE = 32;
	
	new(BaseDiagram<T> host) {
		super(host)
	}
	
	override getDirtyState() {
		var columns = (host.domainObjectDescriptor as IMappedElementDescriptor<Room>).withDomainObject[columns]
		var rows = (host.domainObjectDescriptor as IMappedElementDescriptor<Room>).withDomainObject[rows]
					
		if((host as RoomDiagram).columns != columns || (host as RoomDiagram).rows != rows) {
			if(columns==0 || rows==0)
				return DANGLING
			
			return DIRTY
		}

		super.dirtyState
	}
	
	override reconcile(UpdateAcceptor acceptor) {
		super.reconcile(acceptor)
		(host as RoomDiagram).reconcileBackground
		
		for(XNode n : host.nodes) {
			if(n instanceof MonsterNode) {
				val domainPosition = Domain2ViewModelConverter.coordinate((n as MonsterNode).domainObjectDescriptor.withDomainObject[position])
				(n as MonsterNode).position = domainPosition
				n.layoutX = domainPosition.column*TILE_SIZE
				n.layoutY = domainPosition.row*TILE_SIZE		
			} else if(n instanceof TrapdoorNode) {
				val domainPosition = Domain2ViewModelConverter.coordinate((n as  TrapdoorNode).domainObjectDescriptor.withDomainObject[position])
				(n as TrapdoorNode).position = domainPosition
				n.layoutX = domainPosition.column*TILE_SIZE
				n.layoutY = domainPosition.row*TILE_SIZE		
			} else if(n instanceof EntryNode) {
				val domainPosition = Domain2ViewModelConverter.coordinate((n as  EntryNode).domainObjectDescriptor.withDomainObject[position])
				(n as EntryNode).position = domainPosition
				n.layoutX = domainPosition.column*TILE_SIZE
				n.layoutY = domainPosition.row*TILE_SIZE		
			} else if(n instanceof ExitNode) {
				val domainPosition = Domain2ViewModelConverter.coordinate((n as  ExitNode).domainObjectDescriptor.withDomainObject[position])
				(n as ExitNode).position = domainPosition
				n.layoutX = domainPosition.column*TILE_SIZE
				n.layoutY = domainPosition.row*TILE_SIZE		
			} else if(n instanceof WallNode) {
				val fromRow = (n as WallNode).domainObjectDescriptor.withDomainObject[from.row]
				val fromColumn = (n  as WallNode).domainObjectDescriptor.withDomainObject[from.column]
				val toRow = (n  as WallNode).domainObjectDescriptor.withDomainObject[to.row]
				val toColumn = (n as WallNode).domainObjectDescriptor.withDomainObject[to.column]
				
				var Integer startColumn
				var Integer endColumn
				var Integer startRow
				var Integer endRow
								
				if(fromRow==toRow)  { //horizontal
					if(fromColumn<toColumn) { startColumn = fromColumn; endColumn = toColumn} 
					else { startColumn = toColumn; endColumn = fromColumn}
					startRow = fromRow;
					endRow = fromRow;
				} else if(fromColumn==toColumn)  { //vertical
					if(fromRow<toRow) { startRow = fromRow; endRow = toRow} 
					else { startRow = toRow; endRow = fromRow}
					startColumn = fromColumn;
					endColumn = fromColumn;
				}

				n.layoutX = startColumn*TILE_SIZE
				n.layoutY = startRow*TILE_SIZE
				
			}
		}
	}
	
}