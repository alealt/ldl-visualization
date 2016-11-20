package at.ac.tuwien.big.leveldesign.ui.traversal;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.model.TrapdoorView;
import at.ac.tuwien.big.leveldesign.ui.model.WallView;

/**
 * Created by alexander on 23/06/16.
 */
public class RoomToGraphConverter {

    private RoomView roomView;
    List<Vertex> vertices = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();


    public RoomToGraphConverter(RoomView roomView) {
        this.roomView = roomView;
    }

    public Graph getGraph(boolean forHero) {

        //create Vertices
        for(int i=0; i<roomView.getColumns(); i++) {
            for(int j=0; j<roomView.getRows(); j++) {
                if(isWalkable(i,j)) {
                    vertices.add(new Vertex(new CoordinateView(i,j)));
                }
            }
        }

        //create Edges
        for(Vertex from : vertices) {
            for(Vertex to : getNeighbours(from)) {

                List<MonsterView> toMonsters = getAggroLineMonsters(to);
                List<MonsterView> fromMonsters = getAggroLineMonsters(from);
                List<MonsterView> insideMonsters = getInsideAggroRangeMonsters(from);
                toMonsters.removeAll(fromMonsters);
                toMonsters.removeAll(insideMonsters);

                double cost = 1;

                if(forHero) {
                    for (MonsterView monsterView : toMonsters) {
                        cost += getMonsterCost(monsterView);
                    }
                }

                edges.add(new Edge(from,to,(int)cost, toMonsters));
            }


        }

        return new Graph(vertices, edges);

    }

    public List<Vertex> getNeighbours(Vertex vertex) {
        CoordinateView vertexCoordinate = vertex.getCoordinate();

        List<Vertex> neighbours = new ArrayList<>();

        //NORTH
        neighbours.add(getVertexByCoordinate(vertexCoordinate.getColumn(), vertexCoordinate.getRow()-1));
        //EAST
        neighbours.add(getVertexByCoordinate(vertexCoordinate.getColumn()+1, vertexCoordinate.getRow()));
        //SOUTH
        neighbours.add(getVertexByCoordinate(vertexCoordinate.getColumn(), vertexCoordinate.getRow()+1));
        //WEST
        neighbours.add(getVertexByCoordinate(vertexCoordinate.getColumn()-1, vertexCoordinate.getRow()));

        neighbours.removeAll(Collections.singleton(null));

        return neighbours;
    }

    private boolean isWalkable(int i, int j) {
        if(i<0 || j<0 || i>=roomView.getColumns() || j>=roomView.getRows())
            return false;

        return !isTrapdoor(i,j) && !isWall(i,j);
    }

    private boolean isTrapdoor(int i, int j) {
        for(TrapdoorView trapdoorView : roomView.getTrapdoors()) {
            if(trapdoorView.getPosition().equals(new CoordinateView(i,j))) {
                return true;
            }
        }

        return false;

    }

    private boolean isWall(int i, int j) {
        for(WallView wallView : roomView.getWalls()) {
            if(generateWallCoordinates(wallView).contains(new CoordinateView(i,j))) {
                return true;
            }
        }

        return false;
    }

    //calculate cost of visiting node within the aggro range of the given monster
    private double getMonsterCost(MonsterView monsterView) {
        return (monsterView.getDamage()/monsterView.getSpeed())*monsterView.getHp();
    }

    //Returns all monsters whose aggro line goes through the given vertex
    private List<MonsterView> getAggroLineMonsters(Vertex vertex) {

        List<MonsterView> monsterViews = new ArrayList<>();

        for(MonsterView monsterView : roomView.getMonsters()) {
            //Chebyshev distance
            int distance = Math.max(Math.abs(vertex.getCoordinate().getColumn()-monsterView.getPosition().getColumn()), Math.abs(vertex.getCoordinate().getRow()-monsterView.getPosition().getRow()));
            if(distance==monsterView.getAggroRadius()) {
                monsterViews.add(monsterView);
            }

        }

        return monsterViews;
    }

    //Returns all the monsters for which the given node is inside(excluding aggro line) the monsters range
    private List<MonsterView> getInsideAggroRangeMonsters(Vertex vertex) {

        List<MonsterView> monsterViews = new ArrayList<>();

        for(MonsterView monsterView : roomView.getMonsters()) {
            //Chebyshev distance
            int distance = Math.max(Math.abs(vertex.getCoordinate().getColumn()-monsterView.getPosition().getColumn()), Math.abs(vertex.getCoordinate().getRow()-monsterView.getPosition().getRow()));
            if(distance<monsterView.getAggroRadius()) {
                monsterViews.add(monsterView);
            }

        }

        return monsterViews;
    }

    private Vertex getVertexByCoordinate(int i, int j) {
        for(Vertex v : vertices) {
            if(v.getCoordinate().equals(new CoordinateView(i,j))) return v;
        }

        return null;
    }

    public Edge getEdgeByVertices(Vertex source, Vertex target) {

        for(Edge e : edges) {
            if(e.getSource().equals(source) && e.getDestination().equals(target)) {
                return e;
            }
        }

        return null;
    }

    private List<CoordinateView> generateWallCoordinates(WallView wallView) {

        List<CoordinateView> result = new ArrayList<>();

        if(wallView.getFrom().getColumn()== wallView.getTo().getColumn()) {  //vertical
            CoordinateView start, end;

            if(wallView.getFrom().getRow()<= wallView.getTo().getRow()) {
                start = wallView.getFrom();
                end = wallView.getTo();
            } else {
                start = wallView.getTo();
                end = wallView.getFrom();
            }

            for(int j = start.getRow(); j<=end.getRow(); j++) {
                result.add(new CoordinateView(wallView.getFrom().getColumn(), j));
            }
            return result;

        } else if(wallView.getFrom().getRow()== wallView.getTo().getRow()) {  //horizontal
            CoordinateView start, end;

            if (wallView.getFrom().getColumn() <= wallView.getTo().getColumn()) {
                start = wallView.getFrom();
                end = wallView.getTo();
            } else {
                start = wallView.getTo();
                end = wallView.getFrom();
            }

            for (int i = start.getColumn(); i <= end.getColumn(); i++) {
                result.add(new CoordinateView(i, wallView.getFrom().getRow()));
            }
            return result;
        }

        return result;
    }


}
