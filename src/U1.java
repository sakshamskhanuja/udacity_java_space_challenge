public class U1 extends Rocket {
    public U1() {
        super(100000000, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * ((getWeight() - 10000D) / (getWeightCargo() - 10000D));

        return (chanceOfLaunchExplosion <= 0.05);
    }

    @Override
    public boolean land() {
        double chanceOfCrashLanding = 0.01 * ((getWeight() - 10000D) / (getWeightCargo() - 10000D));

        return (chanceOfCrashLanding <= 0.01);
    }
}
