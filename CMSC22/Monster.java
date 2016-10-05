public class Monster extends RPGCharacter {
	private int attackDamage;
	private static int armor = 5;

	public Monster(String name, int hp) {
		super(name, hp, armor);
	}

	public Monster(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int attack() {
		return attackDamage;
	}
}