package at.ac.tuwien.big.leveldesign.ui.animation;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int count;
    private Direction direction;
    private final int width;
    private final int height;
    private final String imageString;

    private boolean updatedImageView;

    private int lastIndex;

    public SpriteAnimation(ImageView imageView, String imageString, Duration duration,
                           int count, int width, int height, Direction direction) {
        this.imageView = imageView;
        this.count     = count;
        this.direction = direction;
        this.width     = width;
        this.height    = height;
        this.imageString = imageString;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
        this.updatedImageView = false;
    }

    protected void interpolate(double k) {

        // TODO: this needs to be fixed as interpolate is basically callled all the time. Do not know yet where to change image (onStart does not seem to exist)
        this.imageView.setImage(new Image(imageString));

        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % count) * width;
            final int y = direction==null?0:(direction.ordinal()) * height;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ImageView getImageView() {
        return imageView;
    }
}