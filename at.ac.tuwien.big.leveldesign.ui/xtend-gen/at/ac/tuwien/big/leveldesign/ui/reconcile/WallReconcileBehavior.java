package at.ac.tuwien.big.leveldesign.ui.reconcile;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.behavior.DirtyState;
import de.fxdiagram.core.behavior.ReconcileBehavior;
import de.fxdiagram.core.model.DomainObjectDescriptor;
import de.fxdiagram.mapping.AbstractMapping;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class WallReconcileBehavior<T extends Object> extends NodeReconcileBehavior<T> {
  private final int TILE_SIZE = 32;
  
  public WallReconcileBehavior(final XNode host) {
    super(host);
  }
  
  @Override
  public DirtyState getDirtyState() {
    DirtyState _xblockexpression = null;
    {
      XNode _host = this.getHost();
      if ((_host instanceof WallNode)) {
        XNode _host_1 = this.getHost();
        DomainObjectDescriptor _domainObjectDescriptor = _host_1.getDomainObjectDescriptor();
        final Function1<Wall, Coordinate> _function = (Wall it) -> {
          return it.getFrom();
        };
        Coordinate _withDomainObject = ((IMappedElementDescriptor<Wall>) _domainObjectDescriptor).<Coordinate>withDomainObject(_function);
        CoordinateView fromDomainPosition = Domain2ViewModelConverter.coordinate(_withDomainObject);
        XNode _host_2 = this.getHost();
        DomainObjectDescriptor _domainObjectDescriptor_1 = _host_2.getDomainObjectDescriptor();
        final Function1<Wall, Coordinate> _function_1 = (Wall it) -> {
          return it.getTo();
        };
        Coordinate _withDomainObject_1 = ((IMappedElementDescriptor<Wall>) _domainObjectDescriptor_1).<Coordinate>withDomainObject(_function_1);
        CoordinateView toDomainPosition = Domain2ViewModelConverter.coordinate(_withDomainObject_1);
        if (((!((WallNode) this.getHost()).getFromPosition().equals(fromDomainPosition)) || 
          (!((WallNode) this.getHost()).getToPosition().equals(toDomainPosition)))) {
          return DirtyState.DIRTY;
        }
      }
      _xblockexpression = super.getDirtyState();
    }
    return _xblockexpression;
  }
  
  @Override
  protected void reconcile(final AbstractMapping<T> mapping, final T domainObject, final ReconcileBehavior.UpdateAcceptor acceptor) {
    super.reconcile(mapping, domainObject, acceptor);
    XNode _host = this.getHost();
    ((WallNode) _host).updateNode();
  }
}
