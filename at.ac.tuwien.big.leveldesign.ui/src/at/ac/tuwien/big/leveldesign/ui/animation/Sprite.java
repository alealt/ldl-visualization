package at.ac.tuwien.big.leveldesign.ui.animation;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by alexander on 12/06/16.
 */
public class Sprite {

    private static final int SPRITE_HEIGHT = 64;
    private static final int SPRITE_WIDTH = 64;
    private static final int TILE_SIZE = 32;

    private String FALL;
    private String SLASH;
    private String SPELL;
    private String WALK;

    private SpriteType spriteType;
    private ImageView imageView;

    private int durationPerTile = 500;

    private Duration durationMillis = Duration.millis(durationPerTile);

    public Sprite(SpriteType type) {
        this.spriteType = type;

        String character = "Baldric"; //default

        if(type==SpriteType.MAGE) {
            character = "Mage";
        } else if(type==SpriteType.BALDRIC) {
            character = "Baldric";
        }

        FALL = "sprites/"+character+"Fall.png";
        SLASH = "sprites/"+character+"Slash.png";
        SPELL = "sprites/"+character+"Spell.png";
        WALK = "sprites/"+character+"Walk.png";

        imageView = new ImageView();
        imageView.setFitHeight(TILE_SIZE);
        imageView.setFitWidth(TILE_SIZE);
        setToInitialPosition();
    }
    
    public void setDurationPerTile(int durationPerTile) {
    	this.durationPerTile = durationPerTile;
    	this.durationMillis = Duration.millis(durationPerTile);
    }
    
    public int getDurationPerTile() {
    	return durationPerTile;
    }

    public void setToInitialPosition() {
        imageView.setImage(new Image(WALK));
        imageView.setViewport(new Rectangle2D(0, Direction.DOWN.ordinal()*SPRITE_HEIGHT, SPRITE_WIDTH, SPRITE_HEIGHT));
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Animation getFallAnimation() {
        Animation animation = new SpriteAnimation(imageView, FALL, Duration.millis(durationPerTile*4),
                6, SPRITE_WIDTH, SPRITE_HEIGHT, null);
        animation.setCycleCount(1);
        animation.setAutoReverse(false);
        return animation;
    }

    public Animation getSlashAnimation(Direction initialDirection) {
        if(spriteType==SpriteType.MAGE) throw new RuntimeException("Type not supported");

        Animation animation = new SpriteAnimation(imageView, SLASH, durationMillis,
                6, SPRITE_WIDTH, SPRITE_HEIGHT, initialDirection);
        animation.setAutoReverse(false);
        return animation;
    }

    public Animation getSpellAnimation(Direction initialDirection) {
        Animation animation = new SpriteAnimation(imageView, SPELL, durationMillis,
                7, SPRITE_WIDTH, SPRITE_HEIGHT, initialDirection);
        animation.setAutoReverse(false);
        return animation;
    }

    public Animation getWalkAnimation(Direction initialDirection) {
        Animation animation = new SpriteAnimation(imageView, WALK, durationMillis,
                9, SPRITE_WIDTH, SPRITE_HEIGHT, initialDirection);
        animation.setAutoReverse(false);
        return animation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sprite sprite = (Sprite) o;

        return spriteType == sprite.spriteType;

    }

    @Override
    public int hashCode() {
        return spriteType != null ? spriteType.hashCode() : 0;
    }
}
