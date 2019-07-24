import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nMission to Mars - rockets testing");
        System.out.println("==============================================================================");

        Simulation simulation = new Simulation();
        ArrayList<Item> itemListPhase1_U1 = simulation.loadItem("phase-1.txt");
        System.out.println("\nItem list for first phase of mission: \n");

        int itemCounterPhase1 = 1;
        for (Item item:itemListPhase1_U1
             ) {
            System.out.println("Item " + itemCounterPhase1 + ". " + item.getName() + " weight: " + item.getWeight());
            itemCounterPhase1++;
        }

        ArrayList<Item> itemListPhase2_U1 = simulation.loadItem("phase-2.txt");
        System.out.println("\nItem list for second phase of mission: \n");

        int itemCounterPhase2 = 1;
        for (Item item:itemListPhase2_U1
        ) {
            System.out.println("Item " + itemCounterPhase2 + ". " + item.getName() + " weight: " + item.getWeight());
            itemCounterPhase2++;
        }
        System.out.println("==============================================================================");

        System.out.println("Simulation of U1 fleet rockets for first phase of mission\n");
        ArrayList<Rocket> U1ListPhase1 = simulation.loadU1(itemListPhase1_U1);
        int totalBudget_Phase1_U1Rocket = simulation.runSimulation(U1ListPhase1);
        System.out.println("TOTAL BUDGET:  " + totalBudget_Phase1_U1Rocket + " millions $");
        System.out.println("==============================================================================");

        System.out.println("Simulation of U1 fleet rockets for second phase of mission\n");

        ArrayList<Rocket> U1ListPhase2 = simulation.loadU1(itemListPhase2_U1);
        int totalBudget_Phase2_U1Rocket = simulation.runSimulation(U1ListPhase2);
        System.out.println("TOTAL BUDGET:  " + totalBudget_Phase2_U1Rocket + " millions $");
        System.out.println("==============================================================================");

        ArrayList<Item> itemListPhase1_U2 = simulation.loadItem("phase-1.txt");
        ArrayList<Item> itemListPhase2_U2 = simulation.loadItem("phase-2.txt");

        System.out.println("Simulation of U2 fleet rockets for first phase of mission\n");

        ArrayList<Rocket> U2ListPhase1 = simulation.loadU2(itemListPhase1_U2);
        int totalBudget_Phase1_U2Rocket = simulation.runSimulation(U2ListPhase1);
        System.out.println("TOTAL BUDGET:  " + totalBudget_Phase1_U2Rocket + " millions $");
        System.out.println("==============================================================================");

        System.out.println("Simulation of U2 fleet rockets for second phase of mission\n");

        ArrayList<Rocket> U2ListPhase2 = simulation.loadU2(itemListPhase2_U2);
        int totalBudget_Phase2_U2Rocket = simulation.runSimulation(U2ListPhase2);
        System.out.println("TOTAL BUDGET:  " + totalBudget_Phase2_U2Rocket + " millions $");


    }

}
