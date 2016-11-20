package at.ac.tuwien.big.leveldesign.ui.gamecomponent;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane {

    private int column;
    private boolean wall;
    private int row;

    public Tile(int column, int row) {
        this.column = column;
        this.row = row;

        Image grassImg = new Image("images/grass.bmp");

        ImageView backgroundView = new ImageView(grassImg);
        backgroundView.setFitHeight(32);
        backgroundView.setFitWidth(32);

        setAlignment(Pos.CENTER);

        getChildren().add(backgroundView);
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

}