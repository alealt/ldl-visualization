package at.ac.tuwien.big.leveldesign.ui.interpreter;

import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;

/**
 * Created by alexander on 27/06/16.
 */
public class MonsterDie extends Die {

    private final MonsterView monsterView;

    public MonsterDie(MonsterView monsterView) {
        this.monsterView = monsterView;
    }

    public MonsterView getMonsterView() {
        return monsterView;
    }
}
