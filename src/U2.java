public class U2 extends Rocket {

    U2() {
        rocketCost = 120;               // 120 millions
        rocketWeight = 18000;           // 18000 kg
        weightLimit = 29000;             // 29000 kg (rocketWeight + cargo)
        launchExplosionRate = 0.04;     // 4 %
        landCrashRate = 0.08;           // 8 %
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = launchExplosionRate * (rocketWeight / weightLimit);
        return (chanceOfLaunchExplosion <= Math.random());
    }

    @Override
    public boolean land() {
        double chanceOfLandCrash = landCrashRate * (rocketWeight / weightLimit);
        return (chanceOfLandCrash <= Math.random());
    }
}

