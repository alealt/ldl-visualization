/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.levelDesign;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Level#getSpawnRoom <em>Spawn Room</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Level#getGoalRoom <em>Goal Room</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Level#getRooms <em>Rooms</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getLevel()
 * @model
 * @generated
 */
public interface Level extends EObject
{
  /**
   * Returns the value of the '<em><b>Spawn Room</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Spawn Room</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spawn Room</em>' reference.
   * @see #setSpawnRoom(Room)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getLevel_SpawnRoom()
   * @model
   * @generated
   */
  Room getSpawnRoom();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Level#getSpawnRoom <em>Spawn Room</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spawn Room</em>' reference.
   * @see #getSpawnRoom()
   * @generated
   */
  void setSpawnRoom(Room value);

  /**
   * Returns the value of the '<em><b>Goal Room</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Goal Room</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Goal Room</em>' reference.
   * @see #setGoalRoom(Room)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getLevel_GoalRoom()
   * @model
   * @generated
   */
  Room getGoalRoom();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Level#getGoalRoom <em>Goal Room</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Goal Room</em>' reference.
   * @see #getGoalRoom()
   * @generated
   */
  void setGoalRoom(Room value);

  /**
   * Returns the value of the '<em><b>Rooms</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.leveldesign.levelDesign.Room}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rooms</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rooms</em>' containment reference list.
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getLevel_Rooms()
   * @model containment="true"
   * @generated
   */
  EList<Room> getRooms();

} // Level