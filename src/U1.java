public class U1 extends Rocket {

    U1() {
        rocketCost = 100;               // 100 millions
        rocketWeight = 10000;           // 10000 kg
        weightLimit = 18000;             // 10000 kg (rocketWeight + cargo)
        launchExplosionRate = 0.05;     // 5 %
        landCrashRate = 0.01;           // 1 %
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = launchExplosionRate * (rocketWeight/ weightLimit);
        return (chanceOfLaunchExplosion<=Math.random());
    }

    @Override
    public boolean land() {
        double chanceOfLandCrash = landCrashRate * (rocketWeight/ weightLimit);
        return (chanceOfLandCrash <=Math.random());
    }
}
