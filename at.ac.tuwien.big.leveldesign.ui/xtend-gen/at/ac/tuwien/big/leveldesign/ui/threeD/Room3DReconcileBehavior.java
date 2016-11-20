package at.ac.tuwien.big.leveldesign.ui.threeD;

import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.behavior.ReconcileBehavior;
import de.fxdiagram.mapping.AbstractMapping;
import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior;

@SuppressWarnings("all")
public class Room3DReconcileBehavior<T extends Object> extends NodeReconcileBehavior<T> {
  private final int TILE_SIZE = 32;
  
  public Room3DReconcileBehavior(final XNode host) {
    super(host);
  }
  
  @Override
  protected void reconcile(final AbstractMapping<T> mapping, final T domainObject, final ReconcileBehavior.UpdateAcceptor acceptor) {
    super.reconcile(mapping, domainObject, acceptor);
    XNode _host = this.getHost();
    ((Room3DNode) _host).updateNode();
  }
}
