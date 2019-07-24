import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {

    ArrayList<Item> loadItem(String fileName) {
        ArrayList<Item> itemList = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '=') {
                        String itemName = line.substring(0, i);
                        double itemWeight = Double.parseDouble(line.substring(i + 1));
                        itemList.add(new Item(itemName, itemWeight));
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Cannot find the file to built the list");
        }
        return itemList;
    }

    private void loadRocket(ArrayList<Item> itemList, Rocket rocket, ArrayList<Rocket> listOfFullyLoadedRockets) {
        int index = 0;
        while (index < itemList.size()) {
            if (rocket.canCarry(itemList.get(index))) {
                rocket.carry(itemList.get(index));
                itemList.remove(itemList.get(index));
                index--;
            }
            index++;
        }
        if (rocket.rocketWeight == rocket.weightLimit) listOfFullyLoadedRockets.add(rocket);
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> itemList) {
        ArrayList<Rocket> listOfFullyLoadedU1 = new ArrayList<>();

        while (!itemList.isEmpty()) {
            U1 u1 = new U1();
            loadRocket(itemList, u1, listOfFullyLoadedU1);
        }
        return listOfFullyLoadedU1;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        ArrayList<Rocket> listOfFullyLoadedU2 = new ArrayList<>();

        while (!itemList.isEmpty()) {
            U2 u2 = new U2();
            loadRocket(itemList, u2, listOfFullyLoadedU2);
        }
        return listOfFullyLoadedU2;
    }

    int runSimulation(ArrayList<Rocket> listOfFullyLoadedRockets) {
        int totalBudget = 0;
        int index = 0;
        int crashedRockets = 0;
        int crashCosts = 0;
        while (index < listOfFullyLoadedRockets.size()) {
            Rocket rocket = listOfFullyLoadedRockets.get(index);
            boolean rocketLaunching = rocket.launch();
            boolean rocketLanding = rocket.land();

            while (!rocketLaunching || !rocketLanding) {
                rocketLaunching = rocket.launch();
                rocketLanding = rocket.land();
                totalBudget += rocket.rocketCost;
                crashedRockets++;
                crashCosts += rocket.rocketCost;

            }
            totalBudget += rocket.rocketCost;
            index++;
        }
        System.out.println("fleet of fully loaded rockets contains "
                + listOfFullyLoadedRockets.size() + " rockets");
        System.out.println(crashedRockets
                + " rockets exploded during launching or crashed during landing\n"
                + "BUDGET FOR CRASHED ROCKTES :" + crashCosts + " $");
        return totalBudget;
    }
}



