public class Item {
    // Name of the item.
    private final String name;

    // Weight of the item.
    private final int weight;

    // Initializes the Item object.
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
