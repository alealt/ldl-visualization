package at.ac.tuwien.big.leveldesign.ui.dialog;


import java.util.Optional;

import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.nodes.LevelDiagram;
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DialogHandler {

	public static BorderPane getSpecificationForm(RoomDiagram mainWindow) {
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-border-color: black;");
		
		GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 30, 20, 30));

        Text scenetitle = new Text("Specification for hero traversal");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
        
        TextField healthPoints = new TextField();
        healthPoints.setText("1000");
        TextField damage = new TextField();
        damage.setText("10");
        TextField speed = new TextField();
        speed.setText("1");
        Slider slider = new Slider(0, 1, 0.5);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(9);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.snapToTicksProperty().set(true);

        grid.add(new Label("Health points"), 0, 1);
        grid.add(healthPoints, 1, 1);
        grid.add(new Label("Damage"), 0, 2);
        grid.add(damage, 1, 2);
        grid.add(new Label("Speed"), 0, 3);
        grid.add(speed, 1, 3);
        grid.add(new Label("Simulation speed"), 0, 4);
        grid.add(slider, 1, 4);

        
        grid.add(new Sprite(SpriteType.BALDRIC).getImageView(), 0, 5);
        Button startButton = new Button("Start");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(startButton);
        grid.add(hbBtn, 1, 5);
        
        
        startButton.setDisable(false);

        healthPoints.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || damage.getText().isEmpty() || !damage.getText().matches("\\d*") || speed.getText().isEmpty() || !speed.getText().matches("\\d*"));
        });

        damage.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || healthPoints.getText().isEmpty() || !healthPoints.getText().matches("\\d*") || speed.getText().isEmpty() || !speed.getText().matches("\\d*"));
        });

        speed.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || healthPoints.getText().isEmpty() || !healthPoints.getText().matches("\\d*") || damage.getText().isEmpty() || !damage.getText().matches("\\d*"));
        });
        
        
        
        startButton.setOnAction(event -> {
        	int simulationSpeed = (int)((1-slider.getValue())*1000);
            if(simulationSpeed==0) simulationSpeed = 1;
        	mainWindow.callStart(new HeroView(null,null,Double.parseDouble(healthPoints.getText()),Integer.parseInt(damage.getText()),Double.parseDouble(speed.getText()),0,null),simulationSpeed);
        });
        
        pane.setCenter(grid);      
        
        return pane;
	}
	
	public static BorderPane getSpecificationForm(LevelDiagram mainWindow) {
		
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-border-color: black;");
		
		GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 30, 20, 30));

        Text scenetitle = new Text("Specification for hero traversal");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
        
        TextField healthPoints = new TextField();
        healthPoints.setText("1000");
        TextField damage = new TextField();
        damage.setText("10");
        TextField speed = new TextField();
        speed.setText("1");

        grid.add(new Label("Health points"), 0, 1);
        grid.add(healthPoints, 1, 1);
        grid.add(new Label("Damage"), 0, 2);
        grid.add(damage, 1, 2);
        grid.add(new Label("Speed"), 0, 3);
        grid.add(speed, 1, 3);

        grid.add(new Sprite(SpriteType.BALDRIC).getImageView(), 0, 4);
        Button startButton = new Button("Start");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(startButton);
        grid.add(hbBtn, 1, 4);
        
        
        startButton.setDisable(false);

        healthPoints.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || damage.getText().isEmpty() || !damage.getText().matches("\\d*") || speed.getText().isEmpty() || !speed.getText().matches("\\d*"));
        });

        damage.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || healthPoints.getText().isEmpty() || !healthPoints.getText().matches("\\d*") || speed.getText().isEmpty() || !speed.getText().matches("\\d*"));
        });

        speed.textProperty().addListener((observable, oldValue, newValue) -> {
            startButton.setDisable(newValue.trim().isEmpty() || !newValue.matches("\\d*") || healthPoints.getText().isEmpty() || !healthPoints.getText().matches("\\d*") || damage.getText().isEmpty() || !damage.getText().matches("\\d*"));
        });
        
        
        startButton.setOnAction(event -> mainWindow.showTraversalHPGraph(new HeroView(null,null,Double.parseDouble(healthPoints.getText()),Integer.parseInt(damage.getText()),Double.parseDouble(speed.getText()),0,null)));
        
        pane.setCenter(grid);      
        
        return pane;
	}
}
