public class Medications {
    private final String Name;
    private final String Code;
    private final int Weight;

    public Medications(String Name, int weight, String Code) {
        this.Name = Name;
        this.Weight = weight;
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public String getCode() {
        return Code;
    }

    public int getWeight() {
        return Weight;
    }
}
