package at.ac.tuwien.big.leveldesign.ui.threeD;

import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;

import at.ac.tuwien.big.leveldesign.ui.animation.ActionTo3DAnimation;
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Action;
import at.ac.tuwien.big.leveldesign.ui.interpreter.GameInterpreter;
import at.ac.tuwien.big.leveldesign.ui.interpreter.Interpreter;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.model.WallView;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author cmcastil
 */
public class Room3DInterpretation {

    private RoomView room;
    private HeroView hero;
    
    SubScene scene;

    private final int TILE_SIZE = 32;

    final Group root = new Group();
    final Xform roomGroup = new Xform();
    final Xform world = new Xform();
    final PerspectiveCamera camera = new PerspectiveCamera(true);
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
    private static final double CAMERA_INITIAL_DISTANCE = -1500;
    private static final double CAMERA_INITIAL_X_ANGLE = 90.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 0.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;
    private static final double AXIS_LENGTH = 250.0;
    private static final double CONTROL_MULTIPLIER = 0.1;
    private static final double SHIFT_MULTIPLIER = 10.0;
    private static final double MOUSE_SPEED = 0.1;
    private static final double ROTATION_SPEED = 2.0;
    private static final double TRACK_SPEED = 0.3;
    
    double mousePosX;
    double mousePosY;
    double mouseOldX;
    double mouseOldY;
    double mouseDeltaX;
    double mouseDeltaY;

    boolean playing;

    MediaPlayer mediaPlayer;

    Group r2d2;
    private Map<MonsterView, Node> monsterMap = new HashMap();
    
    private boolean traversalActive = false;
    
    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);

        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);


        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }

    private void handleMouse(SubScene scene, final Node root) {
        scene.setOnMousePressed(me -> {
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            mouseOldX = mousePosX;
            mouseOldY = mousePosY;
            mousePosX = me.getSceneX();
            mousePosY = me.getSceneY();
            mouseDeltaX = (mousePosX - mouseOldX);
            mouseDeltaY = (mousePosY - mouseOldY);

            double modifier = 1.0;

            if (me.isControlDown()) {
                modifier = CONTROL_MULTIPLIER;
            }
            if (me.isShiftDown()) {
                modifier = SHIFT_MULTIPLIER;
            }
            if (me.isPrimaryButtonDown()) {
                cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED);
                cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED);
            }
            else if (me.isSecondaryButtonDown()) {
                double z = camera.getTranslateZ();
                double newZ = z + mouseDeltaX*MOUSE_SPEED*modifier;
                camera.setTranslateZ(newZ);
            }
            else if (me.isMiddleButtonDown()) {
                cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);
                cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);
            }
        });

        scene.setOnScroll(me -> activateTraversal(!me.isShiftDown()));
    }
    
    private void activateTraversal(boolean success) {
    	//success just for demonstration purposes
    	
    	if(!traversalActive) {
    		if(success) hero.setHp(10000);
    		else hero.setHp(1);
    		traversalActive = true; 
    		Animation a = buildAnimation();
    		a.setOnFinished(e -> traversalActive=false);
            a.play();
    	}
    }
    
    private void buildRoom() {
        ObjModelImporter objImporter = new ObjModelImporter();
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.DARKGREY);
        greyMaterial.setSpecularColor(Color.GREY);

        Xform roomXform = new Xform();
        Xform boardXform = new Xform();

        //Create main board including trapdoor "holes"
        List<CoordinateView> trapdoorCoordinates = room.getTrapdoors().stream().map(e->e.getPosition()).collect(Collectors.toList());
        for(int i=0; i<room.getColumns(); i++) {
            for(int j=0; j<room.getRows(); j++) {

                if(!trapdoorCoordinates.contains(new CoordinateView(i,j))) {
                    Box tile = new Box(TILE_SIZE, 3, TILE_SIZE);
                    tile.setMaterial(greenMaterial);
                    Xform tileXform = new Xform();
                    tileXform.getChildren().add(tile);
                    boardXform.getChildren().add(tileXform);
                    tileXform.setTx(TILE_SIZE * i);
                    tileXform.setTz(TILE_SIZE * j);
                    tileXform.setTy(0);
                }
            }
        }

        //Create walls
        for(WallView wall : room.getWalls()) {
            int fromRow = wall.getFrom().getRow();
            int fromColumn = wall.getFrom().getColumn();

            int toRow = wall.getTo().getRow();
            int toColumn = wall.getTo().getColumn();

            int rowDistance = Math.abs(fromRow - toRow);
            int columnDistance = Math.abs(fromColumn - toColumn);

            Box wallBox = new Box(TILE_SIZE * (columnDistance + 1),100, TILE_SIZE * (rowDistance + 1));
            wallBox.setMaterial(greyMaterial);
            Xform boxXform = new Xform();
            boxXform.getChildren().add(wallBox);
            roomXform.getChildren().add(boxXform);
            
            Integer startColumn = 0;
            Integer endColumn;
            Integer startRow = 0;
            Integer endRow;

            int offsetX = 0;
            int offsetZ = 0;

            if(fromRow==toRow)  { //horizontal
                if(fromColumn<toColumn) { startColumn = fromColumn; endColumn = toColumn;}
                else { startColumn = toColumn; endColumn = fromColumn;}
                startRow = fromRow;
                endRow = fromRow;
            } else if(fromColumn==toColumn)  { //vertical
                if(fromRow<toRow) { startRow = fromRow; endRow = toRow;}
                else { startRow = toRow; endRow = fromRow;}
                startColumn = fromColumn;
                endColumn = fromColumn;
            }

            boxXform.setTx(startColumn*TILE_SIZE+columnDistance*TILE_SIZE/2);
            boxXform.setTz(startRow*TILE_SIZE+rowDistance*TILE_SIZE/2);
            boxXform.setTy(50);

        }

        //Create monsters
        for(MonsterView monsterView : room.getMonsters()) {
            try {
            	URL url = this.getClass().getResource("resources/Sledge.obj");
                objImporter.read(url);
            }
            catch (ImportException e) {
                e.printStackTrace();
            }

            Xform monsterXform = new Xform();
            Group sledge = new Group(objImporter.getImport());
            Rotate rx = new Rotate(180, Rotate.X_AXIS);
            sledge.getTransforms().addAll(rx);
            sledge.setScaleX(0.2);
            sledge.setScaleY(0.2);
            sledge.setScaleZ(0.2);
            monsterMap.put(monsterView, sledge);
            monsterXform.getChildren().add(sledge);

            monsterXform.setTx(monsterView.getPosition().getColumn()*TILE_SIZE);
            monsterXform.setTz(monsterView.getPosition().getRow()*TILE_SIZE-TILE_SIZE/2);
            monsterXform.setTy(2);

            roomXform.getChildren().add(monsterXform);

        }

        //Create entry 
        try {
        	URL url = this.getClass().getResource("resources/portalbutton.obj");
            objImporter.read(url);
        }
        catch (ImportException e) {
            e.printStackTrace();
        }

        Xform entryXform = new Xform();
        Group entry = new Group(objImporter.getImport());
        Rotate rx = new Rotate(180, Rotate.X_AXIS);
        entry.getTransforms().addAll(rx);
        entry.setScaleX(0.25);
        entry.setScaleY(0.25);
        entry.setScaleZ(0.25);
        entryXform.getChildren().add(entry);
        entryXform.setTx(room.getEntry().getPosition().getColumn()*TILE_SIZE);
        entryXform.setTz(room.getEntry().getPosition().getRow()*TILE_SIZE);
        entryXform.setTy(5);
        roomXform.getChildren().add(entryXform);

        //Create exit
        try {
        	URL url = this.getClass().getResource("resources/portalbutton.obj");
            objImporter.read(url);
        }
        catch (ImportException e) {
            e.printStackTrace();
        }

        Xform exitXform = new Xform();
        Group exit = new Group(objImporter.getImport());
        exit.getTransforms().addAll(rx);
        exit.setScaleX(0.25);
        exit.setScaleY(0.25);
        exit.setScaleZ(0.25);
        exitXform.getChildren().add(exit);
        exitXform.setTx(room.getExit().getPosition().getColumn()*TILE_SIZE);
        exitXform.setTz(room.getExit().getPosition().getRow()*TILE_SIZE);
        exitXform.setTy(5);
        roomXform.getChildren().add(exitXform);

        //Create Hero
        StlMeshImporter stlMeshImporter = new StlMeshImporter();
        try {
        	URL url = this.getClass().getResource("resources/R2D2.stl");
            stlMeshImporter.read(url);
        }
        catch (ImportException e) {
            e.printStackTrace();
        }

        r2d2 = new Group(new MeshView[] { new MeshView(stlMeshImporter.getImport()) });
        r2d2.getTransforms().addAll(new Rotate(180, Rotate.X_AXIS));
        r2d2.setScaleX(0.2);
        r2d2.setScaleY(0.2);
        r2d2.setScaleZ(0.2);
        r2d2.setTranslateX(room.getEntry().getPosition().getColumn()*TILE_SIZE+27);
        r2d2.setTranslateZ(room.getEntry().getPosition().getRow()*TILE_SIZE+12);
        r2d2.setTranslateY(40);

        roomXform.getChildren().add(r2d2);

        roomXform.setTx(-TILE_SIZE*room.getColumns()/2);
        roomXform.setTz(-TILE_SIZE*room.getRows()/2);
        roomXform.getChildren().add(boardXform);
        roomGroup.getChildren().add(roomXform);
        world.getChildren().addAll(roomGroup);
    }

    public void initialize(RoomView room) {
    	this.room = room;
		hero = createHero();
		traversalActive = false;
		
		root.getChildren().add(world);
		root.setDepthTest(DepthTest.ENABLE);
		
		buildCamera();
		buildRoom();
		
		scene = new SubScene(root, 1024, 768, true, null);
		scene.setFill(Color.WHITE);
		
		handleMouse(scene, world);
		
		scene.setCamera(camera);
     }
     
     public SubScene getSubscene() {
     	return scene;
     }
     
     public HeroView createHero() {
         return new HeroView(room.getEntry().getPosition(), "Hero", 1000, 10, 1, 5, new Sprite(SpriteType.BALDRIC));	

     }


     private Animation buildAnimation() {
         Interpreter interpreter = new GameInterpreter(room, hero);
         interpreter.process();

         List<Action> toExecute = interpreter.nextActions();

         ActionTo3DAnimation actionToAnimation = new ActionTo3DAnimation(r2d2,room,monsterMap);

         SequentialTransition sequentialTransition = new SequentialTransition();
         sequentialTransition.setAutoReverse(false);

         while(toExecute!=null) {

             ParallelTransition parallelTransition = new ParallelTransition();
             for(Action a : toExecute) {
                 parallelTransition.getChildren().add(actionToAnimation.transform(a));
             }

             toExecute = interpreter.nextActions();
             sequentialTransition.getChildren().add(parallelTransition);
         }

         return sequentialTransition;
     }
}
