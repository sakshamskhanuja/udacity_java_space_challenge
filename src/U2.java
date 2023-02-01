import java.util.Random;

public class U2 extends Rocket {

    /**
     * Spaceship cost = 120,000,000 million
     * Spaceship weight = 18 Tonnes
     * Spaceship weight carrying max cargo = 29 Tonnes
     */
    public U2() {
        super(120000000, 18000, 29000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.04 * ((getWeight() - 18000D) / (getWeightCargo() - 18000D));

        return (chanceOfLaunchExplosion <= new Random().nextInt(3, 10) / 100D);
    }

    @Override
    public boolean land() {
        double chanceOfCrashLanding = 0.08 * ((getWeight() - 18000D) / (getWeightCargo() - 18000D));

        return (chanceOfCrashLanding <= new Random().nextInt(6, 10) / 100D);
    }
}
