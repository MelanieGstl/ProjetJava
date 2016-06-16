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

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMap("Press 1, 2, 3, 4 or 5 to choose the level that you want.");
	}

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

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case ONE:
				this.model.loadMap2("ONE");				
			break;
				
			case TWO:
				this.model.loadMap2("TWO");
			break;
				
			case THREE:
				this.model.loadMap2("THREE");
			break;
				
			case FOUR:
				this.model.loadMap2("FOUR");
			break;
			
			case FIVE:
				this.model.loadMap2("FIVE");
			break;
			
			case UP:	
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveUp();
					this.model.setLastMove("UP");
				}
			break;
			
			case LEFT:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveLeft();	
					this.model.setLastMove("LEFT");
				}
			break;
			
			case DOWN:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveDown();	
					this.model.setLastMove("DOWN");
				}
			break;
			
			case RIGHT:
				if(this.model.getLoadMap() == 1)
				{
					this.model.moveRight();
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
