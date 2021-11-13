public class ActionController {
    public Dice currentDice;

    public void updateMoney(Player p,int changeMoney){
        p.setMoney(p.getMoney()+changeMoney);
    };
    public void updatePosition(Player p,int position){
        p.setPosition(position);
    };
}
