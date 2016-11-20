package at.ac.tuwien.big.leveldesign.ui.config;

import at.ac.tuwien.big.leveldesign.levelDesign.Connection;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Level;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.LevelDiagram;
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DDiagram;
import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram;
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode;
import de.fxdiagram.core.XDiagram;
import de.fxdiagram.core.XNode;
import de.fxdiagram.eclipse.xtext.mapping.AbstractXtextDiagramConfig;
import de.fxdiagram.lib.simple.OpenableDiagramNode;
import de.fxdiagram.mapping.ConnectionLabelMapping;
import de.fxdiagram.mapping.ConnectionMapping;
import de.fxdiagram.mapping.DiagramMapping;
import de.fxdiagram.mapping.DiagramMappingCall;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.MappingAcceptor;
import de.fxdiagram.mapping.NodeHeadingMapping;
import de.fxdiagram.mapping.NodeMapping;
import de.fxdiagram.mapping.shapes.BaseDiagramNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class LevelDiagramConfig extends AbstractXtextDiagramConfig {
  private final DiagramMapping<Level> levelDiagram = new DiagramMapping<Level>(this, "levelDiagram", "Level") {
    @Override
    public XDiagram createDiagram(final IMappedElementDescriptor<Level> descriptor) {
      return new LevelDiagram(descriptor);
    }
    
    @Override
    public void calls() {
      final Function1<Level, Iterable<? extends Room>> _function = (Level it) -> {
        return it.getRooms();
      };
      this.<Room>nodeForEach(LevelDiagramConfig.this.roomNode, _function);
      final Function1<Level, Iterable<? extends Connection>> _function_1 = (Level it) -> {
        EList<Room> _rooms = it.getRooms();
        final Function1<Room, Connection> _function_2 = (Room it_1) -> {
          return it_1.getExitConnection();
        };
        return ListExtensions.<Room, Connection>map(_rooms, _function_2);
      };
      this.<Connection>connectionForEach(LevelDiagramConfig.this.roomConnection, _function_1);
    }
    
    @Override
    public String getDefaultFilePath(final Level element) {
      return LevelDiagramConfig.this.getFilePath(element);
    }
  };
  
  private final NodeMapping<Room> roomNode = new NodeMapping<Room>(this, "roomNode", "RoomNode") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Room> descriptor) {
      return new OpenableDiagramNode(descriptor);
    }
    
    @Override
    protected void calls() {
      final Function1<Room, Room> _function = (Room it) -> {
        return it;
      };
      this.<Room>labelFor(LevelDiagramConfig.this.roomNodeName, _function);
      final Function1<Room, Room> _function_1 = (Room it) -> {
        return it;
      };
      DiagramMappingCall<?, Room> _nestedDiagramFor = this.<Room>nestedDiagramFor(LevelDiagramConfig.this.roomDiagram, _function_1);
      _nestedDiagramFor.onOpen();
    }
  };
  
  private final DiagramMapping<Room> room3DDiagram = new DiagramMapping<Room>(this, "room3DDiagram", "Room3DDiagram") {
    @Override
    public XDiagram createDiagram(final IMappedElementDescriptor<Room> descriptor) {
      return new Room3DDiagram(descriptor);
    }
    
    @Override
    public void calls() {
      final Function1<Room, Room> _function = (Room it) -> {
        return it;
      };
      this.<Room>nodeFor(LevelDiagramConfig.this.room3DNode, _function);
    }
    
    @Override
    public String getDefaultFilePath(final Room element) {
      return LevelDiagramConfig.this.getFilePath(element);
    }
  };
  
  private final NodeMapping<Room> room3DNode = new NodeMapping<Room>(this, "room3DNode", "Room3DNode") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Room> descriptor) {
      return new Room3DNode(descriptor);
    }
  };
  
  private final DiagramMapping<Room> roomDiagram = new DiagramMapping<Room>(this, "roomDiagram", "RoomDiagram") {
    @Override
    public XDiagram createDiagram(final IMappedElementDescriptor<Room> descriptor) {
      return new RoomDiagram(descriptor);
    }
    
    @Override
    public void calls() {
      final Function1<Room, Iterable<? extends Monster>> _function = (Room it) -> {
        return it.getMonsters();
      };
      this.<Monster>nodeForEach(LevelDiagramConfig.this.monsterNode, _function);
      final Function1<Room, Iterable<? extends Wall>> _function_1 = (Room it) -> {
        return it.getWalls();
      };
      this.<Wall>nodeForEach(LevelDiagramConfig.this.wallNode, _function_1);
      final Function1<Room, Iterable<? extends Trapdoor>> _function_2 = (Room it) -> {
        return it.getTrapdoors();
      };
      this.<Trapdoor>nodeForEach(LevelDiagramConfig.this.trapdoorNode, _function_2);
      final Function1<Room, Entry> _function_3 = (Room it) -> {
        return it.getEntry();
      };
      this.<Entry>nodeFor(LevelDiagramConfig.this.entryNode, _function_3);
      final Function1<Room, Exit> _function_4 = (Room it) -> {
        return it.getExit();
      };
      this.<Exit>nodeFor(LevelDiagramConfig.this.exitNode, _function_4);
    }
    
    @Override
    public String getDefaultFilePath(final Room element) {
      return LevelDiagramConfig.this.getFilePath(element);
    }
  };
  
  private final NodeHeadingMapping<Room> roomNodeName = new NodeHeadingMapping<Room>(this, BaseDiagramNode.NODE_HEADING) {
    @Override
    public String getText(final Room element) {
      return element.getName();
    }
  };
  
  private final NodeMapping<Monster> monsterNode = new NodeMapping<Monster>(this, "monsterNode", "Monster") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Monster> descriptor) {
      return new MonsterNode(descriptor);
    }
    
    @Override
    protected void calls() {
    }
  };
  
  private final NodeMapping<Wall> wallNode = new NodeMapping<Wall>(this, "wallNode", "Wall") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Wall> descriptor) {
      return new WallNode(descriptor);
    }
    
    @Override
    protected void calls() {
    }
  };
  
  private final NodeMapping<Entry> entryNode = new NodeMapping<Entry>(this, "entryNode", "Entry") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Entry> descriptor) {
      return new EntryNode(descriptor);
    }
    
    @Override
    protected void calls() {
    }
  };
  
  private final NodeMapping<Exit> exitNode = new NodeMapping<Exit>(this, "exitNode", "Exit") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Exit> descriptor) {
      return new ExitNode(descriptor);
    }
    
    @Override
    protected void calls() {
    }
  };
  
  private final NodeMapping<Trapdoor> trapdoorNode = new NodeMapping<Trapdoor>(this, "trapdoorNode", "Trapdoor") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<Trapdoor> descriptor) {
      return new TrapdoorNode(descriptor);
    }
    
    @Override
    protected void calls() {
    }
  };
  
  private final ConnectionMapping<Connection> roomConnection = new ConnectionMapping<Connection>(this, "roomConnection", "Connection") {
    @Override
    protected void calls() {
      final Function1<Connection, Connection> _function = (Connection it) -> {
        return it;
      };
      this.<Connection>labelFor(LevelDiagramConfig.this.connectionLabel, _function);
      final Function1<Connection, Room> _function_1 = (Connection it) -> {
        EObject _eContainer = it.eContainer();
        return ((Room) _eContainer);
      };
      this.<Room>source(LevelDiagramConfig.this.roomNode, _function_1);
      final Function1<Connection, Room> _function_2 = (Connection it) -> {
        return it.getNextRoom();
      };
      this.<Room>target(LevelDiagramConfig.this.roomNode, _function_2);
    }
  };
  
  private final ConnectionLabelMapping<Connection> connectionLabel = new ConnectionLabelMapping<Connection>(this, "connectionLabel") {
    @Override
    public String getText(final Connection it) {
      return it.getType();
    }
  };
  
  @Override
  protected <ARG extends Object> void entryCalls(final ARG domainArgument, @Extension final MappingAcceptor<ARG> acceptor) {
    boolean _matched = false;
    if (domainArgument instanceof Level) {
      _matched=true;
      final Function1<ARG, Level> _function = (ARG it) -> {
        return EcoreUtil2.<Level>getContainerOfType(((Level)domainArgument), Level.class);
      };
      acceptor.<Level>add(this.levelDiagram, _function);
    }
    if (!_matched) {
      if (domainArgument instanceof Room) {
        _matched=true;
        final Function1<ARG, Level> _function = (ARG it) -> {
          return EcoreUtil2.<Level>getContainerOfType(((Room)domainArgument), Level.class);
        };
        acceptor.<Level>add(this.levelDiagram, _function);
        final Function1<ARG, Room> _function_1 = (ARG it) -> {
          return ((Room)((ARG)domainArgument));
        };
        acceptor.<Room>add(this.roomNode, _function_1);
        final Function1<ARG, Room> _function_2 = (ARG it) -> {
          return ((Room)((ARG)domainArgument));
        };
        acceptor.<Room>add(this.roomDiagram, _function_2);
        final Function1<ARG, Room> _function_3 = (ARG it) -> {
          return ((Room)((ARG)domainArgument));
        };
        acceptor.<Room>add(this.room3DDiagram, _function_3);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Connection) {
        _matched=true;
        final Function1<ARG, Level> _function = (ARG it) -> {
          return EcoreUtil2.<Level>getContainerOfType(((Connection)domainArgument), Level.class);
        };
        acceptor.<Level>add(this.levelDiagram, _function);
        final Function1<ARG, Connection> _function_1 = (ARG it) -> {
          return ((Connection)((ARG)domainArgument));
        };
        acceptor.<Connection>add(this.roomConnection, _function_1);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Monster) {
        _matched=true;
        final Function1<ARG, Monster> _function = (ARG it) -> {
          return ((Monster)((ARG)domainArgument));
        };
        acceptor.<Monster>add(this.monsterNode, _function);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Wall) {
        _matched=true;
        final Function1<ARG, Wall> _function = (ARG it) -> {
          return ((Wall)((ARG)domainArgument));
        };
        acceptor.<Wall>add(this.wallNode, _function);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Trapdoor) {
        _matched=true;
        final Function1<ARG, Trapdoor> _function = (ARG it) -> {
          return ((Trapdoor)((ARG)domainArgument));
        };
        acceptor.<Trapdoor>add(this.trapdoorNode, _function);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Entry) {
        _matched=true;
        final Function1<ARG, Entry> _function = (ARG it) -> {
          return ((Entry)((ARG)domainArgument));
        };
        acceptor.<Entry>add(this.entryNode, _function);
      }
    }
    if (!_matched) {
      if (domainArgument instanceof Exit) {
        _matched=true;
        final Function1<ARG, Exit> _function = (ARG it) -> {
          return ((Exit)((ARG)domainArgument));
        };
        acceptor.<Exit>add(this.exitNode, _function);
      }
    }
  }
}
