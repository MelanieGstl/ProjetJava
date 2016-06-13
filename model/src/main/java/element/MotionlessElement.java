package element;

public abstract class MotionlessElement extends Element {
	private final char fileSymbol;

	public MotionlessElement(final Sprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}

	/*public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}*/
}
