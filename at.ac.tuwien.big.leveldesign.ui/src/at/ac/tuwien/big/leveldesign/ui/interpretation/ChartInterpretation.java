package at.ac.tuwien.big.leveldesign.ui.interpretation;

import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.leveldesign.ui.interpreter.GameInterpreter;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

public class ChartInterpretation {

	private RoomView startRoom;
	private RoomView endRoom;
	private HeroView specs;
	
	public ChartInterpretation(RoomView startRoom, RoomView endRoom) {
		this.startRoom = startRoom;
		this.endRoom = endRoom;
	}

	public Node traversalHpChart(HeroView specs) {
		this.specs = specs;
		
		GameInterpreter gameInterpeter = new GameInterpreter(startRoom, specs);
		boolean atGoal = false;
		
		
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Steps");
         yAxis.setLabel("Healthpoints");
        final LineChartWithMarkers<Number, Number> lineChart = new LineChartWithMarkers<Number,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Healthpoint Monitoring of Traversal");
            
        RoomView currentRoom = startRoom;
        int roomOffset = 0;
        boolean addedDeathMarker = false;
       
        
        while(currentRoom!=null && !atGoal) {
        	
        	XYChart.Series series = new XYChart.Series();
			series.setName(currentRoom.getName());
			 
			List<Pair<Integer, Double>> stepHps = gameInterpeter.getStepwiseHPs(currentRoom, specs);
			 
			for(Pair<Integer,Double> p : stepHps) {
				series.getData().add(new XYChart.Data(roomOffset+p.getKey(),p.getValue()));
				
				if(p.getValue()==0 &&!addedDeathMarker) {
			        lineChart.addVerticalValueMarker(new XYChart.Data(roomOffset+p.getKey(),p.getValue()));
			        addedDeathMarker = true;
				}
			}
			lineChart.getData().add(series);
			
			roomOffset += stepHps.get(stepHps.size()-1).getKey();
			
			if(currentRoom.equals(endRoom)) 
				atGoal=true;

			currentRoom = currentRoom.getNextRoom();
        }
        
  
		return lineChart;
	}
	
	public Node requiredPowerChart() {
		GameInterpreter gameInterpeter = new GameInterpreter(startRoom, specs);
		boolean atGoal = false;
		
		
		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Goal");
        yAxis.setLabel("Power (HP*DPS)");
        final LineChart<String, Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
        lineChart.legendVisibleProperty().set(false);
       
        lineChart.setTitle("Required Power for Traversal");
            
        RoomView currentRoom = startRoom;
        int powerOverall = 0;
       
        
        XYChart.Series series = new XYChart.Series();
        while(currentRoom!=null && !atGoal) {
               	
        	series.getData().add(new XYChart.Data(currentRoom.getName(),powerOverall));
			powerOverall+=gameInterpeter.getPowerNeeded(currentRoom);
			
			if(currentRoom.equals(endRoom)) 
				atGoal=true;

			currentRoom = currentRoom.getNextRoom();
        }
        
        series.getData().add(new XYChart.Data("Final Destination",powerOverall));
        lineChart.getData().add(series);
       
		return lineChart;
	}
	
	private class LineChartWithMarkers<X,Y> extends LineChart {

        private ObservableList<Data<X, Y>> horizontalMarkers;
        private ObservableList<Data<X, Y>> verticalMarkers;

        public LineChartWithMarkers(Axis<X> xAxis, Axis<Y> yAxis) {
            super(xAxis, yAxis);
            horizontalMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.YValueProperty()});
            horizontalMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
            verticalMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.XValueProperty()});
            verticalMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
        }

        public void addHorizontalValueMarker(Data<X, Y> marker) {
            Objects.requireNonNull(marker, "the marker must not be null");
            if (horizontalMarkers.contains(marker)) return;
            Line line = new Line();
            marker.setNode(line );
            getPlotChildren().add(line);
            horizontalMarkers.add(marker);
        }

        public void removeHorizontalValueMarker(Data<X, Y> marker) {
            Objects.requireNonNull(marker, "the marker must not be null");
            if (marker.getNode() != null) {
                getPlotChildren().remove(marker.getNode());
                marker.setNode(null);
            }
            horizontalMarkers.remove(marker);
        }

        public void addVerticalValueMarker(Data<X, Y> marker) {
            Objects.requireNonNull(marker, "the marker must not be null");
            if (verticalMarkers.contains(marker)) return;
            Line line = new Line();
            line.getStrokeDashArray().addAll(10d, 5d);
            marker.setNode(line );
            getPlotChildren().add(line);
            verticalMarkers.add(marker);
        }

        public void removeVerticalValueMarker(Data<X, Y> marker) {
            Objects.requireNonNull(marker, "the marker must not be null");
            if (marker.getNode() != null) {
                getPlotChildren().remove(marker.getNode());
                marker.setNode(null);
            }
            verticalMarkers.remove(marker);
        }


        @Override
        protected void layoutPlotChildren() {
            super.layoutPlotChildren();
            for (Data<X, Y> horizontalMarker : horizontalMarkers) {
                Line line = (Line) horizontalMarker.getNode();
                line.setStartX(0);
                line.setEndX(getBoundsInLocal().getWidth());
                line.setStartY(getYAxis().getDisplayPosition(horizontalMarker.getYValue()) + 0.5); // 0.5 for crispness
                line.setEndY(line.getStartY());
                line.toFront();
            }
            for (Data<X, Y> verticalMarker : verticalMarkers) {
                Line line = (Line) verticalMarker.getNode();
                line.setStartX(getXAxis().getDisplayPosition(verticalMarker.getXValue()) + 0.5);  // 0.5 for crispness
                line.setEndX(line.getStartX());
                line.setStartY(0d);
                line.setEndY(getBoundsInLocal().getHeight());
                line.toFront();
            }      
        }

    }
	
	
	

}
