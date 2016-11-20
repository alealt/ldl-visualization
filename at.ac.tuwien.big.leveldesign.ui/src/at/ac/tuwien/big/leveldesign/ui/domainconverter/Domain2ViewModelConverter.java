package at.ac.tuwien.big.leveldesign.ui.domainconverter;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.ui.animation.Sprite;
import at.ac.tuwien.big.leveldesign.ui.animation.SpriteType;
import at.ac.tuwien.big.leveldesign.ui.model.CoordinateView;
import at.ac.tuwien.big.leveldesign.ui.model.EntryView;
import at.ac.tuwien.big.leveldesign.ui.model.ExitView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.model.TrapdoorView;
import at.ac.tuwien.big.leveldesign.ui.model.WallView;

public class Domain2ViewModelConverter {
	
	public static CoordinateView coordinate(Coordinate coordinate) {
		return new CoordinateView(coordinate.getColumn(), coordinate.getRow());
	}
	
	public static WallView wall(Wall wall) {
		return new WallView(coordinate(wall.getFrom()), coordinate(wall.getTo()));
	}
	
	public static MonsterView monster(Monster monster) {
		return new MonsterView(coordinate(monster.getPosition()), monster.getName(), monster.getHp(), monster.getDamage(), monster.getSpeed(), monster.getRange(), monster.getAggroRadius(), new Sprite(SpriteType.MAGE));
	}
	
	public static TrapdoorView trapdoor(Trapdoor trapdoor) {
		return new TrapdoorView(coordinate(trapdoor.getPosition()));
	}
	
	public static EntryView entry(Entry entry) {
		return new EntryView(coordinate(entry.getPosition()));
	}
	
	public static ExitView exit(Exit exit) {
		return new ExitView(coordinate(exit.getPosition()));
	}
	
	public static RoomView room(Room room) {
		
		if(room==null) return null;
		
		List<MonsterView> monsters = new ArrayList();
		for(Monster m : room.getMonsters()) {
			monsters.add(monster(m));
		}
		
		List<WallView> walls = new ArrayList();
		for(Wall w : room.getWalls()) {
			walls.add(wall(w));
		}
		
		List<TrapdoorView> trapdoors = new ArrayList();
		for(Trapdoor t : room.getTrapdoors()) {
			trapdoors.add(trapdoor(t));
		}
		
		return new RoomView(room.getName(), room.getColumns(), room.getRows(), walls, monsters, trapdoors, entry(room.getEntry()), exit(room.getExit()), room.getExitConnection()!=null?room(room.getExitConnection().getNextRoom()):null);
	}
	
}
