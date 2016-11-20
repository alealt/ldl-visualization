package at.ac.tuwien.big.leveldesign.ui.nodes

import javafx.scene.layout.VBox
import javafx.scene.SubScene
import de.fxdiagram.mapping.IMappedElementDescriptor
import de.fxdiagram.mapping.shapes.BaseNode
import at.ac.tuwien.big.leveldesign.levelDesign.Room

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import de.fxdiagram.mapping.shapes.BaseDiagram
import javafx.scene.shape.Rectangle
import javafx.scene.layout.GridPane
import at.ac.tuwien.big.leveldesign.ui.gamecomponent.Tile
import at.ac.tuwien.big.leveldesign.ui.threeD.Room3DInterpretation
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import javafx.scene.Node
import at.ac.tuwien.big.leveldesign.ui.threeD.Room3DReconcileBehavior
import de.fxdiagram.annotations.properties.ModelNode

@ModelNode
class Room3DNode extends BaseNode<Room> {
	
	new(IMappedElementDescriptor<Room> descriptor) {
		super(descriptor)	
	}
	
	override void doActivate() {
		super.doActivate()
		addBehavior(new Room3DReconcileBehavior(this))
	}
	
	override protected createNode() {
		var app = new Room3DInterpretation();
 		app.initialize(Domain2ViewModelConverter.room(domainObjectDescriptor.withDomainObject[it]))
      	app.subscene
	}
	
	def updateNode() {		
		var Node node = createNode()
		
		children.clear();
		nodeProperty.set(node)
		addNodeAsChild(node)
	}
  
}