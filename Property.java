public class Property {
    private int landNum;//the number of lands
    private int[] lands;// the indexes of lands owned by the player

    public void updateProperty(int mode, int position){};//change the property list
    public void printProperty(){};//print the property list
    public int getLandNum(){
        return landNum;
    };
    public int[] getProperty(){
        return lands;
    };
}
