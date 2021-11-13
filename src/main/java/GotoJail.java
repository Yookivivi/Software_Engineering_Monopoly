public class GotoJail extends JailRelatedSquare {
    public int inJailPosition = 5; // the position of the jail

    /**
     * let the player on the GotoJail go to jail
     * @param p the player on the GotoJail square
     */
    public void updateInJail(Player p){
        p.setPosition(inJailPosition);
        p.setInJail(true);
    }//update the player's state in jail

    /**
     * when the player on the GotoJail square, they need to be sent to Jail
     * @param p the player on the GotoJail
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        updateInJail(p);
        return 0;
    }
}
