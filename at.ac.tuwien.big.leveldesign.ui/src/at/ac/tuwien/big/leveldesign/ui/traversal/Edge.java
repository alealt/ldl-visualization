package at.ac.tuwien.big.leveldesign.ui.traversal;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;

/**
 * Created by alexander on 23/06/16.
 */
public class Edge {

    private final Vertex source;
    private final Vertex destination;
    private final int weight;
    private List<MonsterView> monstersToFight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex destination, int weight, List<MonsterView> monstersToFight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.monstersToFight = monstersToFight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public List<MonsterView> getMonstersToFight() {
        return monstersToFight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (weight != edge.weight) return false;
        if (source != null ? !source.equals(edge.source) : edge.source != null) return false;
        return destination != null ? destination.equals(edge.destination) : edge.destination == null;

    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + weight;
        return result;
    }
}
