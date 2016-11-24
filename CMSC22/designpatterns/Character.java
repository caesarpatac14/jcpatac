package designpatterns;

/**
 * Created by jcpatac on 11/24/2016.
 */
public abstract class Character {

    WeaponBehavior weapon;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
