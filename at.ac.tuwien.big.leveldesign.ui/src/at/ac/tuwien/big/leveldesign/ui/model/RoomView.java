package at.ac.tuwien.big.leveldesign.ui.model;

import java.util.List;

/**
 * Created by alexander on 23/06/16.
 */
public class RoomView {

    int columns;
    int rows;
    
    String roomName;

    List<WallView> walls;
    List<MonsterView> monsters;
    List<TrapdoorView> trapdoors;
    EntryView entry;
    ExitView exit;
    RoomView nextRoom;
    
	public RoomView(String roomName, int columns, int rows, List<WallView> walls, List<MonsterView> monsters, List<TrapdoorView> trapdoors, EntryView entry, ExitView exit, RoomView nextRoom) {
        this.roomName = roomName;
		this.columns = columns;
        this.rows = rows;
        this.walls = walls;
        this.monsters = monsters;
        this.trapdoors = trapdoors;
        this.entry = entry;
        this.exit = exit;
        this.nextRoom = nextRoom;
    }
	
	

    public String getName() {
		return roomName;
	}

	public void setName(String roomName) {
		this.roomName = roomName;
	}

	public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<WallView> getWalls() {
        return walls;
    }

    public void setWalls(List<WallView> walls) {
        this.walls = walls;
    }

    public List<MonsterView> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterView> monsters) {
        this.monsters = monsters;
    }

    public List<TrapdoorView> getTrapdoors() {
        return trapdoors;
    }

    public void setTrapdoors(List<TrapdoorView> trapdoors) {
        this.trapdoors = trapdoors;
    }

    public EntryView getEntry() {
        return entry;
    }

    public void setEntry(EntryView entry) {
        this.entry = entry;
    }

    public ExitView getExit() {
        return exit;
    }

    public void setExit(ExitView exit) {
        this.exit = exit;
    }
    
    public RoomView getNextRoom() {
		return nextRoom;
	}

	public void setNextRoom(RoomView nextRoom) {
		this.nextRoom = nextRoom;
	}

}
