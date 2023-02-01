public class Rocket implements Spaceship {

    /**
     * Represents the cost of spaceship.
     */
    private final double cost;

    /**
     * Represents the current weight of spaceship.
     */
    private int weight;

    /**
     * Represents the maximum weight that the spaceship can hold.
     */
    private final int weightCargo;

    /**
     * Initializes a Rocket object.
     *
     * @param cost        Cost of the spaceship.
     * @param weight      Current weight of the spaceship.
     * @param weightCargo Maximum weight that the spaceship can hold.
     */
    public Rocket(double cost, int weight, int weightCargo) {
        this.cost = cost;
        this.weight = weight;
        this.weightCargo = weightCargo;
    }

    /**
     * Returns the cost of the spaceship.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns the current weight of the spaceship.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returns the maximum weight that the spaceship can hold.
     */
    public int getWeightCargo() {
        return weightCargo;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return item.getWeight() + weight <= weightCargo;
    }

    @Override
    public void carry(Item item) {
        weight += item.getWeight();
    }
}
