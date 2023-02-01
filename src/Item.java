public class Item {

    /**
     * Represents the weight of the item.
     */
    private final int weight;

    /**
     * Initializes an {@link Item} object.
     *
     * @param name   Name of the item.
     * @param weight Weight of the item.
     */
    public Item(String name, int weight) {
        this.weight = weight;
    }

    /**
     * Returns the weight of the item.
     */
    public int getWeight() {
        return weight;
    }
}
