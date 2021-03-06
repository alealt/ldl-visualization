/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.levelDesign.impl;

import at.ac.tuwien.big.leveldesign.levelDesign.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LevelDesignFactoryImpl extends EFactoryImpl implements LevelDesignFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LevelDesignFactory init()
  {
    try
    {
      LevelDesignFactory theLevelDesignFactory = (LevelDesignFactory)EPackage.Registry.INSTANCE.getEFactory(LevelDesignPackage.eNS_URI);
      if (theLevelDesignFactory != null)
      {
        return theLevelDesignFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LevelDesignFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LevelDesignFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LevelDesignPackage.LEVEL: return createLevel();
      case LevelDesignPackage.ROOM: return createRoom();
      case LevelDesignPackage.CONNECTION: return createConnection();
      case LevelDesignPackage.MONSTER: return createMonster();
      case LevelDesignPackage.TRAPDOOR: return createTrapdoor();
      case LevelDesignPackage.WALL: return createWall();
      case LevelDesignPackage.ENTRY: return createEntry();
      case LevelDesignPackage.EXIT: return createExit();
      case LevelDesignPackage.COORDINATE: return createCoordinate();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Level createLevel()
  {
    LevelImpl level = new LevelImpl();
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Room createRoom()
  {
    RoomImpl room = new RoomImpl();
    return room;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connection createConnection()
  {
    ConnectionImpl connection = new ConnectionImpl();
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Monster createMonster()
  {
    MonsterImpl monster = new MonsterImpl();
    return monster;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trapdoor createTrapdoor()
  {
    TrapdoorImpl trapdoor = new TrapdoorImpl();
    return trapdoor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Wall createWall()
  {
    WallImpl wall = new WallImpl();
    return wall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entry createEntry()
  {
    EntryImpl entry = new EntryImpl();
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exit createExit()
  {
    ExitImpl exit = new ExitImpl();
    return exit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate createCoordinate()
  {
    CoordinateImpl coordinate = new CoordinateImpl();
    return coordinate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LevelDesignPackage getLevelDesignPackage()
  {
    return (LevelDesignPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LevelDesignPackage getPackage()
  {
    return LevelDesignPackage.eINSTANCE;
  }

} //LevelDesignFactoryImpl
