public class Archer extends Hero {
	private static int heroAttack = 10;
	private static int armor = 3;
	private static int heroLevel = 1;
	private int skill;
	private String name;
	private static int hp = 54;
	private static int manaHero = 14;

	private static int manaCtr = 0;
	private static int hpCtr = 0;
	private static int myLevel = 1;


	public Archer(String name, int level) {
		super(name, level, armor);
		this.name = name;
	}

	public Archer(int skill, int nothing) {
		super();
		this.skill = skill;
		heroLevel = nothing;
	}

	public Archer(int level) {
		super(level);
	}

	public int getLevel() {
		return heroLevel;
	}

	public void setLevel(int level) {
		this.heroLevel = level;
	}

	public int hpSetter(int level) {
		if (level > myLevel) {
			myLevel += 2;
			manaCtr++;
			hpCtr += 5;
			hp = 54 + hpCtr;
			heroAttack += 10;
			manaHero = 14 + manaCtr;

			if (heroLevel <= 20) {
				manaHero += 3;
			}else if (heroLevel > 20 && heroLevel <= 40) {
				manaHero += 5;
			}else if (heroLevel > 40 && heroLevel <= 60) {
				manaHero += 7;
			}else if (heroLevel > 60 && heroLevel <= 80) {
				manaHero += 9;
			}else {
				manaHero += 10;
			}
		}else {
			hp = 54;
		}
		return hp;
	}

	public int armorSetter(int defense) {
		if (heroLevel == 20) {
			armor = defense + 1;
		}else if (heroLevel == 40) {
			armor = defense + 2;
		}else if (heroLevel == 60) {
			armor = defense + 3;
		}else if (heroLevel == 80) {
			armor = defense + 4;
		}else if (heroLevel == 100){
			armor = defense + 5;
		}else {
			armor = 3;
		}
		return armor;
	}

	public int accuracy() {
		if (heroLevel >= 1 && heroLevel <= 20) {
			return 2;
		}else if (heroLevel >= 21 && heroLevel <= 40) {
			return 3;
		}else if (heroLevel >= 41 && heroLevel <= 60) {
			return 4;
		}else if (heroLevel >= 61 && heroLevel <= 80) {
			return 5;
		}
		return 6;
	}


	public int attack() { //print skills
		// System.out.println("heroLevel: " + heroLevel);
		int heroDamage = 0;
		// I stopped here
		if (skill == 1) {
			if (manaHero >= 10 && heroLevel >= 1) {
				System.out.println("Quickshot! (+30 dmg)");
				System.out.println("");
				heroDamage += heroAttack + 30;
				manaHero -= 10;
			}else {
				System.out.println("Not enough mana!");
				heroDamage = 0;
			}
		}else if (skill == 2) {
			if (manaHero >= 20 && heroLevel >= 2) {
				System.out.println("Healing Jutsu");
				System.out.println("");
				hp += 20;
				manaHero += 5;
				manaHero -= 20;
			}else {
				System.out.println("Not enough mana!");
				heroDamage = 0;
			}
		}else if (skill == 3 && heroLevel >= 7) {
			if (manaHero >= 50) {
				System.out.println("Deadly Shot! (+80 dmg)");
				System.out.println("");
				heroDamage += heroAttack + 90;
				manaHero -= 50;
			}else {
				System.out.println("Not enough mana!");
				heroDamage = 0;
			}
		}else if (skill == 4) {
			if (manaHero >= 80 && heroLevel >= 9) {
				System.out.println("Blood Vow! (+120 dmg)");
				System.out.println("");
				heroDamage += heroAttack + 120;
				manaHero -= 80;
			}else {
				System.out.println("Not enough mana!");
				heroDamage = 0;
			}
		}else if (skill == 5 && heroLevel >= 10) {
			if (manaHero >= 100) {
				System.out.println("Arrow Inferno! (+200 dmg)");
				System.out.println("");
				heroDamage += 200;
				manaHero -= 100;
			}else {
				System.out.println("Not enough mana!");
				heroDamage = 0;
			}
		}else {
			heroDamage = heroAttack;
		}
		manaHero += 2;
		return heroDamage;
	}

	public int damageTaken(int damage) {
		if (damage <= armor) {
			hp -= 0;
		}else {
			hp -= (damage - armor);
		}
		return hp;
	}

	public String toString() {
		return "[" + "Hero: " + name + '\'' +  ", LVL: " + heroLevel + ", HP: " + hp + ", Mana: " + manaHero + "]" + "\n";
	}
}