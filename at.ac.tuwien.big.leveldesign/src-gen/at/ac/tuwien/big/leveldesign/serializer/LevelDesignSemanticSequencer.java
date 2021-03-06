/*
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.serializer;

import at.ac.tuwien.big.leveldesign.levelDesign.Connection;
import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.Entry;
import at.ac.tuwien.big.leveldesign.levelDesign.Exit;
import at.ac.tuwien.big.leveldesign.levelDesign.Level;
import at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;
import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import at.ac.tuwien.big.leveldesign.levelDesign.Trapdoor;
import at.ac.tuwien.big.leveldesign.levelDesign.Wall;
import at.ac.tuwien.big.leveldesign.services.LevelDesignGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class LevelDesignSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private LevelDesignGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == LevelDesignPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case LevelDesignPackage.CONNECTION:
				sequence_Connection(context, (Connection) semanticObject); 
				return; 
			case LevelDesignPackage.COORDINATE:
				sequence_Coordinate(context, (Coordinate) semanticObject); 
				return; 
			case LevelDesignPackage.ENTRY:
				sequence_Entry(context, (Entry) semanticObject); 
				return; 
			case LevelDesignPackage.EXIT:
				sequence_Exit(context, (Exit) semanticObject); 
				return; 
			case LevelDesignPackage.LEVEL:
				sequence_Level(context, (Level) semanticObject); 
				return; 
			case LevelDesignPackage.MONSTER:
				sequence_Monster(context, (Monster) semanticObject); 
				return; 
			case LevelDesignPackage.ROOM:
				sequence_Room(context, (Room) semanticObject); 
				return; 
			case LevelDesignPackage.TRAPDOOR:
				sequence_Trapdoor(context, (Trapdoor) semanticObject); 
				return; 
			case LevelDesignPackage.WALL:
				sequence_Wall(context, (Wall) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Connection returns Connection
	 *
	 * Constraint:
	 *     (type=STRING nextRoom=[Room|ID])
	 */
	protected void sequence_Connection(ISerializationContext context, Connection semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.CONNECTION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.CONNECTION__TYPE));
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.CONNECTION__NEXT_ROOM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.CONNECTION__NEXT_ROOM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConnectionAccess().getTypeSTRINGTerminalRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getConnectionAccess().getNextRoomRoomIDTerminalRuleCall_2_0_1(), semanticObject.getNextRoom());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Coordinate returns Coordinate
	 *
	 * Constraint:
	 *     ((column=INT row=INT) | (column=INT row=INT))
	 */
	protected void sequence_Coordinate(ISerializationContext context, Coordinate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Entry returns Entry
	 *
	 * Constraint:
	 *     (name=ID position=Coordinate)
	 */
	protected void sequence_Entry(ISerializationContext context, Entry semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.ENTRY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.ENTRY__NAME));
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.ENTRY__POSITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.ENTRY__POSITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEntryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEntryAccess().getPositionCoordinateParserRuleCall_3_0(), semanticObject.getPosition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exit returns Exit
	 *
	 * Constraint:
	 *     (name=ID position=Coordinate)
	 */
	protected void sequence_Exit(ISerializationContext context, Exit semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.EXIT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.EXIT__NAME));
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.EXIT__POSITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.EXIT__POSITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExitAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getExitAccess().getPositionCoordinateParserRuleCall_3_0(), semanticObject.getPosition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Level returns Level
	 *
	 * Constraint:
	 *     (spawnRoom=[Room|ID] goalRoom=[Room|ID] rooms+=Room+)
	 */
	protected void sequence_Level(ISerializationContext context, Level semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Monster returns Monster
	 *
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         position=Coordinate 
	 *         hp=INT 
	 *         damage=INT 
	 *         speed=DOUBLE 
	 *         range=INT 
	 *         aggroRadius=INT
	 *     )
	 */
	protected void sequence_Monster(ISerializationContext context, Monster semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Room returns Room
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         columns=INT 
	 *         rows=INT 
	 *         entry=Entry 
	 *         exit=Exit 
	 *         exitConnection=Connection? 
	 *         walls+=Wall* 
	 *         trapdoors+=Trapdoor* 
	 *         monsters+=Monster*
	 *     )
	 */
	protected void sequence_Room(ISerializationContext context, Room semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Trapdoor returns Trapdoor
	 *
	 * Constraint:
	 *     (name=ID? position=Coordinate)
	 */
	protected void sequence_Trapdoor(ISerializationContext context, Trapdoor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Wall returns Wall
	 *
	 * Constraint:
	 *     (name=ID from=Coordinate to=Coordinate)
	 */
	protected void sequence_Wall(ISerializationContext context, Wall semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.WALL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.WALL__NAME));
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.WALL__FROM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.WALL__FROM));
			if (transientValues.isValueTransient(semanticObject, LevelDesignPackage.Literals.WALL__TO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LevelDesignPackage.Literals.WALL__TO));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWallAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getWallAccess().getFromCoordinateParserRuleCall_3_0(), semanticObject.getFrom());
		feeder.accept(grammarAccess.getWallAccess().getToCoordinateParserRuleCall_5_0(), semanticObject.getTo());
		feeder.finish();
	}
	
	
}
