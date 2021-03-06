/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.levelDesign;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Entry#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Entry#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getEntry_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Entry#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Position</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Position</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Position</em>' containment reference.
   * @see #setPosition(Coordinate)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getEntry_Position()
   * @model containment="true"
   * @generated
   */
  Coordinate getPosition();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Entry#getPosition <em>Position</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Position</em>' containment reference.
   * @see #getPosition()
   * @generated
   */
  void setPosition(Coordinate value);

} // Entry
