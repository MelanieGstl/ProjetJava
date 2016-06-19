package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

///////////////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////////////

	/**
	* Instantiates a new controller.
	*
	* @param view
	*          the view
	* @param model
	*          the model
	*/
	public Controller(final IView view, final IModel model) {
	this.setView(view);
	this.setModel(model);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	

/////////////////////////////////////////////////////////SETTERS//////////////////////////////////////////////////////////////

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}


////////////////////////////////////////////////////////METHODS///////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMap("Press 1, 2, 3, 4 or 5 to choose the level that you want.");
	}

	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case ONE:
				if(this.model.getLoadMap() == 0)
				{
					this.model.loadMap2("ONE");	
					this.model.setLevel(1);
				}
			break;
				
			case TWO:
				if(this.model.getLoadMap() == 0)
				{
					this.model.loadMap2("TWO");
					this.model.setLevel(2);
				}
			break;
				
			case THREE:
				if(this.model.getLoadMap() == 0)
				{
					this.model.loadMap2("THREE");
					this.model.setLevel(3);
				}
			break;
				
			case FOUR:
				if(this.model.getLoadMap() == 0)
				{
					this.model.loadMap2("FOUR");
					this.model.setLevel(4);
				}
			break;
			
			case FIVE:
				if(this.model.getLoadMap() == 0)
				{
					this.model.loadMap2("FIVE");
					this.model.setLevel(5);
				}
			break;
			
			case UP:	
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveHero("UP");
					this.model.setLastMove("UP");
				}
			break;
			
			case LEFT:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveHero("LEFT");	
					this.model.setLastMove("LEFT");
				}
			break;
			
			case DOWN:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveHero("DOWN");	
					this.model.setLastMove("DOWN");
				}
			break;
			
			case RIGHT:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveHero("RIGHT");
					this.model.setLastMove("RIGHT");
				}
			break;
			
			case SHOOT:
				if(this.model.getLoadMap() == 1)
				{
					this.model.shoot();
				}
			break;
			
			case DIAGO_HD:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveDiagoHD();
					this.model.setLastMove("DIAGOHD");
				}
			break;
			
			case DIAGO_HG:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveDiagoHG();
					this.model.setLastMove("DIAGOHG");
				}
			break;
			
			case DIAGO_BD:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveDiagoBD();
					this.model.setLastMove("DIAGOBD");
				}
			break;
			
			case DIAGO_BG:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveDiagoBG();
					this.model.setLastMove("DIAGOBG");
				}
			break;
			
			default:
				
			break;
		}
	}

}
