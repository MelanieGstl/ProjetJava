package element;

public class Bone extends MotionlessElement {

	public Bone() {
		super(new Sprite("b", "bone.png"), Permeability.BLOCKING, 'b');
	}
	
}
