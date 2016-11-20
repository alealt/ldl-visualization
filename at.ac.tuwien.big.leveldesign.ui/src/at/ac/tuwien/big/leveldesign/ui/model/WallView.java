package at.ac.tuwien.big.leveldesign.ui.model;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;

/**
 * Created by alexander on 19/05/16.
 */
public class WallView {

    CoordinateView from, to;

    public WallView(CoordinateView from, CoordinateView to) {
        this.from = from;
        this.to = to;
    }

    public CoordinateView getFrom() {
        return from;
    }

    public void setFrom(CoordinateView from) {
        this.from = from;
    }

    public CoordinateView getTo() {
        return to;
    }

    public void setTo(CoordinateView to) {
        this.to = to;
    }
}