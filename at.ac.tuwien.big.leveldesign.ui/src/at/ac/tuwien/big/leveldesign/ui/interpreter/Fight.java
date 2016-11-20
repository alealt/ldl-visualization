package at.ac.tuwien.big.leveldesign.ui.interpreter;

import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;

public class Fight implements Action {

    private final MonsterView monsterView;
    private double damageTakenMonster;
    private double damageTakenHero;
    private double startHealthPointsHero;
    private Vertex monsterPosition;
    private Vertex heroPosition;

    public Fight(MonsterView monsterView) {
        this.monsterView = monsterView;
    }

    public MonsterView getMonsterView() {
        return monsterView;
    }

    public double getDamageTakenMonster() {
        return damageTakenMonster;
    }

    public void setDamageTakenMonster(double damageTakenMonster) {
        this.damageTakenMonster = damageTakenMonster;
    }

    public double getDamageTakenHero() {
        return damageTakenHero;
    }

    public void setDamageTakenHero(double damageTakenHero) {
        this.damageTakenHero = damageTakenHero;
    }

    public double getStartHealthPointsHero() {
        return startHealthPointsHero;
    }

    public void setStartHealthPointsHero(double startHealthPointsHero) {
        this.startHealthPointsHero = startHealthPointsHero;
    }

    public Vertex getMonsterPosition() {
        return monsterPosition;
    }

    public void setMonsterPosition(Vertex monsterPosition) {
        this.monsterPosition = monsterPosition;
    }

    public Vertex getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(Vertex heroPosition) {
        this.heroPosition = heroPosition;
    }
}
