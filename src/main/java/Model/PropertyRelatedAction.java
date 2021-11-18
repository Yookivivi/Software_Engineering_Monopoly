package Model;

import Model.ActionController;

public class PropertyRelatedAction extends ActionController {
    public PropertyRelatedAction(Player player) {
        super(player);
    }

    //the player choose to buy the land when she lands on a land square
    public void buyland(Player p, LandSquare l){
        l.setOwner(p);
        updateMoney(p,-l.getPrice());
        updateProperty(p,l);
    }
    
    // update the user property list
    public void updateProperty(Player p, LandSquare l) {
        p.getPropertyList().updateProperty(1, l.getPosition());
    }
}
