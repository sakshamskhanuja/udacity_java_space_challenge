import java.util.Random;

public class U1 extends Rocket {

    /**
     * Spaceship cost = 100,000,000 million
     * Spaceship weight = 10 Tonnes
     * Spaceship weight carrying max cargo = 18 Tonnes
     */
    public U1() {
        super(100000000, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * ((getWeight() - 10000D) / (getWeightCargo() - 10000D));

        return (chanceOfLaunchExplosion <= new Random().nextInt(3, 8) / 100D);
    }

    @Override
    public boolean land() {
        double chanceOfCrashLanding = 0.01 * ((getWeight() - 10000D) / (getWeightCargo() - 10000D));

        return (chanceOfCrashLanding <= 0.01);
    }
}
