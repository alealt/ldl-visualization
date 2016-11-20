package at.ac.tuwien.big.leveldesign.ui.action

import de.fxdiagram.core.tools.actions.DiagramAction
import javafx.scene.input.KeyEvent
import de.fxdiagram.core.XRoot
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram
import javafx.scene.input.KeyCode
import eu.hansolo.enzo.radialmenu.SymbolType
import at.ac.tuwien.big.leveldesign.ui.nodes.LevelDiagram

class ChartPowerAction implements DiagramAction {
	var boolean activated;
	
	override getSymbol() {
		SymbolType.LOCK
	}
	
	override getTooltip() {
		'Display Required-Power-Chart'
	}
	
	override matches(KeyEvent it) {
		isShortcutDown && code == KeyCode.J
	}
	
	override perform(XRoot root) {
		
		if(!activated) {
			(root.diagram as LevelDiagram).showPowerGraph
			activated=true;
		} else {
			(root.diagram as LevelDiagram).hidePowerGraph
			activated=false;
		}
			
	}
}