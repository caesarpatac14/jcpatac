public abstract class RPGCharacter {
	private String name;
	private int hp;
	private int armor;

	public RPGCharacter(String charName, int charHP, int charArmor) {
		this.name = charName;
		armor = armorSetter(charArmor);
		hp = hpSetter(charHP);
	}

	public RPGCharacter(int level) {
		hp = hpSetter(level);
	}

	public RPGCharacter() {
	}

	public abstract int attack();

	public boolean isAlive() {
		if (hp <= 0) {
			return false;
		}
		return true;
	}

	public int accuracy() {
		return 1;
	}

	public int armorSetter(int armor) {
		return armor;
	}

	public int hpSetter(int level) {
		return level;
	}	

	public int damageTaken(int damage) {
		if (damage <= armor) {
			hp -= 0;
		}else {
			hp -= (damage - armor);
		}
		return hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public String toString() {
		return "[" + "Monster: " + name + '\'' + ", HP: " + hp + "]";
	}
}