package Model;

public class InJail extends JailRelatedSquare {
    /**
     * when player go to the 6th square, they do nothing
     * @param p the player on the square
     * @return 0 for run successfully
     */
    public int takeEffect(Player p){
        return 0;
    }
}
