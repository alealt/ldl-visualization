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
public class TraversalAction implements DiagramAction {
  private boolean activated;
  
  @Override
  public SymbolType getSymbol() {
    return SymbolType.CAR;
  }
  
  @Override
  public String getTooltip() {
    return "Traverse Level";
  }
  
  @Override
  public boolean matches(final KeyEvent it) {
    return (it.isShortcutDown() && Objects.equal(it.getCode(), KeyCode.T));
  }
  
  @Override
  public void perform(final XRoot root) {
    if ((!this.activated)) {
      XDiagram _diagram = root.getDiagram();
      ((RoomDiagram) _diagram).showTraversalDialog();
      this.activated = true;
    } else {
      XDiagram _diagram_1 = root.getDiagram();
      ((RoomDiagram) _diagram_1).stopTraversal();
      this.activated = false;
    }
  }
}
