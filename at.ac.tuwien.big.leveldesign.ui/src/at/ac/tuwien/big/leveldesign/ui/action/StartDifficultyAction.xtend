package at.ac.tuwien.big.leveldesign.ui.action

import de.fxdiagram.core.tools.actions.DiagramAction
import javafx.scene.input.KeyEvent
import de.fxdiagram.core.XRoot
import eu.hansolo.enzo.radialmenu.SymbolType
import javafx.scene.input.KeyCode
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram

class StartDifficultyAction implements DiagramAction {
	
	var boolean activated;
	
	override getSymbol() {
		SymbolType.COMPASS
	}
	
	override getTooltip() {
		'Show Start Difficulty (May take a few seconds)'
	}
	
	override matches(KeyEvent it) {
		isShortcutDown && code == KeyCode.D
	}
	
	override perform(XRoot root) {
		
		if(!activated) {
			(root.diagram as RoomDiagram).showStartDifficulty
			activated=true;
		} else {
			(root.diagram as RoomDiagram).hideStartDifficulty
			activated=false;
		}
			
	}
	
}