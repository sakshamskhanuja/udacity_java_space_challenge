public class U2 extends Rocket {
    public U2() {
        super(120000000, 18000, 29000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.04 * ((getWeight() - 18000D) / (getWeightCargo() - 18000D));

        return (chanceOfLaunchExplosion <= 0.04);
    }

    @Override
    public boolean land() {
        double chanceOfCrashLanding = 0.08 * ((getWeight() - 18000D) / (getWeightCargo() - 18000D));

        return (chanceOfCrashLanding <= 0.08);
    }
}
