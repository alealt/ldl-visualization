package at.ac.tuwien.big.leveldesign.ui.model;

/**
 * Created by alexander on 28/06/16.
 */
public class ExitView {

    private CoordinateView position;

    public ExitView(CoordinateView position) {
        this.position = position;
    }

    public CoordinateView getPosition() {
        return position;
    }

    public void setPosition(CoordinateView position) {
        this.position = position;
    }
}
