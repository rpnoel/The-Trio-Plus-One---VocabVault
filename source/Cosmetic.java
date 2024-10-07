public class Cosmetic {
    private CosmeticType type;
    private int cost;

    public Cosmetic(CosmeticType type, int cost){
        this.type = type;
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }

    public CosmeticType getType(){
        return type;
      }
}
