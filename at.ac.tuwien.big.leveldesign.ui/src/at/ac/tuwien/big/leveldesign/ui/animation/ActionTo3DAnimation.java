package at.ac.tuwien.big.leveldesign.ui.animation;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.leveldesign.ui.interpreter.Action;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Fight;
import at.ac.tuwien.big.leveldesign.ui.interpreter.HeroDie;
import at.ac.tuwien.big.leveldesign.ui.interpreter.HeroMove;
import at.ac.tuwien.big.leveldesign.ui.interpreter.MonsterDie;
import at.ac.tuwien.big.leveldesign.ui.interpreter.MonsterMove;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.traversal.Vertex;

/**
 * Created by alexander on 28/06/16.
 */
public class ActionTo3DAnimation {

    private static final int TILE_SIZE = 32;
    private static final int DURATION_PER_TILE = 500;

    private Node hero;
    private RoomView roomView;
    private Map<MonsterView, Node> monsterMap;
    private CoordinateView lastHeroPosition;
    //private Room3DDiagram mainWindow;
    public ActionTo3DAnimation(Node hero, RoomView roomView, Map<MonsterView, Node> monsterMap /*,Room3DDiagram mainWindow*/) {
        this.hero = hero;
        this.roomView = roomView;
        this.monsterMap = monsterMap;
        this.lastHeroPosition = roomView.getEntry().getPosition();
        //this.mainWindow = mainWindow
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
            ParallelTransition parallelMove = new ParallelTransition();

            // Calculate node right before next direction change
            Vertex moveToVertex = nextVertexBeforeDirectionChange(currentVertex, path);


            //Incorporate moving up/down to/from portal platform
            if(currentVertex.getCoordinate().equals(roomView.getEntry().getPosition())) {
                moveToVertex = path.get(1);
                TranslateTransition moveDown = new TranslateTransition();
                moveDown.setNode(hero);
                moveDown.setByY(-4);
                moveDown.setDuration(Duration.millis(DURATION_PER_TILE));
                parallelMove.getChildren().add(moveDown);
            } else if(moveToVertex.getCoordinate().equals(roomView.getExit().getPosition()) && !currentVertex.equals(path.get(path.size()-2))) {
                moveToVertex = path.get(path.size()-2);
            } else if(moveToVertex.getCoordinate().equals(roomView.getExit().getPosition()) && currentVertex.equals(path.get(path.size()-2))) {
                TranslateTransition moveUp = new TranslateTransition();
                moveUp.setNode(hero);
                moveUp.setByY(+4);
                moveUp.setDuration(Duration.millis(DURATION_PER_TILE));
                parallelMove.getChildren().add(moveUp);
            }


            Animation rotation = null;
            Direction direction = calculateMoveDirection(currentVertex, moveToVertex);
            if(direction==Direction.UP) {
                rotation = getTurnUpAnimation();
            } else if(direction==Direction.LEFT) {
                rotation = getTurnLeftAnimation();
            } else if(direction==Direction.DOWN) {
                rotation = getTurnDownAnimation();
            } else if(direction==Direction.RIGHT) {
                rotation = getTurnRightAnimation();
            }

            TranslateTransition move = new TranslateTransition();
            move.setNode(hero);
            move.setAutoReverse(false);

            int numberOfXTiles = calculateXTileDistance(currentVertex, moveToVertex);
            int numberOfYTiles = calculateYTileDistance(currentVertex, moveToVertex);

            move.setByX(numberOfXTiles*TILE_SIZE);
            move.setByZ(numberOfYTiles*TILE_SIZE);
            move.setDuration(Duration.millis(Math.max(Math.abs(numberOfXTiles), Math.abs(numberOfYTiles))*DURATION_PER_TILE));
            parallelMove.getChildren().add(move);

            movingHero.getChildren().addAll(rotation, parallelMove);

            currentVertex = moveToVertex;
            lastHeroPosition = currentVertex.getCoordinate();
        }

        return movingHero;
    }

    //Monster movement not supported in 3D
    public Animation transform(MonsterMove action) {
        SequentialTransition movingMonster = new SequentialTransition();
        return movingMonster;
    }

    public Animation transform(Fight action) {
        SequentialTransition sequentialTransition = new SequentialTransition();
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        new KeyValue(
                                monsterMap.get(action.getMonsterView()).opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.25),
                        new KeyValue(
                                monsterMap.get(action.getMonsterView()).opacityProperty(),
                                0,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.5),
                        new KeyValue(
                                monsterMap.get(action.getMonsterView()).opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(3);
        TranslateTransition waitAnimation = new TranslateTransition();
        waitAnimation.setDuration(Duration.seconds(1));
        sequentialTransition.getChildren().addAll(blink,waitAnimation);

        return sequentialTransition;
    }

    public Animation transform(MonsterDie action) {
        return getMonsterDieAnimation(action.getMonsterView());
    }

    public Animation transform(HeroDie action) {
        return getHeroDieAnimation();
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

    public Animation getTurnUpAnimation() {
        ParallelTransition parallelTransition = new ParallelTransition();
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(hero);
        translateTransition.setToX(lastHeroPosition.getColumn()*TILE_SIZE+27);
        translateTransition.setToZ(lastHeroPosition.getRow()*TILE_SIZE+22);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setNode(hero);
        rotateTransition.setToAngle(180);
        parallelTransition.getChildren().addAll(translateTransition, rotateTransition);
        return parallelTransition;
    }

    public Animation getTurnLeftAnimation()  {
        ParallelTransition parallelTransition = new ParallelTransition();
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(hero);
        translateTransition.setToX(lastHeroPosition.getColumn()*TILE_SIZE+32);
        translateTransition.setToZ(lastHeroPosition.getRow()*TILE_SIZE+17);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setNode(hero);
        rotateTransition.setToAngle(-90);
        parallelTransition.getChildren().addAll(translateTransition, rotateTransition);
        return parallelTransition;
    }

    public Animation getTurnDownAnimation()  {
        ParallelTransition parallelTransition = new ParallelTransition();
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(hero);
        translateTransition.setToX(lastHeroPosition.getColumn()*TILE_SIZE+27);
        translateTransition.setToZ(lastHeroPosition.getRow()*TILE_SIZE+12);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setNode(hero);
        rotateTransition.setToAngle(0);
        parallelTransition.getChildren().addAll(translateTransition, rotateTransition);
        return parallelTransition;
    }

    public Animation getTurnRightAnimation()  {
        ParallelTransition parallelTransition = new ParallelTransition();
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(hero);
        translateTransition.setToX(lastHeroPosition.getColumn()*TILE_SIZE+22);
        translateTransition.setToZ(lastHeroPosition.getRow()*TILE_SIZE+17);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setNode(hero);
        rotateTransition.setToAngle(90);
        parallelTransition.getChildren().addAll(translateTransition, rotateTransition);
        return parallelTransition;
    }

    private Animation getMonsterDieAnimation(MonsterView monsterView) {
        Rotate rotation = new Rotate();
        Box box = new Box();
        box.setTranslateY(185);
        rotation.setAxis(Rotate.X_AXIS);
        rotation.pivotYProperty().bind(box.translateYProperty());
        monsterMap.get(monsterView).getTransforms().add(rotation);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.millis(600), new KeyValue(rotation.angleProperty(), 90)));

        return timeline;
    }

    private Animation getHeroDieAnimation() {
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().add(getTurnDownAnimation());

        Rotate rotation = new Rotate();
        Box box = new Box();
        box.setTranslateY(-7);
        rotation.setAxis(Rotate.X_AXIS);
        rotation.pivotXProperty().bind(box.translateXProperty());
        rotation.pivotZProperty().bind(box.translateZProperty());
        rotation.pivotYProperty().bind(box.translateYProperty());
        hero.getTransforms().add(rotation);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.millis(600), new KeyValue(rotation.angleProperty(), -100)));

        sequentialTransition.getChildren().add(timeline);
        sequentialTransition.play();
        return sequentialTransition;
    }
}
