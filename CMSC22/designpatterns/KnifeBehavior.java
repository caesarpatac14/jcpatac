package designpatterns;

/**
 * Created by jcpatac on 11/24/2016.
 */
public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Whook!");
    }
}
