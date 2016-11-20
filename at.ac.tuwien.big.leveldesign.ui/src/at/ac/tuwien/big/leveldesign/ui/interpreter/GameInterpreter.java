package at.ac.tuwien.big.leveldesign.ui.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import at.ac.tuwien.big.leveldesign.ui.model.EntryView;
import at.ac.tuwien.big.leveldesign.ui.model.HeroView;
import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;
import at.ac.tuwien.big.leveldesign.ui.model.RoomView;
import at.ac.tuwien.big.leveldesign.ui.traversal.*;
import javafx.util.Pair;

public class GameInterpreter implements Interpreter {

    private RoomView roomView;
    private List<List<Action>> actions;
    private Integer actionCounter;
    private RoomToGraphConverter converter;
    private RoomToGraphConverter converterForMonster;
    private List<Vertex> path;
    private HeroView hero;

    public GameInterpreter(RoomView roomView, HeroView hero) {
        this.roomView = roomView;
        this.actions = new ArrayList<>();
        this.actionCounter = null;
        this.hero = hero;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    @Override
    public void process() {
        actions.clear();
        actionCounter = 0;

        converter = new RoomToGraphConverter(roomView);
        converterForMonster = new RoomToGraphConverter(roomView);
        Graph heroGraph = converter.getGraph(true);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(heroGraph);


        dijkstra.execute(new Vertex(roomView.getEntry().getPosition()));
        path = dijkstra.getPath(new Vertex(roomView.getExit().getPosition()));

        Vertex currentVertex = path.get(0);


        //Check if monsters are pulled at the entry (TODO: refactor this (same code below))
        for(MonsterView monster : getMonstersPulledAtStart()) {

            Fight fight = new Fight(monster);

            fight.setHeroPosition(currentVertex);
            fight.setMonsterPosition(new Vertex(monster.getPosition()));

            fight.setStartHealthPointsHero(hero.getHp());

            // calculate fight stats
            double heroSurvivesSeconds = hero.getHp()/(monster.getDamage()/monster.getSpeed());
            double monsterSurvivesSeconds = monster.getHp()/(hero.getDamage()/hero.getSpeed());

            if(heroSurvivesSeconds>monsterSurvivesSeconds) { //hero wins
                fight.setDamageTakenMonster(monster.getHp());
                fight.setDamageTakenHero(monsterSurvivesSeconds*(monster.getDamage()/monster.getSpeed()));
                hero.setHp(hero.getHp()-fight.getDamageTakenHero());
                monster.setHp(0);
                actions.add(Arrays.asList(fight));
                actions.add(Arrays.asList(new MonsterDie(monster)));
            } else if (monsterSurvivesSeconds>heroSurvivesSeconds) { //monster wins
                fight.setDamageTakenHero(hero.getHp());
                fight.setDamageTakenMonster(heroSurvivesSeconds*(hero.getDamage()/hero.getSpeed()));
                hero.setHp(0);
                actions.add(Arrays.asList(fight));
                actions.add(Arrays.asList(new HeroDie()));
                return; //game over
            } else {
                fight.setDamageTakenMonster(monster.getHp());
                fight.setDamageTakenHero(heroSurvivesSeconds*(monster.getDamage()/monster.getSpeed()));
                hero.setHp(0);
                monster.setHp(0);
                actions.add(Arrays.asList(fight));
                actions.add(Arrays.asList(new HeroDie(), new MonsterDie(monster)));
                return; //game over
            }
        }
        
        
        
        while(currentVertex!=path.get(path.size()-1)) {
            // Calculate node right before next monster pull
            Vertex moveToVertex = nextVertexBeforeMonsterPull(currentVertex);

            // Create subpath for hero
            List<Vertex> subpath = path.subList(path.indexOf(currentVertex), path.indexOf(moveToVertex)+1);
            actions.add(Arrays.asList(new HeroMove(subpath)));

             // After move, check if the hero pulled one or more monster(s), if yes, add monster walk animation + fight animation
            List<MonsterView> pulledMonsters = null;
            if(path.indexOf(moveToVertex)>0) pulledMonsters = getMonstersPulled(path.get(path.indexOf(moveToVertex)-1), moveToVertex);

            if(pulledMonsters!=null && !pulledMonsters.isEmpty()) {
                List<Action> monsterPull = new ArrayList<>();

                for(MonsterView monster : pulledMonsters) {
                    // Add pullpath to MonverMove and update monster position (required later for fight information)
                    List<Vertex> pullPath = calculatePullPath(monster,moveToVertex);
                    monster.setPosition(pullPath.get(pullPath.size()-1).getCoordinate());

                    monsterPull.add(new MonsterMove(pullPath, monster));
                }

                actions.add(monsterPull);

                // currently only supports sequential fight, i.e. monsters are fair and attack the hero one after another ;-)
                for(MonsterView monster : pulledMonsters) {

                    Fight fight = new Fight(monster);

                    fight.setHeroPosition(moveToVertex);
                    fight.setMonsterPosition(new Vertex(monster.getPosition()));

                    fight.setStartHealthPointsHero(hero.getHp());

                    // calculate fight stats
                    double heroSurvivesSeconds = hero.getHp()/(monster.getDamage()/monster.getSpeed());
                    double monsterSurvivesSeconds = monster.getHp()/(hero.getDamage()/hero.getSpeed());

                    if(heroSurvivesSeconds>monsterSurvivesSeconds) { //hero wins
                        fight.setDamageTakenMonster(monster.getHp());
                        fight.setDamageTakenHero(monsterSurvivesSeconds*(monster.getDamage()/monster.getSpeed()));
                        hero.setHp(hero.getHp()-fight.getDamageTakenHero());
                        monster.setHp(0);
                        actions.add(Arrays.asList(fight));
                        actions.add(Arrays.asList(new MonsterDie(monster)));
                    } else if (monsterSurvivesSeconds>heroSurvivesSeconds) { //monster wins
                        fight.setDamageTakenHero(hero.getHp());
                        fight.setDamageTakenMonster(heroSurvivesSeconds*(hero.getDamage()/hero.getSpeed()));
                        hero.setHp(0);
                        actions.add(Arrays.asList(fight));
                        actions.add(Arrays.asList(new HeroDie()));
                        return; //game over
                    } else {
                        fight.setDamageTakenMonster(monster.getHp());
                        fight.setDamageTakenHero(heroSurvivesSeconds*(monster.getDamage()/monster.getSpeed()));
                        hero.setHp(0);
                        monster.setHp(0);
                        actions.add(Arrays.asList(fight));
                        actions.add(Arrays.asList(new HeroDie(), new MonsterDie(monster)));
                        return; //game over
                    }
                }
            }

            currentVertex = moveToVertex;
        }
    }
    
    public List<Pair<Integer, Double>> getStepwiseHPs(RoomView room, HeroView hero) {
    	
    	List<Pair<Integer,Double>> stepHps = new ArrayList<>();
    	int stepCount = 0;
    	double currentHp = hero.getHp();
    	
    	this.roomView = room;
    	this.hero = hero;
    	process();
    	
    	List<Action> toExecute = nextActions();
    	
    	stepHps.add(new Pair<Integer, Double>(0,currentHp));
    	
    	while(toExecute!=null) {
            for(Action a : toExecute) {
            	if(a instanceof HeroMove) {
            		stepCount+= ((HeroMove)a).getPath().size();
            	} else if(a instanceof Fight) {
            		currentHp -= ((Fight)a).getDamageTakenHero();
            	}
            	
            	stepHps.add(new Pair<Integer, Double>(stepCount,currentHp));
            }

            toExecute = nextActions();
        }
    
    	return stepHps.stream().distinct().collect(Collectors.toList());
    	
    }
    
    public Double getPowerNeeded(RoomView room) { 
    	
    	converter = new RoomToGraphConverter(room);
        Graph heroGraph = converter.getGraph(true);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(heroGraph);

        dijkstra.execute(new Vertex(room.getEntry().getPosition()));
        List<MonsterView> monsters = dijkstra.getMonstersPulledOnPath(new Vertex(room.getExit().getPosition()));
    	for(MonsterView m : getMonstersPulledAtStart()) {
    		if(!monsters.contains(m)) monsters.add(m);
    	}
        
    	double powerSum = 0;
    	for(MonsterView monster : monsters) {
    		powerSum += monster.getHp()*(monster.getDamage()/monster.getSpeed());
    	}
    	
    	return powerSum;
    }

    @Override
    public List<Action> nextActions() {
        List<Action> toReturn = null;

        if(actionCounter<actions.size()) {
            toReturn = actions.get(actionCounter);
            actionCounter++;
        }

        return toReturn;
    }

    /**
     * Given a monster and a hero location, calculate the fastest path from the initial monster position
     * to the hero
     *
     * @param monster
     * @param moveToVertex
     * @return
     */
    private List<Vertex> calculatePullPath(MonsterView monster, Vertex moveToVertex) {

        List<Vertex> possibleDestinations = converter.getNeighbours(moveToVertex);
        Integer steps = Integer.MAX_VALUE;
        List<Vertex> path = new ArrayList<>();



        Graph heroGraph = converterForMonster.getGraph(true);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(heroGraph);

        for(Vertex d: possibleDestinations) {
            dijkstra.execute(new Vertex(monster.getPosition()));
            List<Vertex> p = dijkstra.getPath(d);
            if(p.size()<steps) {
                path = p;
                steps = p.size();
            }
        }

        return path;
    }

    /**
     * Returns next vertex to move to.
     * @param current
     * @return Final node, or node at which monsters are pulled
     */
    private Vertex nextVertexBeforeMonsterPull(Vertex current) {

        for(int i=path.indexOf(current); i<path.size(); i++) {

            if(i+1<path.size()) {
                if(!getMonstersPulled(path.get(i), path.get(i+1)).isEmpty()) {
                    return path.get(i+1);
                }
            }
        }

        return path.get(path.size()-1);
    }

    private List<MonsterView> getMonstersPulled(Vertex from, Vertex to) {

        if(converter.getEdgeByVertices(from,to)==null) {
            return null;
        }

        List<MonsterView> livingMonsters = new ArrayList<>();
        
        for(MonsterView m : converter.getEdgeByVertices(from, to).getMonstersToFight()) {
        	if(m.getHp()>0) {
        		livingMonsters.add(m);
        	}
        }
        
        return livingMonsters;
    }
    
    private List<MonsterView> getMonstersPulledAtStart() {
    	List<MonsterView> pulledAtStart = new ArrayList<>(); 
    	
    	EntryView entry = roomView.getEntry();
    	
    	for (MonsterView m : roomView.getMonsters()) {
             int monsterDistance = Math.max(Math.abs(entry.getPosition().getColumn() - m.getPosition().getColumn()), Math.abs(entry.getPosition().getRow() - m.getPosition().getRow()));
             if (monsterDistance <= m.getAggroRadius()) {
                 pulledAtStart.add(m);
             }

         }
    	
    	return pulledAtStart;
    }
}
