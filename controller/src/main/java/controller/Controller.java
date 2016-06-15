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
				this.model.moveUp();
				this.model.setLastMove("UP");
			break;
			
			case LEFT:
				this.model.moveLeft();	
				this.model.setLastMove("LEFT");
			break;
			
			case DOWN:
				this.model.moveDown();	
				this.model.setLastMove("DOWN");
			break;
			
			case RIGHT:
				this.model.moveRight();
				this.model.setLastMove("RIGHT");
			break;
			
			case SHOOT:
				this.model.shoot();
			break;
			
			default:
				
			break;
		}
	}

}
