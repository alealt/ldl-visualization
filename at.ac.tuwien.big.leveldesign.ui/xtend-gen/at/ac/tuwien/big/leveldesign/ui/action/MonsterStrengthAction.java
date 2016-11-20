package at.ac.tuwien.big.leveldesign.ui.action;

import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram;
import com.google.common.base.Objects;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.tools.actions.DiagramAction;
import eu.hansolo.enzo.radialmenu.SymbolType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("all")
public class MonsterStrengthAction implements DiagramAction {
  private boolean activated;
  
  @Override
  public SymbolType getSymbol() {
    return SymbolType.EYE;
  }
  
  @Override
  public String getTooltip() {
    return "Display Monster Strength";
  }
  
  @Override
  public boolean matches(final KeyEvent it) {
    return (it.isShortcutDown() && Objects.equal(it.getCode(), KeyCode.M));
  }
  
  @Override
  public void perform(final XRoot root) {
    if ((!this.activated)) {
      XDiagram _diagram = root.getDiagram();
      ((RoomDiagram) _diagram).showMonsterStrength();
      this.activated = true;
    } else {
      XDiagram _diagram_1 = root.getDiagram();
      ((RoomDiagram) _diagram_1).hideMonsterStrength();
      this.activated = false;
    }
  }
}
