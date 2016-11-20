package at.ac.tuwien.big.leveldesign.ui.reconcile;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.behavior.DirtyState;
import de.fxdiagram.core.behavior.ReconcileBehavior;
import de.fxdiagram.core.model.DomainObjectDescriptor;
import de.fxdiagram.mapping.AbstractMapping;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class PositionReconcileBehavior<T extends Object> extends NodeReconcileBehavior<T> {
  public PositionReconcileBehavior(final XNode host) {
    super(host);
  }
  
  @Override
  public DirtyState getDirtyState() {
    DirtyState _xblockexpression = null;
    {
      XNode _host = this.getHost();
      if ((_host instanceof MonsterNode)) {
        XNode _host_1 = this.getHost();
        DomainObjectDescriptor _domainObjectDescriptor = _host_1.getDomainObjectDescriptor();
        final Function1<Monster, Coordinate> _function = (Monster it) -> {
          return it.getPosition();
        };
        Coordinate _withDomainObject = ((IMappedElementDescriptor<Monster>) _domainObjectDescriptor).<Coordinate>withDomainObject(_function);
        CoordinateView domainPosition = Domain2ViewModelConverter.coordinate(_withDomainObject);
        XNode _host_2 = this.getHost();
        CoordinateView _position = ((MonsterNode) _host_2).getPosition();
        boolean _equals = _position.equals(domainPosition);
        boolean _not = (!_equals);
        if (_not) {
          return DirtyState.DIRTY;
        }
      } else {
        XNode _host_3 = this.getHost();
        if ((_host_3 instanceof EntryNode)) {
          XNode _host_4 = this.getHost();
          DomainObjectDescriptor _domainObjectDescriptor_1 = _host_4.getDomainObjectDescriptor();
          final Function1<Entry, Coordinate> _function_1 = (Entry it) -> {
            return it.getPosition();
          };
          Coordinate _withDomainObject_1 = ((IMappedElementDescriptor<Entry>) _domainObjectDescriptor_1).<Coordinate>withDomainObject(_function_1);
          CoordinateView domainPosition_1 = Domain2ViewModelConverter.coordinate(_withDomainObject_1);
          XNode _host_5 = this.getHost();
          CoordinateView _position_1 = ((EntryNode) _host_5).getPosition();
          boolean _equals_1 = _position_1.equals(domainPosition_1);
          boolean _not_1 = (!_equals_1);
          if (_not_1) {
            return DirtyState.DIRTY;
          }
        } else {
          XNode _host_6 = this.getHost();
          if ((_host_6 instanceof ExitNode)) {
            XNode _host_7 = this.getHost();
            DomainObjectDescriptor _domainObjectDescriptor_2 = _host_7.getDomainObjectDescriptor();
            final Function1<Exit, Coordinate> _function_2 = (Exit it) -> {
              return it.getPosition();
            };
            Coordinate _withDomainObject_2 = ((IMappedElementDescriptor<Exit>) _domainObjectDescriptor_2).<Coordinate>withDomainObject(_function_2);
            CoordinateView domainPosition_2 = Domain2ViewModelConverter.coordinate(_withDomainObject_2);
            XNode _host_8 = this.getHost();
            CoordinateView _position_2 = ((ExitNode) _host_8).getPosition();
            boolean _equals_2 = _position_2.equals(domainPosition_2);
            boolean _not_2 = (!_equals_2);
            if (_not_2) {
              return DirtyState.DIRTY;
            }
          } else {
            XNode _host_9 = this.getHost();
            if ((_host_9 instanceof TrapdoorNode)) {
              XNode _host_10 = this.getHost();
              DomainObjectDescriptor _domainObjectDescriptor_3 = _host_10.getDomainObjectDescriptor();
              final Function1<Trapdoor, Coordinate> _function_3 = (Trapdoor it) -> {
                return it.getPosition();
              };
              Coordinate _withDomainObject_3 = ((IMappedElementDescriptor<Trapdoor>) _domainObjectDescriptor_3).<Coordinate>withDomainObject(_function_3);
              CoordinateView domainPosition_3 = Domain2ViewModelConverter.coordinate(_withDomainObject_3);
              XNode _host_11 = this.getHost();
              CoordinateView _position_3 = ((TrapdoorNode) _host_11).getPosition();
              boolean _equals_3 = _position_3.equals(domainPosition_3);
              boolean _not_3 = (!_equals_3);
              if (_not_3) {
                return DirtyState.DIRTY;
              }
            }
          }
        }
      }
      _xblockexpression = super.getDirtyState();
    }
    return _xblockexpression;
  }
  
  @Override
  protected void reconcile(final AbstractMapping<T> mapping, final T domainObject, final ReconcileBehavior.UpdateAcceptor acceptor) {
    super.reconcile(mapping, domainObject, acceptor);
  }
}
