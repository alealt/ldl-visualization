package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseNode
import de.fxdiagram.mapping.IMappedElementDescriptor
import javafx.scene.layout.GridPane
import javafx.scene.shape.Rectangle
import javafx.scene.paint.Color
import de.fxdiagram.core.XNode
import de.fxdiagram.mapping.shapes.BaseDiagram
import javafx.scene.Group
import de.fxdiagram.core.extensions.InitializingListListener
import de.fxdiagram.core.XDiagram

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import javafx.scene.image.ImageView
import javafx.scene.image.Image
import javafx.geometry.Rectangle2D
import at.ac.tuwien.big.leveldesign.levelDesign.Room
import at.ac.tuwien.big.leveldesign.levelDesign.Monster
import at.ac.tuwien.big.leveldesign.ui.gamecomponent.Tile
import at.ac.tuwien.big.leveldesign.ui.action.TraversalAction
import javafx.scene.Node
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.MappedResourceLocator.ResourceAdapter
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.model.RoomView
import at.ac.tuwien.big.leveldesign.ui.model.HeroView
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView
import javafx.animation.Animation
import at.ac.tuwien.big.leveldesign.ui.interpreter.Interpreter
import at.ac.tuwien.big.leveldesign.ui.interpreter.GameInterpreter
import java.util.List
import at.ac.tuwien.big.leveldesign.ui.interpreter.Action
import at.ac.tuwien.big.leveldesign.ui.animation.ActionToAnimation
import javafx.animation.SequentialTransition
import javafx.animation.ParallelTransition
import java.util.ArrayList
import de.fxdiagram.lib.simple.SimpleNode
import de.fxdiagram.lib.nodes.RectangleBorderPane
import at.ac.tuwien.big.leveldesign.ui.dialog.DialogHandler
import javafx.scene.layout.BorderPane
import javafx.scene.text.FontWeight
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.control.Label
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.geometry.Insets
import javafx.scene.control.ProgressBar
import at.ac.tuwien.big.leveldesign.ui.interpreter.Fight
import at.ac.tuwien.big.leveldesign.ui.interpretation.AggroRangeInterpretation
import at.ac.tuwien.big.leveldesign.ui.action.AggroRangeAction
import at.ac.tuwien.big.leveldesign.ui.action.StartDifficultyAction
import at.ac.tuwien.big.leveldesign.ui.interpretation.StartDifficultyInterpretation
import at.ac.tuwien.big.leveldesign.ui.action.MonsterStrengthAction
import at.ac.tuwien.big.leveldesign.ui.interpretation.MonsterStrengthInterpretaton
import de.fxdiagram.core.behavior.MoveBehavior
import at.ac.tuwien.big.leveldesign.ui.reconcile.RoomReconcileBehavior
import de.fxdiagram.mapping.reconcile.DiagramReconcileBehavior
import de.fxdiagram.annotations.properties.FxProperty
import de.fxdiagram.annotations.properties.ModelNode

@ModelNode
class RoomDiagram extends BaseDiagram<Room> {
	
	GridPane structuredNodeLayer = new GridPane;
	int i
	int j
	@FxProperty int columns
	@FxProperty int rows
	var ImageView mon
	
	var HeroView hero;
	var RoomView room;
	var List<ImageView> traversalElements;
	
	var IMappedElementDescriptor<Room> descriptor;
	
	var Animation traversalAnimation;
	
	val TILE_SIZE = 32;
	
	var BorderPane specDialog;
	var BorderPane heroHpBox;
	var ProgressBar heroHpBar;
	var double initialHp;
	
	var Node aggroOverlay;
	var Node startDifficultyOverlay;
	
	new(IMappedElementDescriptor<Room> descriptor) {
		super(descriptor)
		this.descriptor= descriptor
		
		layoutOnActivate = false
		
		columns = descriptor.withDomainObject[it.columns]
		rows = descriptor.withDomainObject[it.rows]
		
		for(i = 0; i< columns; i++) {
            for(j = 0; j< rows; j++) {
                structuredNodeLayer.add(new Tile(i,j), i, j);
            }
        }
        getNodeLayer().children.add(structuredNodeLayer)
	}
	
	override void doActivate() {
		super.doActivate()

		//TODO: remove base diagram behavior
		addBehavior(new RoomReconcileBehavior<Room>(this))
	
		root.diagramActionRegistry+= #[new TraversalAction]
		root.diagramActionRegistry+= #[new AggroRangeAction]
		root.diagramActionRegistry+= #[new MonsterStrengthAction]
		root.diagramActionRegistry+= #[new StartDifficultyAction]
				
		nodes.addInitializingListener(new InitializingListListener<XNode>() => [
			add = [				
				initializeGraphics
								
				if(it instanceof MonsterNode) {
					val column = (it as MonsterNode).domainObjectDescriptor.withDomainObject[position.column]
					val row = (it as MonsterNode).domainObjectDescriptor.withDomainObject[position.row]
		
					it.layoutX = column*TILE_SIZE
					it.layoutY = row*TILE_SIZE
				} else if(it instanceof EntryNode) {
					val column = (it as EntryNode).domainObjectDescriptor.withDomainObject[position.column]
					val row = (it as EntryNode).domainObjectDescriptor.withDomainObject[position.row]
					
					it.layoutX = column*TILE_SIZE
					it.layoutY = row*TILE_SIZE
				} else if(it instanceof ExitNode) {
					val column = (it as ExitNode).domainObjectDescriptor.withDomainObject[position.column]
					val row = (it as ExitNode).domainObjectDescriptor.withDomainObject[position.row]
				
					it.layoutX = column*TILE_SIZE
					it.layoutY = row*TILE_SIZE
				} else if(it instanceof TrapdoorNode) {
					val column = (it as TrapdoorNode).domainObjectDescriptor.withDomainObject[position.column]
					val row = (it as TrapdoorNode).domainObjectDescriptor.withDomainObject[position.row]
				
					it.layoutX = column*TILE_SIZE
					it.layoutY = row*TILE_SIZE
				} else if(it instanceof WallNode) {
					val fromRow = (it as WallNode).domainObjectDescriptor.withDomainObject[from.row]
					val fromColumn = (it as WallNode).domainObjectDescriptor.withDomainObject[from.column]
					val toRow = (it as WallNode).domainObjectDescriptor.withDomainObject[to.row]
					val toColumn = (it as WallNode).domainObjectDescriptor.withDomainObject[to.column]
					
					
					var Integer startColumn
					var Integer endColumn
					var Integer startRow
					var Integer endRow
									
					if(fromRow==toRow)  { //horizontal
						if(fromColumn<toColumn) { startColumn = fromColumn; endColumn = toColumn} 
						else { startColumn = toColumn; endColumn = fromColumn}
						startRow = fromRow;
						endRow = fromRow;
					} else if(fromColumn==toColumn)  { //vertical
						if(fromRow<toRow) { startRow = fromRow; endRow = toRow} 
						else { startRow = toRow; endRow = fromRow}
						startColumn = fromColumn;
						endColumn = fromColumn;
					}

					it.layoutX = startColumn*TILE_SIZE
					it.layoutY = startRow*TILE_SIZE
				}	
			]
		])
		
	}
	
	def hideAll() {
		structuredNodeLayer.visible = false;
		for(Node n : nodeLayer.children) {
			n.visible = false
		}
	}
	
	def showAll() {
		structuredNodeLayer.visible = true;
		for(Node n : nodeLayer.children) {
			n.visible = true
		}
	}
	
	def showTraversalDialog() {	
		hideAll();
		specDialog = DialogHandler.getSpecificationForm(this);
		nodeLayer.children.add(specDialog);
	}
	
	def callStart(HeroView specs, int simulationSpeed) {
		room = Domain2ViewModelConverter.room(descriptor.withDomainObject[it]);
		hero = new HeroView(room.entry.position, "Hero", 4000, 10, 1, 5, new Sprite(SpriteType.BALDRIC));	
		
		nodeLayer.children.remove(specDialog)
		nodeLayer.children.add(initHeroHpBox)
		
		showAll();
		
		if(specs==null) return;
        hero.setHp(specs.getHp());
        initialHp = specs.getHp();
        hero.setDamage(specs.getDamage());
        hero.setSpeed(specs.getSpeed());
			
		for(Node n : nodeLayer.children) {
			if(n instanceof MonsterNode) {
				n.visible = false
			}
		}
		
		traversalElements = new ArrayList();	
		//Position all monsters
        for(MonsterView monsterView : room.getMonsters()) {
            nodeLayer.children.add(monsterView.getSprite().getImageView());
            monsterView.getSprite().getImageView().setLayoutX(monsterView.getPosition().getColumn()*TILE_SIZE);
            monsterView.getSprite().getImageView().setLayoutY(monsterView.getPosition().getRow()*TILE_SIZE);
            monsterView.getSprite().durationPerTile = simulationSpeed
            traversalElements.add(monsterView.getSprite().imageView)
        }
		
		
		nodeLayer.children.add(hero.getSprite().getImageView());
        hero.getSprite().getImageView().setLayoutX(hero.getPosition().getColumn()*TILE_SIZE);
        hero.getSprite().getImageView().setLayoutY(hero.getPosition().getRow()*TILE_SIZE);
        hero.getSprite().durationPerTile = simulationSpeed
		traversalElements.add(hero.getSprite().imageView)
		
		
		traversalAnimation = buildAnimation();
        traversalAnimation.play();
		
	}
	
	def stopTraversal() {
		if(traversalAnimation!=null) traversalAnimation.stop();
	
		nodeLayer.children.remove(specDialog)
		nodeLayer.children.remove(heroHpBox);
		
		//Remove imageviews of traversal (hero + monsters)
		for(ImageView i : traversalElements) {
			nodeLayer.children.remove(i)
		}
		
		for(Node n : nodeLayer.children) {
			if(n instanceof MonsterNode) {
				n.visible = true
			}
		}
	}
	
	def Animation buildAnimation() {
        var Interpreter interpreter = new GameInterpreter(room, hero);
        interpreter.process()

        var List<Action> toExecute = interpreter.nextActions();

        var ActionToAnimation actionToAnimation = new ActionToAnimation(hero,this);

        var SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.setAutoReverse(false);

        while(toExecute!=null) {

            var ParallelTransition parallelTransition = new ParallelTransition();
            for(Action a : toExecute) {
                parallelTransition.getChildren().add(actionToAnimation.transform(a));
            }

            toExecute = interpreter.nextActions();
            sequentialTransition.getChildren().add(parallelTransition);
        }

        return sequentialTransition;
    }
    
    
    def BorderPane initHeroHpBox() {		
		heroHpBox = new BorderPane();
		heroHpBox.setStyle("-fx-border-color: black;");
		
		var GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        grid.add(new Text("Hero HP"),0,0);
        
        heroHpBar = new ProgressBar();
        heroHpBar.progress = 1
        grid.add(heroHpBar,1,0);
        
        heroHpBar.style = '-fx-accent: green;'
        
        heroHpBox.setCenter(grid);      
                
        heroHpBox.layoutX = 0;
        heroHpBox.layoutY = -50;
              
        return heroHpBox;
    }
    
    def void updateProgress(Fight action) {
    	heroHpBar.progress = (action.startHealthPointsHero-action.damageTakenHero)/initialHp
    	heroHpBar.style = getProgressStyle(heroHpBar.progress)
    }
    
    def String getProgressStyle(double progress) {
    	if(progress>=0.75) {
    		return '-fx-accent: green;'
    	} else if(progress>=0.5 && progress<0.75) {
    		return '-fx-accent: yellow;'
    	} else if(progress>=0.25 && progress<0.5) {
    		return '-fx-accent: orange;'
    	} 
    	
    	return '-fx-accent: red;'
    }
	
	def showAggroRange() {
		room = Domain2ViewModelConverter.room(descriptor.withDomainObject[it]);		
		aggroOverlay = new AggroRangeInterpretation(room).aggroOverlay
		nodeLayer.children.add(aggroOverlay)

	}
	
	def hideAggroRange() {
		nodeLayer.children.remove(aggroOverlay)
	}
	
	def showStartDifficulty() {
		room = Domain2ViewModelConverter.room(descriptor.withDomainObject[it]);
		startDifficultyOverlay = new StartDifficultyInterpretation(room).startDifficultyOverlay
		nodeLayer.children.add(startDifficultyOverlay)
	}
	
	def hideStartDifficulty() {
		nodeLayer.children.remove(startDifficultyOverlay)
	}
	
	def showMonsterStrength() {
		for(Node n : nodeLayer.children) {
			if(n instanceof MonsterNode) {
				var MonsterView m = Domain2ViewModelConverter.monster((n as MonsterNode).domainObjectDescriptor.withDomainObject[it]);
				var size = new MonsterStrengthInterpretaton().strengthSize(m)
				(n.node as ImageView).setFitHeight(size)
				(n.node as ImageView).setFitWidth(size)
			}
		}
	}
	
	def hideMonsterStrength() {
		for(Node n : nodeLayer.children) {
			if(n instanceof MonsterNode) {
				(n.node as ImageView).setFitHeight(TILE_SIZE)
				(n.node as ImageView).setFitWidth(TILE_SIZE)
			}
		}
	}
	
	def reconcileBackground() {
		var domainColumns = descriptor.withDomainObject[it.columns]
		var domainRows = descriptor.withDomainObject[it.rows]
		
		if(columns!=domainColumns || rows!=domainRows) {	
			structuredNodeLayer.children.clear
			
			columns = domainColumns
			rows = domainRows
			
			for(i = 0; i< columns; i++) {
	            for(j = 0; j< rows; j++) {
	                structuredNodeLayer.add(new Tile(i,j), i, j);
	            }
	        }
		}
	}
}
