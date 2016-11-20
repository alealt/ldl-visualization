package at.ac.tuwien.big.leveldesign.ui.traversal;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;

public class Vertex {

    private final CoordinateView coordinate;

    public Vertex(CoordinateView coordinate) {
        this.coordinate = coordinate;
    }

    public CoordinateView getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return coordinate != null ? coordinate.equals(vertex.coordinate) : vertex.coordinate == null;

    }

    @Override
    public int hashCode() {
        return coordinate != null ? coordinate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "coordinate=" + coordinate +
                '}';
    }
}
