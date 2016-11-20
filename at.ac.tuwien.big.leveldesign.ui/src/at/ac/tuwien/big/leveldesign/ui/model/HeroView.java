package at.ac.tuwien.big.leveldesign.ui.model;

import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;

/**
 * Created by alexander on 27/06/16.
 */
public class HeroView {
    private CoordinateView position;
    private String name;
    private double hp;
    private int damage;
    private double speed;
    private int range;
    private Sprite sprite;

    public HeroView(CoordinateView position, String name, double hp, int damage, double speed, int range, Sprite sprite) {
        this.position = position;
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
        this.sprite = sprite;
    }

    public HeroView() {
	}

	public CoordinateView getPosition() {
        return position;
    }

    public void setPosition(CoordinateView position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroView heroView = (HeroView) o;

        if (hp != heroView.hp) return false;
        if (damage != heroView.damage) return false;
        if (Double.compare(heroView.speed, speed) != 0) return false;
        if (range != heroView.range) return false;
        if (position != null ? !position.equals(heroView.position) : heroView.position != null) return false;
        return name != null ? name.equals(heroView.name) : heroView.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = position != null ? position.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(hp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + damage;
        temp = Double.doubleToLongBits(speed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + range;
        return result;
    }
}
