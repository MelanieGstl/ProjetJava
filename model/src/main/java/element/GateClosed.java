package element;

public class GateClosed extends MotionlessElement {
	public GateClosed() {
		super(new Sprite("c", "gate_closed.png"), Permeability.BLOCKING, 'c');
	}
	
}
