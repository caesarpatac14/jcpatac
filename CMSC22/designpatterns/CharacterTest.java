package designpatterns;

/**
 * Created by jcpatac on 11/24/2016.
 */
public class CharacterTest {

    public static void main(String[] args) {

        System.out.println("Test 1: Given test");
        Character king = new King();
        king.setWeapon(new KnifeBehavior());
        king.fight();//expect sound of sword

        Character queen = new Queen();
        queen.setWeapon(new BowAndArrowBehavior());
        queen.fight();//expect sound of bow & arrow

        Character knight = new Knight();
        knight.setWeapon(new SwordBehavior());
        knight.fight();//expect sound of axe

        Character troll = new Troll();
        troll.setWeapon(new AxeBehavior());
        troll.fight();// expect sound of knife

        System.out.println("");
        System.out.println("Test 2: Distribution of weapon");

        Character king1 = new King();
        king1.setWeapon(new AxeBehavior());
        king1.fight();

        Character queen1 = new Queen();
        queen1.setWeapon(new SwordBehavior());
        queen1.fight();

        Character knight2 = new Knight();
        knight2.setWeapon(new BowAndArrowBehavior());
        knight2.fight();

        Character troll2 = new Troll();
        troll2.setWeapon(new KnifeBehavior());
        troll2.fight();
    }
}
