package at.ac.tuwien.big.leveldesign.ui.interpretation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.traversal.DijkstraAlgorithm;
import at.ac.tuwien.big.leveldesign.ui.traversal.Graph;
import at.ac.tuwien.big.leveldesign.ui.traversal.RoomToGraphConverter;
import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

public class StartDifficultyInterpretation {

	private RoomView room;
	private static final int  TILE_SIZE = 32;
	
	public StartDifficultyInterpretation(RoomView room) {
		this.room = room;
	}
	
    public Node getStartDifficultyOverlay() {
        GridPane overLay = new GridPane();

        RoomToGraphConverter converter = new RoomToGraphConverter(room);
        Graph heroGraph = converter.getGraph(true);

        int maxDifficulty = 0;

        List<Pair<CoordinateView,Integer>> difficultyMapping = new ArrayList<>();
        List<Integer> difficulties = new ArrayList<>();
        
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        try {
            forkJoinPool.submit(() -> {
                    IntStream.range(0, room.getColumns())
                            .parallel()
                            .forEach(i -> IntStream.range(0, room.getRows()).parallel().forEach(j -> {
                            	
                                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(heroGraph);
                                dijkstra.execute(new Vertex(new CoordinateView(i,j)));
                                int difficulty = dijkstra.getShortestDistance(new Vertex(room.getExit().getPosition()));
                                if(difficulty!=Integer.MAX_VALUE) {
                                    difficulty = 0;

                                    List<MonsterView> pullingMonstersOnPath = dijkstra.getMonstersPulledOnPath(new Vertex(room.getExit().getPosition()));
                                    for (MonsterView m : room.getMonsters()) {
                                        int monsterDistance = Math.max(Math.abs(i - m.getPosition().getColumn()), Math.abs(j - m.getPosition().getRow()));
                                        if (!pullingMonstersOnPath.contains(m) && monsterDistance <= m.getAggroRadius()) {
                                            pullingMonstersOnPath.add(m);
                                        }

                                    }

                                    for (MonsterView monster : pullingMonstersOnPath) {
                                        difficulty += (monster.getDamage() / monster.getSpeed()) * monster.getHp();
                                    }
                                    
                                    difficulties.add(difficulty);

                                    
                                }
                                difficultyMapping.add(new Pair<CoordinateView, Integer>(new CoordinateView(i,j),difficulty));
                                
                            })); }

            ).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        maxDifficulty = difficulties.stream().max(Comparator.naturalOrder()).get();
        
        for(Pair<CoordinateView,Integer> p : difficultyMapping) {
            Rectangle r = new Rectangle(TILE_SIZE, TILE_SIZE);
            r.opacityProperty().setValue(0.6);

            int distance = (p.getValue()==Integer.MAX_VALUE)?maxDifficulty:p.getValue();
            r.setFill(getColor((double)distance/maxDifficulty));
            overLay.add(r, p.getKey().getColumn(), p.getKey().getRow());
        }

        return overLay;
    }

    /**
     *
     * @param power 1.0 will return a bright red, 0.0 will return a bright green.
     * @return
     */
    public Color getColor(double power) {
        double H = (1-power) * 120; // Hue (note 0.4 = Green)
        double S = 0.9; // Saturation
        double B = 0.9; // Brightness

        return Color.hsb((float)H, (float)S, (float)B);
    }
}
