package at.ac.tuwien.big.leveldesign.ui.interpreter;

import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;

/**
 * Created by alexander on 27/06/16.
 */
public class MonsterMove extends Move {

    private final MonsterView monsterView;

    public MonsterMove(List<Vertex> path, MonsterView monsterView) {
        super(path);
        this.monsterView = monsterView;
    }

    public MonsterView getMonsterView() {
        return monsterView;
    }
}
