public class Rocket implements Spaceship {

    // Cost of rocket.
    private final double cost;

    // Weight of rocket.
    private int weight;

    // Max weight of rocket with cargo.
    private final int weightCargo;

    public Rocket(double cost, int weight, int weightCargo) {
        this.cost = cost;
        this.weight = weight;
        this.weightCargo = weightCargo;
    }

    public double getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

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
