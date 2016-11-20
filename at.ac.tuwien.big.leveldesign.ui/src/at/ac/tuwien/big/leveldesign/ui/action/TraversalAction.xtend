package at.ac.tuwien.big.leveldesign.ui.action

import de.fxdiagram.core.tools.actions.DiagramAction
import javafx.scene.input.KeyEvent
import de.fxdiagram.core.XRoot
import eu.hansolo.enzo.radialmenu.SymbolType
import javafx.scene.input.KeyCode
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram

class TraversalAction implements DiagramAction {
	
	var boolean activated;
	
	override getSymbol() {
		SymbolType.CAR
	}
	
	override getTooltip() {
		'Traverse Level'
	}
	
	override matches(KeyEvent it) {
		isShortcutDown && code == KeyCode.T	
	}
	
	override perform(XRoot root) {
		if(!activated) {
			(root.diagram as RoomDiagram).showTraversalDialog
			activated=true;
		} else {
			(root.diagram as RoomDiagram).stopTraversal
			activated=false;
		}
	}
	
}