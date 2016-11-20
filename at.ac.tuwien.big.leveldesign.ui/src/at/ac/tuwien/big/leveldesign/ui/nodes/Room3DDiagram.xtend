package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.shapes.BaseDiagram
import at.ac.tuwien.big.leveldesign.levelDesign.Room
import de.fxdiagram.mapping.IMappedElementDescriptor

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import de.fxdiagram.annotations.properties.ModelNode

@ModelNode
class Room3DDiagram extends BaseDiagram<Room> {
	
	new(IMappedElementDescriptor<Room> descriptor) {
		super(descriptor)
		
	}
	
	override void doActivate() {
		super.doActivate()
		root.currentTool = null
	}
}