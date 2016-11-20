package at.ac.tuwien.big.leveldesign.ui.model;

/**
 * Created by alexander on 23/06/16.
 */
public class TrapdoorView {

    CoordinateView position;

    public TrapdoorView(CoordinateView position) {
        this.position = position;
    }

    public CoordinateView getPosition() {
        return position;
    }

    public void setPosition(CoordinateView position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrapdoorView that = (TrapdoorView) o;

        return position != null ? position.equals(that.position) : that.position == null;

    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
