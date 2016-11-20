package at.ac.tuwien.big.leveldesign.ui.interpretation;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AggroRangeInterpretation {

	private RoomView room;
	private static final int  TILE_SIZE = 32;
	private Color [] colors = {Color.RED, Color.ORANGE, Color.BROWN, Color.BLACK, Color.DARKGRAY, Color.DARKGOLDENROD, Color.DARKSLATEBLUE, Color.ROSYBROWN, Color.ORANGERED, Color.MAROON};

	
	public AggroRangeInterpretation(RoomView room) {
		this.room = room;
	}
	
	public Node getAggroOverlay() {
        int colorCount = 0;

        GridPane overLay = new GridPane();

        //init gridpane with stackpanes
        for(int i = 0; i< room.getColumns(); i++) {
            for(int j = 0; j< room.getRows(); j++) {
            	StackPane stackPane = new StackPane();
                Rectangle r = new Rectangle(TILE_SIZE, TILE_SIZE);
                r.opacityProperty().setValue(0);
                stackPane.getChildren().add(r);
                overLay.add(stackPane, i, j);
            }
        }

        for(MonsterView monster : room.getMonsters()) {
            Color monstercolor  = colors[colorCount];
            colorCount++;
            if(colorCount==colors.length) colorCount = 0;

            for(int i = 0; i< room.getColumns(); i++) {
                for(int j = 0; j< room.getRows(); j++) {
                    int distance = Math.max(Math.abs(i-monster.getPosition().getColumn()), Math.abs(j-monster.getPosition().getRow()));

                    if(distance <= monster.getAggroRadius()) {
                        Rectangle r = new Rectangle(TILE_SIZE, TILE_SIZE);
                        r.setFill(monstercolor);
                        r.opacityProperty().setValue(0.4);
                        ((StackPane)getNodeFromGridPane(overLay, i,j)).getChildren().add(r);
                    }
                }
            }

        }

        return overLay;
    }
	
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
