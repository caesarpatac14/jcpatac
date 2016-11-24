package designpatterns;

/**
 * Created by jcpatac on 11/24/2016.
 */
public class Knight extends Character {

    @Override
    public void fight() {
        weapon.useWeapon();
    }

    @Override
    public void setWeapon(WeaponBehavior weapon) {
        super.setWeapon(weapon);
    }
}
