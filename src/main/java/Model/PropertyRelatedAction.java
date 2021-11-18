package Model;

import Model.ActionController;

/**
 * This class is for property related action
 */

public class PropertyRelatedAction extends ActionController {
    /**
     * Constructor for PropertyRelatedAction
     * @param player action related player
     */
    public PropertyRelatedAction(Player player) {
        super(player);
    }

    /**
     * buy land operation
     * @param p action related player
     * @param l land square to be bought
     */
    public void buyland(Player p, LandSquare l){
        l.setOwner(p);
        updateMoney(p,-l.getPrice());
        updateProperty(p,l);
    }

    /**
     * add land to player's property list
     * @param p action related player
     * @param l land square to be added
     */
    public void updateProperty(Player p, LandSquare l) {
        p.getPropertyList().updateProperty(1, l.getPosition());
    }// update the user property list
}
