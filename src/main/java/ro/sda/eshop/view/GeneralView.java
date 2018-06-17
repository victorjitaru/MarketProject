package ro.sda.eshop.view;

import java.util.Scanner;

public class GeneralView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void processOption(int option) {
        switch (option) {
            case 1:
                return;
            case 2:
                return;
            case 3:
                return;
            case 0:
            default:
                return;
        }
    }

    @Override
    public void displayView() {
        int option = -1;
        System.out.println("1. Select Products.");
        System.out.println("2. Select Stock.");
        System.out.println("3. Select Order.");
        System.out.println("0. Exit");
        displayView();
        processOption(option);
        while(option != EXIT_OPTION) {
            displayView();
        }
    }

    @Override
    public int readOption() {

        System.out.println("Input option: ");
        return scanner.nextInt();
    }
}
