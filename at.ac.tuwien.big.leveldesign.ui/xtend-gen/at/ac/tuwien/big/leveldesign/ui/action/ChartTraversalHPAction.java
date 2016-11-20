package at.ac.tuwien.big.leveldesign.ui.action;

import at.ac.tuwien.big.leveldesign.ui.nodes.LevelDiagram;
import com.google.common.base.Objects;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.tools.actions.DiagramAction;
import eu.hansolo.enzo.radialmenu.SymbolType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("all")
public class ChartTraversalHPAction implements DiagramAction {
  private boolean activated;
  
  @Override
  public SymbolType getSymbol() {
    return SymbolType.HEART;
  }
  
  @Override
  public String getTooltip() {
    return "Display Healthpoints-During-Traversal Chart ";
  }
  
  @Override
  public boolean matches(final KeyEvent it) {
    return (it.isShortcutDown() && Objects.equal(it.getCode(), KeyCode.G));
  }
  
  @Override
  public void perform(final XRoot root) {
    if ((!this.activated)) {
      XDiagram _diagram = root.getDiagram();
      ((LevelDiagram) _diagram).showTraversalDialog();
      this.activated = true;
    } else {
      XDiagram _diagram_1 = root.getDiagram();
      ((LevelDiagram) _diagram_1).hideTraversalHPGraph();
      this.activated = false;
    }
  }
}
