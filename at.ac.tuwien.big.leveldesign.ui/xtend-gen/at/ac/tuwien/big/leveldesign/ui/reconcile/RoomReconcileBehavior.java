package at.ac.tuwien.big.leveldesign.ui.reconcile;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram;
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode;
import com.google.common.base.Objects;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.behavior.DirtyState;
import de.fxdiagram.core.behavior.ReconcileBehavior;
import de.fxdiagram.core.model.DomainObjectDescriptor;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.reconcile.DiagramReconcileBehavior;
import de.fxdiagram.mapping.shapes.BaseDiagram;
import javafx.collections.ObservableList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class RoomReconcileBehavior<T extends Object> extends DiagramReconcileBehavior<T> {
  private final int TILE_SIZE = 32;
  
  public RoomReconcileBehavior(final BaseDiagram<T> host) {
    super(host);
  }
  
  @Override
  public DirtyState getDirtyState() {
    DirtyState _xblockexpression = null;
    {
      XDiagram _host = this.getHost();
      DomainObjectDescriptor _domainObjectDescriptor = _host.getDomainObjectDescriptor();
      final Function1<Room, Integer> _function = (Room it) -> {
        return Integer.valueOf(it.getColumns());
      };
      Integer columns = ((IMappedElementDescriptor<Room>) _domainObjectDescriptor).<Integer>withDomainObject(_function);
      XDiagram _host_1 = this.getHost();
      DomainObjectDescriptor _domainObjectDescriptor_1 = _host_1.getDomainObjectDescriptor();
      final Function1<Room, Integer> _function_1 = (Room it) -> {
        return Integer.valueOf(it.getRows());
      };
      Integer rows = ((IMappedElementDescriptor<Room>) _domainObjectDescriptor_1).<Integer>withDomainObject(_function_1);
      if (((((RoomDiagram) this.getHost()).getColumns() != (columns).intValue()) || (((RoomDiagram) this.getHost()).getRows() != (rows).intValue()))) {
        if ((((columns).intValue() == 0) || ((rows).intValue() == 0))) {
          return DirtyState.DANGLING;
        }
        return DirtyState.DIRTY;
      }
      _xblockexpression = super.getDirtyState();
    }
    return _xblockexpression;
  }
  
  @Override
  public void reconcile(final ReconcileBehavior.UpdateAcceptor acceptor) {
    super.reconcile(acceptor);
    XDiagram _host = this.getHost();
    ((RoomDiagram) _host).reconcileBackground();
    XDiagram _host_1 = this.getHost();
    ObservableList<XNode> _nodes = _host_1.getNodes();
    for (final XNode n : _nodes) {
      if ((n instanceof MonsterNode)) {
        IMappedElementDescriptor<Monster> _domainObjectDescriptor = ((MonsterNode) n).getDomainObjectDescriptor();
        final Function1<Monster, Coordinate> _function = (Monster it) -> {
          return it.getPosition();
        };
        Coordinate _withDomainObject = _domainObjectDescriptor.<Coordinate>withDomainObject(_function);
        final CoordinateView domainPosition = Domain2ViewModelConverter.coordinate(_withDomainObject);
        ((MonsterNode) n).setPosition(domainPosition);
        int _column = domainPosition.getColumn();
        int _multiply = (_column * this.TILE_SIZE);
        ((MonsterNode)n).setLayoutX(_multiply);
        int _row = domainPosition.getRow();
        int _multiply_1 = (_row * this.TILE_SIZE);
        ((MonsterNode)n).setLayoutY(_multiply_1);
      } else {
        if ((n instanceof TrapdoorNode)) {
          IMappedElementDescriptor<Trapdoor> _domainObjectDescriptor_1 = ((TrapdoorNode) n).getDomainObjectDescriptor();
          final Function1<Trapdoor, Coordinate> _function_1 = (Trapdoor it) -> {
            return it.getPosition();
          };
          Coordinate _withDomainObject_1 = _domainObjectDescriptor_1.<Coordinate>withDomainObject(_function_1);
          final CoordinateView domainPosition_1 = Domain2ViewModelConverter.coordinate(_withDomainObject_1);
          ((TrapdoorNode) n).setPosition(domainPosition_1);
          int _column_1 = domainPosition_1.getColumn();
          int _multiply_2 = (_column_1 * this.TILE_SIZE);
          ((TrapdoorNode)n).setLayoutX(_multiply_2);
          int _row_1 = domainPosition_1.getRow();
          int _multiply_3 = (_row_1 * this.TILE_SIZE);
          ((TrapdoorNode)n).setLayoutY(_multiply_3);
        } else {
          if ((n instanceof EntryNode)) {
            IMappedElementDescriptor<Entry> _domainObjectDescriptor_2 = ((EntryNode) n).getDomainObjectDescriptor();
            final Function1<Entry, Coordinate> _function_2 = (Entry it) -> {
              return it.getPosition();
            };
            Coordinate _withDomainObject_2 = _domainObjectDescriptor_2.<Coordinate>withDomainObject(_function_2);
            final CoordinateView domainPosition_2 = Domain2ViewModelConverter.coordinate(_withDomainObject_2);
            ((EntryNode) n).setPosition(domainPosition_2);
            int _column_2 = domainPosition_2.getColumn();
            int _multiply_4 = (_column_2 * this.TILE_SIZE);
            ((EntryNode)n).setLayoutX(_multiply_4);
            int _row_2 = domainPosition_2.getRow();
            int _multiply_5 = (_row_2 * this.TILE_SIZE);
            ((EntryNode)n).setLayoutY(_multiply_5);
          } else {
            if ((n instanceof ExitNode)) {
              IMappedElementDescriptor<Exit> _domainObjectDescriptor_3 = ((ExitNode) n).getDomainObjectDescriptor();
              final Function1<Exit, Coordinate> _function_3 = (Exit it) -> {
                return it.getPosition();
              };
              Coordinate _withDomainObject_3 = _domainObjectDescriptor_3.<Coordinate>withDomainObject(_function_3);
              final CoordinateView domainPosition_3 = Domain2ViewModelConverter.coordinate(_withDomainObject_3);
              ((ExitNode) n).setPosition(domainPosition_3);
              int _column_3 = domainPosition_3.getColumn();
              int _multiply_6 = (_column_3 * this.TILE_SIZE);
              ((ExitNode)n).setLayoutX(_multiply_6);
              int _row_3 = domainPosition_3.getRow();
              int _multiply_7 = (_row_3 * this.TILE_SIZE);
              ((ExitNode)n).setLayoutY(_multiply_7);
            } else {
              if ((n instanceof WallNode)) {
                IMappedElementDescriptor<Wall> _domainObjectDescriptor_4 = ((WallNode) n).getDomainObjectDescriptor();
                final Function1<Wall, Integer> _function_4 = (Wall it) -> {
                  Coordinate _from = it.getFrom();
                  return Integer.valueOf(_from.getRow());
                };
                final Integer fromRow = _domainObjectDescriptor_4.<Integer>withDomainObject(_function_4);
                IMappedElementDescriptor<Wall> _domainObjectDescriptor_5 = ((WallNode) n).getDomainObjectDescriptor();
                final Function1<Wall, Integer> _function_5 = (Wall it) -> {
                  Coordinate _from = it.getFrom();
                  return Integer.valueOf(_from.getColumn());
                };
                final Integer fromColumn = _domainObjectDescriptor_5.<Integer>withDomainObject(_function_5);
                IMappedElementDescriptor<Wall> _domainObjectDescriptor_6 = ((WallNode) n).getDomainObjectDescriptor();
                final Function1<Wall, Integer> _function_6 = (Wall it) -> {
                  Coordinate _to = it.getTo();
                  return Integer.valueOf(_to.getRow());
                };
                final Integer toRow = _domainObjectDescriptor_6.<Integer>withDomainObject(_function_6);
                IMappedElementDescriptor<Wall> _domainObjectDescriptor_7 = ((WallNode) n).getDomainObjectDescriptor();
                final Function1<Wall, Integer> _function_7 = (Wall it) -> {
                  Coordinate _to = it.getTo();
                  return Integer.valueOf(_to.getColumn());
                };
                final Integer toColumn = _domainObjectDescriptor_7.<Integer>withDomainObject(_function_7);
                Integer startColumn = null;
                Integer endColumn = null;
                Integer startRow = null;
                Integer endRow = null;
                boolean _equals = Objects.equal(fromRow, toRow);
                if (_equals) {
                  boolean _lessThan = (fromColumn.compareTo(toColumn) < 0);
                  if (_lessThan) {
                    startColumn = fromColumn;
                    endColumn = toColumn;
                  } else {
                    startColumn = toColumn;
                    endColumn = fromColumn;
                  }
                  startRow = fromRow;
                  endRow = fromRow;
                } else {
                  boolean _equals_1 = Objects.equal(fromColumn, toColumn);
                  if (_equals_1) {
                    boolean _lessThan_1 = (fromRow.compareTo(toRow) < 0);
                    if (_lessThan_1) {
                      startRow = fromRow;
                      endRow = toRow;
                    } else {
                      startRow = toRow;
                      endRow = fromRow;
                    }
                    startColumn = fromColumn;
                    endColumn = fromColumn;
                  }
                }
                ((WallNode)n).setLayoutX(((startColumn).intValue() * this.TILE_SIZE));
                ((WallNode)n).setLayoutY(((startRow).intValue() * this.TILE_SIZE));
              }
            }
          }
        }
      }
    }
  }
}
