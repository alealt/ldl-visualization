package at.ac.tuwien.big.leveldesign.ui.animation;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.List;

import at.ac.tuwien.big.leveldesign.ui.interpreter.*;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.nodes.RoomDiagram;
import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;

/**
 * Created by alexander on 28/06/16.
 */
public class ActionToAnimation {

    private static final int TILE_SIZE = 32;
    private int durationPerTile = 500;

    private HeroView hero;
    private RoomDiagram mainWindow;

    public ActionToAnimation(HeroView hero, RoomDiagram mainWindow) {
        this.hero = hero;
        this.mainWindow = mainWindow;
        this.durationPerTile =  hero.getSprite().getDurationPerTile();
    }

    //TODO: this needs to be changed, maybe add the transform code to the respective actions
    public Animation transform(Action a) {
        if (a instanceof HeroMove) {
            return transform((HeroMove) a);
        } else if (a instanceof MonsterMove) {
            return transform((MonsterMove) a);
        } else if (a instanceof HeroDie) {
            return transform((HeroDie) a);
        } else if (a instanceof MonsterDie) {
            return transform((MonsterDie) a);
        } else if (a instanceof Fight) {
            return transform((Fight) a);
        }

        throw new RuntimeException("Transformation error: Unknown action type");
    }

    public Animation transform(HeroMove action) {
        SequentialTransition movingHero = new SequentialTransition();
        List<Vertex> path = action.getPath();

        Vertex currentVertex = path.get(0);

        while(currentVertex!=path.get(path.size()-1)) {
            // Calculate node right before next direction change
            Vertex moveToVertex = nextVertexBeforeDirectionChange(currentVertex, path);

            TranslateTransition move = new TranslateTransition();
            move.setNode(hero.getSprite().getImageView());
            move.setAutoReverse(false);

            int numberOfXTiles = calculateXTileDistance(currentVertex, moveToVertex);
            int numberOfYTiles = calculateYTileDistance(currentVertex, moveToVertex);

            move.setByX(numberOfXTiles*TILE_SIZE);
            move.setByY(numberOfYTiles*TILE_SIZE);
            move.setDuration(Duration.millis(Math.max(Math.abs(numberOfXTiles), Math.abs(numberOfYTiles))*durationPerTile));

            Animation walking = hero.getSprite().getWalkAnimation(calculateMoveDirection(currentVertex, moveToVertex));
            walking.setCycleCount(Math.max(Math.abs(numberOfXTiles), Math.abs(numberOfYTiles)));

            ParallelTransition pt = new ParallelTransition(walking, move);
            movingHero.getChildren().add(pt);

            currentVertex = moveToVertex;
        }

        return movingHero;
    }

    public Animation transform(MonsterMove action) {
        SequentialTransition movingMonster = new SequentialTransition();
        List<Vertex> path = action.getPath();

        Vertex currentVertex = path.get(0);

        while(currentVertex!=path.get(path.size()-1)) {
            // Calculate node right before next direction change
            Vertex moveToVertex = nextVertexBeforeDirectionChange(currentVertex, path);

            TranslateTransition move = new TranslateTransition();

            Sprite toMove = action.getMonsterView().getSprite();

            move.setNode(toMove.getImageView());
            move.setAutoReverse(false);

            int numberOfXTiles = calculateXTileDistance(currentVertex, moveToVertex);
            int numberOfYTiles = calculateYTileDistance(currentVertex, moveToVertex);

            move.setByX(numberOfXTiles*TILE_SIZE);
            move.setByY(numberOfYTiles*TILE_SIZE);
            move.setDuration(Duration.millis(Math.max(Math.abs(numberOfXTiles), Math.abs(numberOfYTiles))*durationPerTile));

            Animation walking = toMove.getWalkAnimation(calculateMoveDirection(currentVertex, moveToVertex));
            walking.setCycleCount(Math.max(Math.abs(numberOfXTiles), Math.abs(numberOfYTiles)));

            ParallelTransition pt = new ParallelTransition(walking, move);
            movingMonster.getChildren().add(pt);

            currentVertex = moveToVertex;
        }

        return movingMonster;
    }

    public Animation transform(Fight action) {
        ParallelTransition fighting = new ParallelTransition();

        MonsterView monster = action.getMonsterView();

        Sprite toFight = monster.getSprite();

        Animation monsterFighting = toFight.getSpellAnimation(calculateMoveDirection(action.getMonsterPosition(), action.getHeroPosition()));
        monsterFighting.setCycleCount(10);

        Animation heroFighting = hero.getSprite().getSlashAnimation(calculateMoveDirection(action.getHeroPosition(), action.getMonsterPosition()));
        heroFighting.setCycleCount(10);

        fighting.setOnFinished(event -> mainWindow.updateProgress(action));

        fighting.getChildren().addAll(monsterFighting, heroFighting);

        return fighting;
    }

    public Animation transform(MonsterDie action) {
        Sprite toDie = action.getMonsterView().getSprite();
        Animation heroDying = toDie.getFallAnimation();

        return heroDying;
    }

    public Animation transform(HeroDie action) {
        return hero.getSprite().getFallAnimation();
    }



    /**
     * UTILITY METHODS
     */

    private Vertex nextVertexBeforeDirectionChange(Vertex current, List<Vertex> subPath) {

        Direction movingTowards = null;

        for(int i=subPath.indexOf(current); i<subPath.size(); i++) {

            if(i+1<subPath.size()) {
                if(movingTowards!=null && movingTowards!=calculateMoveDirection(subPath.get(i), subPath.get(i+1))) {
                    return subPath.get(i);
                } else {
                    movingTowards = calculateMoveDirection(subPath.get(i), subPath.get(i+1));
                }
            }
        }

        return subPath.get(subPath.size()-1);
    }

    private Direction calculateMoveDirection(Vertex from, Vertex to) {

        if(to.getCoordinate().getColumn()<from.getCoordinate().getColumn())
            return Direction.LEFT;
        else if(to.getCoordinate().getColumn()>from.getCoordinate().getColumn())
            return Direction.RIGHT;
        else if(to.getCoordinate().getRow()<from.getCoordinate().getRow())
            return Direction.UP;

        return Direction.DOWN;
    }

    private int calculateXTileDistance(Vertex from, Vertex to) {
        return (to.getCoordinate().getColumn()-from.getCoordinate().getColumn());
    }

    private int calculateYTileDistance(Vertex from, Vertex to) {
        return (to.getCoordinate().getRow()-from.getCoordinate().getRow());
    }
}
