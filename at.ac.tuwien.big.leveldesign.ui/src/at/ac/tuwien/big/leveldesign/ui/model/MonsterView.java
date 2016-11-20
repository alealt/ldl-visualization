package at.ac.tuwien.big.leveldesign.ui.model;

import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;

public class MonsterView {
	private CoordinateView position;
	private String name;
	private double hp;
	private int damage;
	private double speed;
	private int range;
	private int aggroRadius;
	private Sprite sprite;
	
	public MonsterView(CoordinateView position, String name, double hp, int damage, double speed, int range,
			int aggroRadius, Sprite sprite) {
		this.position = position;
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.speed = speed;
		this.range = range;
		this.aggroRadius = aggroRadius;
		this.sprite = sprite;
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
	public void setHp(int hp) {
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
	public int getAggroRadius() {
		return aggroRadius;
	}
	public void setAggroRadius(int aggroRadius) {
		this.aggroRadius = aggroRadius;
	}

	public Sprite getSprite() {
		return sprite;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MonsterView that = (MonsterView) o;

		if (damage != that.damage) return false;
		if (Double.compare(that.speed, speed) != 0) return false;
		if (range != that.range) return false;
		if (aggroRadius != that.aggroRadius) return false;
		return name != null ? name.equals(that.name) : that.name == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name != null ? name.hashCode() : 0;
		result = 31 * result + damage;
		temp = Double.doubleToLongBits(speed);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + range;
		result = 31 * result + aggroRadius;
		return result;
	}
}
