package at.ac.tuwien.big.leveldesign.ui.nodes

import de.fxdiagram.mapping.IMappedElementDescriptor
import de.fxdiagram.mapping.shapes.BaseDiagram

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import javafx.scene.Node
import at.ac.tuwien.big.leveldesign.ui.domainconverter.Domain2ViewModelConverter
import at.ac.tuwien.big.leveldesign.ui.model.RoomView
import at.ac.tuwien.big.leveldesign.ui.model.HeroView
import at.ac.tuwien.big.leveldesign.ui.dialog.DialogHandler
import at.ac.tuwien.big.leveldesign.levelDesign.Level
import at.ac.tuwien.big.leveldesign.ui.action.ChartTraversalHPAction
import at.ac.tuwien.big.leveldesign.ui.interpretation.ChartInterpretation
import at.ac.tuwien.big.leveldesign.ui.action.ChartPowerAction
import de.fxdiagram.annotations.properties.ModelNode

@ModelNode
class LevelDiagram extends BaseDiagram<Level> {

	var IMappedElementDescriptor<Level> descriptor;
	var Node traversalHpChart;
	var Node powerChart;
	var Node traversalHPDialog;
	
	new(IMappedElementDescriptor<Level> descriptor) {
		super(descriptor)
		this.descriptor= descriptor
		
		layoutOnActivate = true
		
	}
	
	override void doActivate() {
		super.doActivate()
	
		root.diagramActionRegistry+= #[new ChartTraversalHPAction]
		root.diagramActionRegistry+= #[new ChartPowerAction]
	}
	
	def hideAll() {
		for(Node n : nodeLayer.children) {
			n.visible = false
		}
	}
	
	def showAll() {
		for(Node n : nodeLayer.children) {
			n.visible = true
		}
	}
	
	def showTraversalDialog() {	
		hideAll();
		traversalHPDialog = DialogHandler.getSpecificationForm(this);
		nodeLayer.children.add(traversalHPDialog);
	
	}	
	
	def showTraversalHPGraph(HeroView heroSpecs) {
		nodeLayer.children.remove(traversalHPDialog)
		var RoomView startRoom = Domain2ViewModelConverter.room(descriptor.withDomainObject[it.spawnRoom]);	
		var RoomView goalRoom = Domain2ViewModelConverter.room(descriptor.withDomainObject[it.goalRoom]);

		traversalHpChart = new ChartInterpretation(startRoom, goalRoom).traversalHpChart(heroSpecs)
		nodeLayer.children.add(traversalHpChart)
	}	
	
	def hideTraversalHPGraph() {
		nodeLayer.children.remove(traversalHPDialog);
		nodeLayer.children.remove(traversalHpChart);
		showAll();
	}
	
	def showPowerGraph() {
		hideAll();
		var RoomView startRoom = Domain2ViewModelConverter.room(descriptor.withDomainObject[it.spawnRoom]);	
		var RoomView goalRoom = Domain2ViewModelConverter.room(descriptor.withDomainObject[it.goalRoom]);
		powerChart = new ChartInterpretation(startRoom,goalRoom).requiredPowerChart
		nodeLayer.children.add(powerChart);
	}
	
	def hidePowerGraph() {
		nodeLayer.children.remove(powerChart);
		showAll();
	}
	
	
	
}
