package at.ac.tuwien.big.leveldesign.ui.action

import de.fxdiagram.core.tools.actions.DiagramAction
import javafx.scene.input.KeyEvent
import de.fxdiagram.core.XRoot
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram
import javafx.scene.input.KeyCode
import eu.hansolo.enzo.radialmenu.SymbolType

class MonsterStrengthAction implements DiagramAction {
	var boolean activated;
	
	override getSymbol() {
		SymbolType.EYE
	}
	
	override getTooltip() {
		'Display Monster Strength'
	}
	
	override matches(KeyEvent it) {
		isShortcutDown && code == KeyCode.M
	}
	
	override perform(XRoot root) {
		
		if(!activated) {
			(root.diagram as RoomDiagram).showMonsterStrength
			activated=true;
		} else {
			(root.diagram as RoomDiagram).hideMonsterStrength
			activated=false;
		}
			
	}
}