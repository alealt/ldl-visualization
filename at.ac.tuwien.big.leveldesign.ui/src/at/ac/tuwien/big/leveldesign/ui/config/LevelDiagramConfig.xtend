package at.ac.tuwien.big.leveldesign.ui.config

import de.fxdiagram.eclipse.xtext.mapping.AbstractXtextDiagramConfig
import de.fxdiagram.mapping.ConnectionMapping
import de.fxdiagram.mapping.DiagramMapping
import de.fxdiagram.mapping.IMappedElementDescriptor
import de.fxdiagram.mapping.MappingAcceptor
import de.fxdiagram.mapping.NodeHeadingMapping
import de.fxdiagram.mapping.NodeMapping

import static extension org.eclipse.xtext.EcoreUtil2.*
import de.fxdiagram.mapping.shapes.BaseDiagramNode
import de.fxdiagram.core.XDiagram
import de.fxdiagram.lib.simple.LevelOfDetailDiagramNode
import at.ac.tuwien.big.leveldesign.levelDesign.Level
import at.ac.tuwien.big.leveldesign.levelDesign.Room
import at.ac.tuwien.big.leveldesign.levelDesign.Monster
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram
import at.ac.tuwien.big.leveldesign.levelDesign.Wall
import at.ac.tuwien.big.leveldesign.levelDesign.Entry
import at.ac.tuwien.big.leveldesign.ui.nodes.WallNode
import at.ac.tuwien.big.leveldesign.ui.nodes.MonsterNode
import at.ac.tuwien.big.leveldesign.ui.nodes.EntryNode
import at.ac.tuwien.big.leveldesign.ui.nodes.ExitNode
import at.ac.tuwien.big.leveldesign.levelDesign.Exit
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor
import at.ac.tuwien.big.leveldesign.ui.nodes.TrapdoorNode
import at.ac.tuwien.big.leveldesign.levelDesign.Connection
import de.fxdiagram.lib.simple.OpenableDiagramNode

import static extension de.fxdiagram.core.extensions.ButtonExtensions.*
import de.fxdiagram.mapping.ConnectionLabelMapping
import at.ac.tuwien.big.leveldesign.ui.nodes.LevelDiagram
import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DNode
import at.ac.tuwien.big.leveldesign.ui.nodes.Room3DDiagram

class LevelDiagramConfig extends AbstractXtextDiagramConfig {
	
	 // fields to define mappings (1)
	val levelDiagram = new DiagramMapping<Level>(this, 'levelDiagram', 'Level') {
		
		override XDiagram createDiagram(IMappedElementDescriptor<Level> descriptor) { 
			new LevelDiagram(descriptor)
		}
		
		override calls() {
			// when adding a level diagram automatically add a node for each room
			// and a connection for each transition
			roomNode.nodeForEach[rooms]
			roomConnection.connectionForEach[rooms.map[exitConnection]]  
		}		
		
		override getDefaultFilePath(Level element) {
			element.filePath
		}
	}
	
	val roomNode = new NodeMapping<Room>(this, 'roomNode', 'RoomNode') {
		override createNode(IMappedElementDescriptor<Room> descriptor) {
			new OpenableDiagramNode(descriptor)
		}
		
		override protected calls() {
			roomNodeName.labelFor[it]
			roomDiagram.nestedDiagramFor[it].onOpen
		}
	}
	
	val room3DDiagram= new DiagramMapping<Room>(this, 'room3DDiagram', 'Room3DDiagram') {
		
		override XDiagram createDiagram(IMappedElementDescriptor<Room> descriptor) { 
			new Room3DDiagram(descriptor)
		}
		
		override calls() {
			room3DNode.nodeFor[it]
		}		
		
		override getDefaultFilePath(Room element) {
			element.filePath
		}
	}
	
	val room3DNode = new NodeMapping<Room>(this, 'room3DNode', 'Room3DNode') {
		override createNode(IMappedElementDescriptor<Room> descriptor) { 
			new Room3DNode(descriptor)
		}
	}
	
	val roomDiagram = new DiagramMapping<Room>(this, 'roomDiagram', 'RoomDiagram') {
		
		override XDiagram createDiagram(IMappedElementDescriptor<Room> descriptor) { 
			new RoomDiagram(descriptor)
		}
		override calls() {
			// when adding a room diagram automatically add a node for monster, wall, trapdoor, entry, exit
			monsterNode.nodeForEach[monsters] 
			wallNode.nodeForEach[walls]
			trapdoorNode.nodeForEach[trapdoors]
			entryNode.nodeFor[entry] 
			exitNode.nodeFor[exit] 
		}		
		
		override getDefaultFilePath(Room element) {
			element.filePath
		}
	}
	
	val roomNodeName = new NodeHeadingMapping<Room>(this, BaseDiagramNode.NODE_HEADING) {
		override getText(Room element) {
			element.name
		}
	}
	
	val monsterNode = new NodeMapping<Monster>(this, 'monsterNode', 'Monster') {
		override createNode(IMappedElementDescriptor<Monster> descriptor) {
			new MonsterNode(descriptor)
		}
		
		override protected calls() {
		
		}
	}
	
	val wallNode = new NodeMapping<Wall>(this, 'wallNode', 'Wall') {
		override createNode(IMappedElementDescriptor<Wall> descriptor) {
			new WallNode(descriptor)
		}
		
		override protected calls() {
		
		}
	}	
	
	val entryNode = new NodeMapping<Entry>(this, 'entryNode', 'Entry') {
		override createNode(IMappedElementDescriptor<Entry> descriptor) {
			new EntryNode(descriptor)
		}
		
		override protected calls() {
		
		}
	}
	
	val exitNode = new NodeMapping<Exit>(this, 'exitNode', 'Exit') {
		override createNode(IMappedElementDescriptor<Exit> descriptor) {
			new ExitNode(descriptor)
		}
		
		override protected calls() {
		
		}
	}	
	
	val trapdoorNode = new NodeMapping<Trapdoor>(this, 'trapdoorNode', 'Trapdoor') {
		override createNode(IMappedElementDescriptor<Trapdoor> descriptor) {
			new TrapdoorNode(descriptor)
		}
		
		override protected calls() {
		
		}
	}		
	
	val roomConnection = new ConnectionMapping<Connection>(this, 'roomConnection', 'Connection') {
		override protected calls() {
			// when adding a transition, automatically add its source and target
			connectionLabel.labelFor[it]
			roomNode.source[eContainer as Room]
			roomNode.target[nextRoom]
		}
	}
	
	val connectionLabel = new ConnectionLabelMapping<Connection>(this, 'connectionLabel') {
		override getText(Connection it) {
			type
		}
	}

	// method to define entry points (2)
	override protected <ARG> entryCalls(ARG domainArgument, extension MappingAcceptor<ARG> acceptor) {
		switch domainArgument {
			Level: 
				add(levelDiagram, [domainArgument.getContainerOfType(Level)])
			Room: {
				add(levelDiagram, [domainArgument.getContainerOfType(Level)])
				add(roomNode, [domainArgument])
				add(roomDiagram, [domainArgument])
				add(room3DDiagram, [domainArgument])
			}
			
			Connection: {
				add(levelDiagram, [domainArgument.getContainerOfType(Level)])	
				add(roomConnection, [domainArgument])
			}
			
			Monster: {
				add(monsterNode, [domainArgument])
			}
			
			Wall: {
				add(wallNode, [domainArgument])
			}
			
			Trapdoor: {
				add(trapdoorNode, [domainArgument])
			}
			
			Entry: {
				add(entryNode, [domainArgument])
			}
			
			Exit: {
				add(exitNode, [domainArgument])
			}
		}
	}
}
