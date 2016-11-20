package at.ac.tuwien.big.leveldesign.ui.interpreter;

import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;

/**
 * Created by alexander on 27/06/16.
 */
public class Move implements Action {

    private final List<Vertex> path;

    public Move(List<Vertex> path) {
        this.path = path;
    }

    public List<Vertex> getPath() {
        return path;
    }
}
