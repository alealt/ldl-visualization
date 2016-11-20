package at.ac.tuwien.big.leveldesign.ui.action

import de.fxdiagram.core.tools.actions.DiagramAction
import javafx.scene.input.KeyEvent
import de.fxdiagram.core.XRoot
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram
import javafx.scene.input.KeyCode
import eu.hansolo.enzo.radialmenu.SymbolType

class AggroRangeAction implements DiagramAction {
	var boolean activated;
	
	override getSymbol() {
		SymbolType.BRUSH
	}
	
	override getTooltip() {
		'Display Aggro Range'
	}
	
	override matches(KeyEvent it) {
		isShortcutDown && code == KeyCode.R
	}
	
	override perform(XRoot root) {
		
		if(!activated) {
			(root.diagram as RoomDiagram).showAggroRange
			activated=true;
		} else {
			(root.diagram as RoomDiagram).hideAggroRange
			activated=false;
		}
			
	}
}