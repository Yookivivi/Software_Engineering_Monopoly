package Model;

import Model.ActionController;

public class PropertyRelatedAction extends ActionController {
    public PropertyRelatedAction(Player player) {
        super(player);
    }

    public void buyland(Player p, LandSquare l){
        l.setOwner(p);
        updateMoney(p,-l.getPrice());
        updateProperty(p,l);
    }
    public void updateProperty(Player p, LandSquare l) {
        p.getPropertyList().updateProperty(1, l.getPosition());
    }// update the user property list
}
