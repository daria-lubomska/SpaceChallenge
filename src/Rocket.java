public class Rocket implements SpaceShip {
    double rocketWeight;
    double weightLimit;
    double launchExplosionRate;
    double landCrashRate;
    int rocketCost;

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
        return rocketWeight + item.getWeight() <= weightLimit;
    }

    @Override
    public void carry(Item item) {
        rocketWeight += item.getWeight();
    }
}
