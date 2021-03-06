/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.levelDesign;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monster</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getPosition <em>Position</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getHp <em>Hp</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getDamage <em>Damage</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getSpeed <em>Speed</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getRange <em>Range</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getAggroRadius <em>Aggro Radius</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster()
 * @model
 * @generated
 */
public interface Monster extends EObject
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
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getName <em>Name</em>}' attribute.
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
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Position()
   * @model containment="true"
   * @generated
   */
  Coordinate getPosition();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getPosition <em>Position</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Position</em>' containment reference.
   * @see #getPosition()
   * @generated
   */
  void setPosition(Coordinate value);

  /**
   * Returns the value of the '<em><b>Hp</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hp</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hp</em>' attribute.
   * @see #setHp(int)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Hp()
   * @model
   * @generated
   */
  int getHp();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getHp <em>Hp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hp</em>' attribute.
   * @see #getHp()
   * @generated
   */
  void setHp(int value);

  /**
   * Returns the value of the '<em><b>Damage</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Damage</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Damage</em>' attribute.
   * @see #setDamage(int)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Damage()
   * @model
   * @generated
   */
  int getDamage();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getDamage <em>Damage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Damage</em>' attribute.
   * @see #getDamage()
   * @generated
   */
  void setDamage(int value);

  /**
   * Returns the value of the '<em><b>Speed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Speed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Speed</em>' attribute.
   * @see #setSpeed(double)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Speed()
   * @model
   * @generated
   */
  double getSpeed();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getSpeed <em>Speed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Speed</em>' attribute.
   * @see #getSpeed()
   * @generated
   */
  void setSpeed(double value);

  /**
   * Returns the value of the '<em><b>Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' attribute.
   * @see #setRange(int)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_Range()
   * @model
   * @generated
   */
  int getRange();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getRange <em>Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' attribute.
   * @see #getRange()
   * @generated
   */
  void setRange(int value);

  /**
   * Returns the value of the '<em><b>Aggro Radius</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggro Radius</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggro Radius</em>' attribute.
   * @see #setAggroRadius(int)
   * @see at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage#getMonster_AggroRadius()
   * @model
   * @generated
   */
  int getAggroRadius();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.leveldesign.levelDesign.Monster#getAggroRadius <em>Aggro Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggro Radius</em>' attribute.
   * @see #getAggroRadius()
   * @generated
   */
  void setAggroRadius(int value);

} // Monster
