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
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
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
				this.model.loadMessage("ONE");
			break;
				
			case TWO:
				this.model.loadMessage("TWO");
			break;
				
			case THREE:
				this.model.loadMessage("THREE");
			break;
				
			case FOUR:
				this.model.loadMessage("FOUR");
			break;
			
			case FIVE:
				this.model.loadMessage("FIVE");
			break;

			default:
				break;
		}
	}
	//fffffff
	
	public void displayMap()
	{
		char[][] map = model.getMap();
		
		for (int i =0; i < model.getHeight(); i++)
        {
            for (int j = 0; j < model.getWidth(); j++)
            {
            	System.out.print(map[i][j]);
            }
            
            System.out.println();
        }
	}

}
