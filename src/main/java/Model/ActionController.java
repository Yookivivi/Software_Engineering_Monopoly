package Model;

public class ActionController {
    public Dice currentDice;
    private Player p;

    public ActionController(Player player){
        this.p = player;
    }

    public void updateMoney(Player p, int changeMoney){
        p.setMoney(p.getMoney()+changeMoney);
    };
    public void updatePosition(Player p, int position){
        p.setPosition(position);
    };
}
