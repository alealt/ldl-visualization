package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.action.AggroRangeAction;
import at.ac.tuwien.big.leveldesign.ui.action.MonsterStrengthAction;
import at.ac.tuwien.big.leveldesign.ui.action.StartDifficultyAction;
import at.ac.tuwien.big.leveldesign.ui.action.TraversalAction;
import at.ac.tuwien.big.leveldesign.ui.animation.ActionToAnimation;
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType;
import at.ac.tuwien.big.leveldesign.ui.dialog.DialogHandler;
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter;
import at.ac.tuwien.big.leveldesign.ui.gamecomponent.Tile;
import at.ac.tuwien.big.leveldesign.ui.interpretation.AggroRangeInterpretation;
import at.ac.tuwien.big.leveldesign.ui.interpretation.MonsterStrengthInterpretaton;
import at.ac.tuwien.big.leveldesign.ui.interpretation.StartDifficultyInterpretation;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Action;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Fight;
import at.ac.tuwien.big.leveldesign.ui.interpreter.GameInterpreter;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Interpreter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.EntryView;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode;
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode;
import at.ac.tuwien.big.leveldesign.ui.reconcile.RoomReconcileBehavior;
import com.google.common.base.Objects;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.extensions.CoreExtensions;
import de.fxdiagram.core.extensions.InitializingListListener;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.core.tools.actions.DiagramAction;
import de.fxdiagram.core.tools.actions.DiagramActionRegistry;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.shapes.BaseDiagram;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ModelNode
@SuppressWarnings("all")
public class RoomDiagram extends BaseDiagram<Room> {
  private GridPane structuredNodeLayer = new GridPane();
  
  private int i;
  
  private int j;
  
  private ImageView mon;
  
  private HeroView hero;
  
  private RoomView room;
  
  private List<ImageView> traversalElements;
  
  private IMappedElementDescriptor<Room> descriptor;
  
  private Animation traversalAnimation;
  
  private final int TILE_SIZE = 32;
  
  private BorderPane specDialog;
  
  private BorderPane heroHpBox;
  
  private ProgressBar heroHpBar;
  
  private double initialHp;
  
  private Node aggroOverlay;
  
  private Node startDifficultyOverlay;
  
  public RoomDiagram(final IMappedElementDescriptor<Room> descriptor) {
    super(descriptor);
    this.descriptor = descriptor;
    this.setLayoutOnActivate(false);
    final Function1<Room, Integer> _function = (Room it) -> {
      return Integer.valueOf(it.getColumns());
    };
    Integer _withDomainObject = descriptor.<Integer>withDomainObject(_function);
    this.setColumns((_withDomainObject).intValue());
    final Function1<Room, Integer> _function_1 = (Room it) -> {
      return Integer.valueOf(it.getRows());
    };
    Integer _withDomainObject_1 = descriptor.<Integer>withDomainObject(_function_1);
    this.setRows((_withDomainObject_1).intValue());
    for (this.i = 0; (this.i < this.getColumns()); this.i++) {
      for (this.j = 0; (this.j < this.getRows()); this.j++) {
        Tile _tile = new Tile(this.i, this.j);
        this.structuredNodeLayer.add(_tile, this.i, this.j);
      }
    }
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    _children.add(this.structuredNodeLayer);
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    RoomReconcileBehavior<Room> _roomReconcileBehavior = new RoomReconcileBehavior<Room>(this);
    this.addBehavior(_roomReconcileBehavior);
    XRoot _root = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry = _root.getDiagramActionRegistry();
    TraversalAction _traversalAction = new TraversalAction();
    _diagramActionRegistry.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_traversalAction)));
    XRoot _root_1 = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry_1 = _root_1.getDiagramActionRegistry();
    AggroRangeAction _aggroRangeAction = new AggroRangeAction();
    _diagramActionRegistry_1.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_aggroRangeAction)));
    XRoot _root_2 = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry_2 = _root_2.getDiagramActionRegistry();
    MonsterStrengthAction _monsterStrengthAction = new MonsterStrengthAction();
    _diagramActionRegistry_2.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_monsterStrengthAction)));
    XRoot _root_3 = CoreExtensions.getRoot(this);
    DiagramActionRegistry _diagramActionRegistry_3 = _root_3.getDiagramActionRegistry();
    StartDifficultyAction _startDifficultyAction = new StartDifficultyAction();
    _diagramActionRegistry_3.operator_add(Collections.<DiagramAction>unmodifiableList(CollectionLiterals.<DiagramAction>newArrayList(_startDifficultyAction)));
    ObservableList<XNode> _nodes = this.getNodes();
    InitializingListListener<XNode> _initializingListListener = new InitializingListListener<XNode>();
    final Procedure1<InitializingListListener<XNode>> _function = (InitializingListListener<XNode> it) -> {
      final Procedure1<XNode> _function_1 = (XNode it_1) -> {
        it_1.initializeGraphics();
        if ((it_1 instanceof MonsterNode)) {
          IMappedElementDescriptor<Monster> _domainObjectDescriptor = ((MonsterNode) it_1).getDomainObjectDescriptor();
          final Function1<Monster, Integer> _function_2 = (Monster it_2) -> {
            Coordinate _position = it_2.getPosition();
            return Integer.valueOf(_position.getColumn());
          };
          final Integer column = _domainObjectDescriptor.<Integer>withDomainObject(_function_2);
          IMappedElementDescriptor<Monster> _domainObjectDescriptor_1 = ((MonsterNode) it_1).getDomainObjectDescriptor();
          final Function1<Monster, Integer> _function_3 = (Monster it_2) -> {
            Coordinate _position = it_2.getPosition();
            return Integer.valueOf(_position.getRow());
          };
          final Integer row = _domainObjectDescriptor_1.<Integer>withDomainObject(_function_3);
          ((MonsterNode)it_1).setLayoutX(((column).intValue() * this.TILE_SIZE));
          ((MonsterNode)it_1).setLayoutY(((row).intValue() * this.TILE_SIZE));
        } else {
          if ((it_1 instanceof EntryNode)) {
            IMappedElementDescriptor<Entry> _domainObjectDescriptor_2 = ((EntryNode) it_1).getDomainObjectDescriptor();
            final Function1<Entry, Integer> _function_4 = (Entry it_2) -> {
              Coordinate _position = it_2.getPosition();
              return Integer.valueOf(_position.getColumn());
            };
            final Integer column_1 = _domainObjectDescriptor_2.<Integer>withDomainObject(_function_4);
            IMappedElementDescriptor<Entry> _domainObjectDescriptor_3 = ((EntryNode) it_1).getDomainObjectDescriptor();
            final Function1<Entry, Integer> _function_5 = (Entry it_2) -> {
              Coordinate _position = it_2.getPosition();
              return Integer.valueOf(_position.getRow());
            };
            final Integer row_1 = _domainObjectDescriptor_3.<Integer>withDomainObject(_function_5);
            ((EntryNode)it_1).setLayoutX(((column_1).intValue() * this.TILE_SIZE));
            ((EntryNode)it_1).setLayoutY(((row_1).intValue() * this.TILE_SIZE));
          } else {
            if ((it_1 instanceof ExitNode)) {
              IMappedElementDescriptor<Exit> _domainObjectDescriptor_4 = ((ExitNode) it_1).getDomainObjectDescriptor();
              final Function1<Exit, Integer> _function_6 = (Exit it_2) -> {
                Coordinate _position = it_2.getPosition();
                return Integer.valueOf(_position.getColumn());
              };
              final Integer column_2 = _domainObjectDescriptor_4.<Integer>withDomainObject(_function_6);
              IMappedElementDescriptor<Exit> _domainObjectDescriptor_5 = ((ExitNode) it_1).getDomainObjectDescriptor();
              final Function1<Exit, Integer> _function_7 = (Exit it_2) -> {
                Coordinate _position = it_2.getPosition();
                return Integer.valueOf(_position.getRow());
              };
              final Integer row_2 = _domainObjectDescriptor_5.<Integer>withDomainObject(_function_7);
              ((ExitNode)it_1).setLayoutX(((column_2).intValue() * this.TILE_SIZE));
              ((ExitNode)it_1).setLayoutY(((row_2).intValue() * this.TILE_SIZE));
            } else {
              if ((it_1 instanceof TrapdoorNode)) {
                IMappedElementDescriptor<Trapdoor> _domainObjectDescriptor_6 = ((TrapdoorNode) it_1).getDomainObjectDescriptor();
                final Function1<Trapdoor, Integer> _function_8 = (Trapdoor it_2) -> {
                  Coordinate _position = it_2.getPosition();
                  return Integer.valueOf(_position.getColumn());
                };
                final Integer column_3 = _domainObjectDescriptor_6.<Integer>withDomainObject(_function_8);
                IMappedElementDescriptor<Trapdoor> _domainObjectDescriptor_7 = ((TrapdoorNode) it_1).getDomainObjectDescriptor();
                final Function1<Trapdoor, Integer> _function_9 = (Trapdoor it_2) -> {
                  Coordinate _position = it_2.getPosition();
                  return Integer.valueOf(_position.getRow());
                };
                final Integer row_3 = _domainObjectDescriptor_7.<Integer>withDomainObject(_function_9);
                ((TrapdoorNode)it_1).setLayoutX(((column_3).intValue() * this.TILE_SIZE));
                ((TrapdoorNode)it_1).setLayoutY(((row_3).intValue() * this.TILE_SIZE));
              } else {
                if ((it_1 instanceof WallNode)) {
                  IMappedElementDescriptor<Wall> _domainObjectDescriptor_8 = ((WallNode) it_1).getDomainObjectDescriptor();
                  final Function1<Wall, Integer> _function_10 = (Wall it_2) -> {
                    Coordinate _from = it_2.getFrom();
                    return Integer.valueOf(_from.getRow());
                  };
                  final Integer fromRow = _domainObjectDescriptor_8.<Integer>withDomainObject(_function_10);
                  IMappedElementDescriptor<Wall> _domainObjectDescriptor_9 = ((WallNode) it_1).getDomainObjectDescriptor();
                  final Function1<Wall, Integer> _function_11 = (Wall it_2) -> {
                    Coordinate _from = it_2.getFrom();
                    return Integer.valueOf(_from.getColumn());
                  };
                  final Integer fromColumn = _domainObjectDescriptor_9.<Integer>withDomainObject(_function_11);
                  IMappedElementDescriptor<Wall> _domainObjectDescriptor_10 = ((WallNode) it_1).getDomainObjectDescriptor();
                  final Function1<Wall, Integer> _function_12 = (Wall it_2) -> {
                    Coordinate _to = it_2.getTo();
                    return Integer.valueOf(_to.getRow());
                  };
                  final Integer toRow = _domainObjectDescriptor_10.<Integer>withDomainObject(_function_12);
                  IMappedElementDescriptor<Wall> _domainObjectDescriptor_11 = ((WallNode) it_1).getDomainObjectDescriptor();
                  final Function1<Wall, Integer> _function_13 = (Wall it_2) -> {
                    Coordinate _to = it_2.getTo();
                    return Integer.valueOf(_to.getColumn());
                  };
                  final Integer toColumn = _domainObjectDescriptor_11.<Integer>withDomainObject(_function_13);
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
                  ((WallNode)it_1).setLayoutX(((startColumn).intValue() * this.TILE_SIZE));
                  ((WallNode)it_1).setLayoutY(((startRow).intValue() * this.TILE_SIZE));
                }
              }
            }
          }
        }
      };
      it.setAdd(_function_1);
    };
    InitializingListListener<XNode> _doubleArrow = ObjectExtensions.<InitializingListListener<XNode>>operator_doubleArrow(_initializingListListener, _function);
    CoreExtensions.<XNode>addInitializingListener(_nodes, _doubleArrow);
  }
  
  public void hideAll() {
    this.structuredNodeLayer.setVisible(false);
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      n.setVisible(false);
    }
  }
  
  public void showAll() {
    this.structuredNodeLayer.setVisible(true);
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      n.setVisible(true);
    }
  }
  
  public boolean showTraversalDialog() {
    boolean _xblockexpression = false;
    {
      this.hideAll();
      BorderPane _specificationForm = DialogHandler.getSpecificationForm(this);
      this.specDialog = _specificationForm;
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _xblockexpression = _children.add(this.specDialog);
    }
    return _xblockexpression;
  }
  
  public void callStart(final HeroView specs, final int simulationSpeed) {
    final Function1<Room, Room> _function = (Room it) -> {
      return it;
    };
    Room _withDomainObject = this.descriptor.<Room>withDomainObject(_function);
    RoomView _room = Domain2ViewModelConverter.room(_withDomainObject);
    this.room = _room;
    EntryView _entry = this.room.getEntry();
    CoordinateView _position = _entry.getPosition();
    Sprite _sprite = new Sprite(SpriteType.BALDRIC);
    HeroView _heroView = new HeroView(_position, "Hero", 4000, 10, 1, 5, _sprite);
    this.hero = _heroView;
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    _children.remove(this.specDialog);
    Group _nodeLayer_1 = this.getNodeLayer();
    ObservableList<Node> _children_1 = _nodeLayer_1.getChildren();
    BorderPane _initHeroHpBox = this.initHeroHpBox();
    _children_1.add(_initHeroHpBox);
    this.showAll();
    boolean _equals = Objects.equal(specs, null);
    if (_equals) {
      return;
    }
    double _hp = specs.getHp();
    this.hero.setHp(_hp);
    double _hp_1 = specs.getHp();
    this.initialHp = _hp_1;
    int _damage = specs.getDamage();
    this.hero.setDamage(_damage);
    double _speed = specs.getSpeed();
    this.hero.setSpeed(_speed);
    Group _nodeLayer_2 = this.getNodeLayer();
    ObservableList<Node> _children_2 = _nodeLayer_2.getChildren();
    for (final Node n : _children_2) {
      if ((n instanceof MonsterNode)) {
        ((MonsterNode)n).setVisible(false);
      }
    }
    ArrayList<ImageView> _arrayList = new ArrayList<ImageView>();
    this.traversalElements = _arrayList;
    List<MonsterView> _monsters = this.room.getMonsters();
    for (final MonsterView monsterView : _monsters) {
      {
        Group _nodeLayer_3 = this.getNodeLayer();
        ObservableList<Node> _children_3 = _nodeLayer_3.getChildren();
        Sprite _sprite_1 = monsterView.getSprite();
        ImageView _imageView = _sprite_1.getImageView();
        _children_3.add(_imageView);
        Sprite _sprite_2 = monsterView.getSprite();
        ImageView _imageView_1 = _sprite_2.getImageView();
        CoordinateView _position_1 = monsterView.getPosition();
        int _column = _position_1.getColumn();
        int _multiply = (_column * this.TILE_SIZE);
        _imageView_1.setLayoutX(_multiply);
        Sprite _sprite_3 = monsterView.getSprite();
        ImageView _imageView_2 = _sprite_3.getImageView();
        CoordinateView _position_2 = monsterView.getPosition();
        int _row = _position_2.getRow();
        int _multiply_1 = (_row * this.TILE_SIZE);
        _imageView_2.setLayoutY(_multiply_1);
        Sprite _sprite_4 = monsterView.getSprite();
        _sprite_4.setDurationPerTile(simulationSpeed);
        Sprite _sprite_5 = monsterView.getSprite();
        ImageView _imageView_3 = _sprite_5.getImageView();
        this.traversalElements.add(_imageView_3);
      }
    }
    Group _nodeLayer_3 = this.getNodeLayer();
    ObservableList<Node> _children_3 = _nodeLayer_3.getChildren();
    Sprite _sprite_1 = this.hero.getSprite();
    ImageView _imageView = _sprite_1.getImageView();
    _children_3.add(_imageView);
    Sprite _sprite_2 = this.hero.getSprite();
    ImageView _imageView_1 = _sprite_2.getImageView();
    CoordinateView _position_1 = this.hero.getPosition();
    int _column = _position_1.getColumn();
    int _multiply = (_column * this.TILE_SIZE);
    _imageView_1.setLayoutX(_multiply);
    Sprite _sprite_3 = this.hero.getSprite();
    ImageView _imageView_2 = _sprite_3.getImageView();
    CoordinateView _position_2 = this.hero.getPosition();
    int _row = _position_2.getRow();
    int _multiply_1 = (_row * this.TILE_SIZE);
    _imageView_2.setLayoutY(_multiply_1);
    Sprite _sprite_4 = this.hero.getSprite();
    _sprite_4.setDurationPerTile(simulationSpeed);
    Sprite _sprite_5 = this.hero.getSprite();
    ImageView _imageView_3 = _sprite_5.getImageView();
    this.traversalElements.add(_imageView_3);
    Animation _buildAnimation = this.buildAnimation();
    this.traversalAnimation = _buildAnimation;
    this.traversalAnimation.play();
  }
  
  public void stopTraversal() {
    boolean _notEquals = (!Objects.equal(this.traversalAnimation, null));
    if (_notEquals) {
      this.traversalAnimation.stop();
    }
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    _children.remove(this.specDialog);
    Group _nodeLayer_1 = this.getNodeLayer();
    ObservableList<Node> _children_1 = _nodeLayer_1.getChildren();
    _children_1.remove(this.heroHpBox);
    for (final ImageView i : this.traversalElements) {
      Group _nodeLayer_2 = this.getNodeLayer();
      ObservableList<Node> _children_2 = _nodeLayer_2.getChildren();
      _children_2.remove(i);
    }
    Group _nodeLayer_3 = this.getNodeLayer();
    ObservableList<Node> _children_3 = _nodeLayer_3.getChildren();
    for (final Node n : _children_3) {
      if ((n instanceof MonsterNode)) {
        ((MonsterNode)n).setVisible(true);
      }
    }
  }
  
  public Animation buildAnimation() {
    Interpreter interpreter = new GameInterpreter(this.room, this.hero);
    interpreter.process();
    List<Action> toExecute = interpreter.nextActions();
    ActionToAnimation actionToAnimation = new ActionToAnimation(this.hero, this);
    SequentialTransition sequentialTransition = new SequentialTransition();
    sequentialTransition.setAutoReverse(false);
    while ((!Objects.equal(toExecute, null))) {
      {
        ParallelTransition parallelTransition = new ParallelTransition();
        for (final Action a : toExecute) {
          ObservableList<Animation> _children = parallelTransition.getChildren();
          Animation _transform = actionToAnimation.transform(a);
          _children.add(_transform);
        }
        List<Action> _nextActions = interpreter.nextActions();
        toExecute = _nextActions;
        ObservableList<Animation> _children_1 = sequentialTransition.getChildren();
        _children_1.add(parallelTransition);
      }
    }
    return sequentialTransition;
  }
  
  public BorderPane initHeroHpBox() {
    BorderPane _borderPane = new BorderPane();
    this.heroHpBox = _borderPane;
    this.heroHpBox.setStyle("-fx-border-color: black;");
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    Insets _insets = new Insets(10, 10, 10, 10);
    grid.setPadding(_insets);
    Text _text = new Text("Hero HP");
    grid.add(_text, 0, 0);
    ProgressBar _progressBar = new ProgressBar();
    this.heroHpBar = _progressBar;
    this.heroHpBar.setProgress(1);
    grid.add(this.heroHpBar, 1, 0);
    this.heroHpBar.setStyle("-fx-accent: green;");
    this.heroHpBox.setCenter(grid);
    this.heroHpBox.setLayoutX(0);
    this.heroHpBox.setLayoutY((-50));
    return this.heroHpBox;
  }
  
  public void updateProgress(final Fight action) {
    double _startHealthPointsHero = action.getStartHealthPointsHero();
    double _damageTakenHero = action.getDamageTakenHero();
    double _minus = (_startHealthPointsHero - _damageTakenHero);
    double _divide = (_minus / this.initialHp);
    this.heroHpBar.setProgress(_divide);
    double _progress = this.heroHpBar.getProgress();
    String _progressStyle = this.getProgressStyle(_progress);
    this.heroHpBar.setStyle(_progressStyle);
  }
  
  public String getProgressStyle(final double progress) {
    if ((progress >= 0.75)) {
      return "-fx-accent: green;";
    } else {
      if (((progress >= 0.5) && (progress < 0.75))) {
        return "-fx-accent: yellow;";
      } else {
        if (((progress >= 0.25) && (progress < 0.5))) {
          return "-fx-accent: orange;";
        }
      }
    }
    return "-fx-accent: red;";
  }
  
  public boolean showAggroRange() {
    boolean _xblockexpression = false;
    {
      final Function1<Room, Room> _function = (Room it) -> {
        return it;
      };
      Room _withDomainObject = this.descriptor.<Room>withDomainObject(_function);
      RoomView _room = Domain2ViewModelConverter.room(_withDomainObject);
      this.room = _room;
      AggroRangeInterpretation _aggroRangeInterpretation = new AggroRangeInterpretation(this.room);
      Node _aggroOverlay = _aggroRangeInterpretation.getAggroOverlay();
      this.aggroOverlay = _aggroOverlay;
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _xblockexpression = _children.add(this.aggroOverlay);
    }
    return _xblockexpression;
  }
  
  public boolean hideAggroRange() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    return _children.remove(this.aggroOverlay);
  }
  
  public boolean showStartDifficulty() {
    boolean _xblockexpression = false;
    {
      final Function1<Room, Room> _function = (Room it) -> {
        return it;
      };
      Room _withDomainObject = this.descriptor.<Room>withDomainObject(_function);
      RoomView _room = Domain2ViewModelConverter.room(_withDomainObject);
      this.room = _room;
      StartDifficultyInterpretation _startDifficultyInterpretation = new StartDifficultyInterpretation(this.room);
      Node _startDifficultyOverlay = _startDifficultyInterpretation.getStartDifficultyOverlay();
      this.startDifficultyOverlay = _startDifficultyOverlay;
      Group _nodeLayer = this.getNodeLayer();
      ObservableList<Node> _children = _nodeLayer.getChildren();
      _xblockexpression = _children.add(this.startDifficultyOverlay);
    }
    return _xblockexpression;
  }
  
  public boolean hideStartDifficulty() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    return _children.remove(this.startDifficultyOverlay);
  }
  
  public void showMonsterStrength() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      if ((n instanceof MonsterNode)) {
        IMappedElementDescriptor<Monster> _domainObjectDescriptor = ((MonsterNode) n).getDomainObjectDescriptor();
        final Function1<Monster, Monster> _function = (Monster it) -> {
          return it;
        };
        Monster _withDomainObject = _domainObjectDescriptor.<Monster>withDomainObject(_function);
        MonsterView m = Domain2ViewModelConverter.monster(_withDomainObject);
        MonsterStrengthInterpretaton _monsterStrengthInterpretaton = new MonsterStrengthInterpretaton();
        double size = _monsterStrengthInterpretaton.strengthSize(m);
        Node _node = ((MonsterNode)n).getNode();
        ((ImageView) _node).setFitHeight(size);
        Node _node_1 = ((MonsterNode)n).getNode();
        ((ImageView) _node_1).setFitWidth(size);
      }
    }
  }
  
  public void hideMonsterStrength() {
    Group _nodeLayer = this.getNodeLayer();
    ObservableList<Node> _children = _nodeLayer.getChildren();
    for (final Node n : _children) {
      if ((n instanceof MonsterNode)) {
        Node _node = ((MonsterNode)n).getNode();
        ((ImageView) _node).setFitHeight(this.TILE_SIZE);
        Node _node_1 = ((MonsterNode)n).getNode();
        ((ImageView) _node_1).setFitWidth(this.TILE_SIZE);
      }
    }
  }
  
  public void reconcileBackground() {
    final Function1<Room, Integer> _function = (Room it) -> {
      return Integer.valueOf(it.getColumns());
    };
    Integer domainColumns = this.descriptor.<Integer>withDomainObject(_function);
    final Function1<Room, Integer> _function_1 = (Room it) -> {
      return Integer.valueOf(it.getRows());
    };
    Integer domainRows = this.descriptor.<Integer>withDomainObject(_function_1);
    if (((this.getColumns() != (domainColumns).intValue()) || (this.getRows() != (domainRows).intValue()))) {
      ObservableList<Node> _children = this.structuredNodeLayer.getChildren();
      _children.clear();
      this.setColumns((domainColumns).intValue());
      this.setRows((domainRows).intValue());
      for (this.i = 0; (this.i < this.getColumns()); this.i++) {
        for (this.j = 0; (this.j < this.getRows()); this.j++) {
          Tile _tile = new Tile(this.i, this.j);
          this.structuredNodeLayer.add(_tile, this.i, this.j);
        }
      }
    }
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public RoomDiagram() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public String toString() {
    return ToString.toString(this);
  }
  
  private SimpleIntegerProperty columnsProperty = new SimpleIntegerProperty(this, "columns");
  
  public int getColumns() {
    return this.columnsProperty.get();
  }
  
  public void setColumns(final int columns) {
    this.columnsProperty.set(columns);
  }
  
  public IntegerProperty columnsProperty() {
    return this.columnsProperty;
  }
  
  private SimpleIntegerProperty rowsProperty = new SimpleIntegerProperty(this, "rows");
  
  public int getRows() {
    return this.rowsProperty.get();
  }
  
  public void setRows(final int rows) {
    this.rowsProperty.set(rows);
  }
  
  public IntegerProperty rowsProperty() {
    return this.rowsProperty;
  }
}
