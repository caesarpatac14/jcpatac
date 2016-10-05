public abstract class Hero extends RPGCharacter {
	private int level;

	public Hero(String name, int level, int armor) {
		super(name, level, armor);
		this.level = level;
	}

	public Hero(int level) {
		super(level);
	}

	public Hero() {
	}
}