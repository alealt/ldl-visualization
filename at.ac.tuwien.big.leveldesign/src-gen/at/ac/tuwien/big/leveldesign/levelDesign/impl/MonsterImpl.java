/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.levelDesign.impl;

import at.ac.tuwien.big.leveldesign.levelDesign.Coordinate;
import at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage;
import at.ac.tuwien.big.leveldesign.levelDesign.Monster;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getHp <em>Hp</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getDamage <em>Damage</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getSpeed <em>Speed</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getRange <em>Range</em>}</li>
 *   <li>{@link at.ac.tuwien.big.leveldesign.levelDesign.impl.MonsterImpl#getAggroRadius <em>Aggro Radius</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MonsterImpl extends MinimalEObjectImpl.Container implements Monster
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPosition()
   * @generated
   * @ordered
   */
  protected Coordinate position;

  /**
   * The default value of the '{@link #getHp() <em>Hp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHp()
   * @generated
   * @ordered
   */
  protected static final int HP_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getHp() <em>Hp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHp()
   * @generated
   * @ordered
   */
  protected int hp = HP_EDEFAULT;

  /**
   * The default value of the '{@link #getDamage() <em>Damage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDamage()
   * @generated
   * @ordered
   */
  protected static final int DAMAGE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDamage() <em>Damage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDamage()
   * @generated
   * @ordered
   */
  protected int damage = DAMAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpeed()
   * @generated
   * @ordered
   */
  protected static final double SPEED_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpeed()
   * @generated
   * @ordered
   */
  protected double speed = SPEED_EDEFAULT;

  /**
   * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRange()
   * @generated
   * @ordered
   */
  protected static final int RANGE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRange()
   * @generated
   * @ordered
   */
  protected int range = RANGE_EDEFAULT;

  /**
   * The default value of the '{@link #getAggroRadius() <em>Aggro Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggroRadius()
   * @generated
   * @ordered
   */
  protected static final int AGGRO_RADIUS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getAggroRadius() <em>Aggro Radius</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAggroRadius()
   * @generated
   * @ordered
   */
  protected int aggroRadius = AGGRO_RADIUS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MonsterImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LevelDesignPackage.Literals.MONSTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate getPosition()
  {
    return position;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPosition(Coordinate newPosition, NotificationChain msgs)
  {
    Coordinate oldPosition = position;
    position = newPosition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__POSITION, oldPosition, newPosition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPosition(Coordinate newPosition)
  {
    if (newPosition != position)
    {
      NotificationChain msgs = null;
      if (position != null)
        msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LevelDesignPackage.MONSTER__POSITION, null, msgs);
      if (newPosition != null)
        msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LevelDesignPackage.MONSTER__POSITION, null, msgs);
      msgs = basicSetPosition(newPosition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__POSITION, newPosition, newPosition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHp()
  {
    return hp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHp(int newHp)
  {
    int oldHp = hp;
    hp = newHp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__HP, oldHp, hp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDamage()
  {
    return damage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDamage(int newDamage)
  {
    int oldDamage = damage;
    damage = newDamage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__DAMAGE, oldDamage, damage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getSpeed()
  {
    return speed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpeed(double newSpeed)
  {
    double oldSpeed = speed;
    speed = newSpeed;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__SPEED, oldSpeed, speed));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRange()
  {
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRange(int newRange)
  {
    int oldRange = range;
    range = newRange;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__RANGE, oldRange, range));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getAggroRadius()
  {
    return aggroRadius;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggroRadius(int newAggroRadius)
  {
    int oldAggroRadius = aggroRadius;
    aggroRadius = newAggroRadius;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LevelDesignPackage.MONSTER__AGGRO_RADIUS, oldAggroRadius, aggroRadius));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LevelDesignPackage.MONSTER__POSITION:
        return basicSetPosition(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LevelDesignPackage.MONSTER__NAME:
        return getName();
      case LevelDesignPackage.MONSTER__POSITION:
        return getPosition();
      case LevelDesignPackage.MONSTER__HP:
        return getHp();
      case LevelDesignPackage.MONSTER__DAMAGE:
        return getDamage();
      case LevelDesignPackage.MONSTER__SPEED:
        return getSpeed();
      case LevelDesignPackage.MONSTER__RANGE:
        return getRange();
      case LevelDesignPackage.MONSTER__AGGRO_RADIUS:
        return getAggroRadius();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LevelDesignPackage.MONSTER__NAME:
        setName((String)newValue);
        return;
      case LevelDesignPackage.MONSTER__POSITION:
        setPosition((Coordinate)newValue);
        return;
      case LevelDesignPackage.MONSTER__HP:
        setHp((Integer)newValue);
        return;
      case LevelDesignPackage.MONSTER__DAMAGE:
        setDamage((Integer)newValue);
        return;
      case LevelDesignPackage.MONSTER__SPEED:
        setSpeed((Double)newValue);
        return;
      case LevelDesignPackage.MONSTER__RANGE:
        setRange((Integer)newValue);
        return;
      case LevelDesignPackage.MONSTER__AGGRO_RADIUS:
        setAggroRadius((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LevelDesignPackage.MONSTER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LevelDesignPackage.MONSTER__POSITION:
        setPosition((Coordinate)null);
        return;
      case LevelDesignPackage.MONSTER__HP:
        setHp(HP_EDEFAULT);
        return;
      case LevelDesignPackage.MONSTER__DAMAGE:
        setDamage(DAMAGE_EDEFAULT);
        return;
      case LevelDesignPackage.MONSTER__SPEED:
        setSpeed(SPEED_EDEFAULT);
        return;
      case LevelDesignPackage.MONSTER__RANGE:
        setRange(RANGE_EDEFAULT);
        return;
      case LevelDesignPackage.MONSTER__AGGRO_RADIUS:
        setAggroRadius(AGGRO_RADIUS_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LevelDesignPackage.MONSTER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LevelDesignPackage.MONSTER__POSITION:
        return position != null;
      case LevelDesignPackage.MONSTER__HP:
        return hp != HP_EDEFAULT;
      case LevelDesignPackage.MONSTER__DAMAGE:
        return damage != DAMAGE_EDEFAULT;
      case LevelDesignPackage.MONSTER__SPEED:
        return speed != SPEED_EDEFAULT;
      case LevelDesignPackage.MONSTER__RANGE:
        return range != RANGE_EDEFAULT;
      case LevelDesignPackage.MONSTER__AGGRO_RADIUS:
        return aggroRadius != AGGRO_RADIUS_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", hp: ");
    result.append(hp);
    result.append(", damage: ");
    result.append(damage);
    result.append(", speed: ");
    result.append(speed);
    result.append(", range: ");
    result.append(range);
    result.append(", aggroRadius: ");
    result.append(aggroRadius);
    result.append(')');
    return result.toString();
  }

} //MonsterImpl