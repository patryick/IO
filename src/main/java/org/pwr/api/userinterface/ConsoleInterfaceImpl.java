package org.pwr.api.userinterface;

import org.pwr.dataaccess.repo.CassetteRepository;
import org.pwr.dataaccess.repo.UserRepository;
import org.pwr.dataaccess.entity.Cassette;
import org.pwr.dataaccess.entity.User;
import org.pwr.dataaccess.repo.impl.CassetteRepositoryImpl;
import org.pwr.dataaccess.repo.impl.UserRepositoryImpl;
import org.pwr.logic.CassetteRentalApp;
import org.pwr.logic.CassetteRentalAppImpl;
import org.pwr.logic.usecase.impl.UcCreateUserAccountImpl;
import org.pwr.logic.usecase.impl.UcRentCassetteImpl;
import org.pwr.logic.usecase.impl.UcReturnCassetteImpl;

import java.util.Scanner;

public class ConsoleInterfaceImpl implements UserInterface {

    CassetteRentalApp cassetteRentalApp;

    @Override
    public void mainLoop() {
        configure();

        int choice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n");
            System.out.println("What would you like to do?");
            System.out.println("--------------------------------------");
            System.out.println("1. Create account");
            System.out.println("2. Rent cassette");
            System.out.println("3. Return cassette");
            System.out.println("4. exit");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("\n\nYou want to make account");
                    System.out.println("Give your data:");
                    System.out.print("First name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Personal ID: ");
                    Integer personalId = Integer.parseInt(scanner.nextLine());

                    User user = new User(firstName, lastName, personalId);
                    try {
                        cassetteRentalApp.createAccount(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("\n" + e.getMessage());
                    }

                }
                case 2 -> {
                    System.out.println("\n\nYou want to rent cassette");
                    System.out.println("Give your data:");
                    System.out.print("First name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Personal ID: ");
                    Integer personalId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Cassette name: ");
                    String cassetteName = scanner.nextLine();

                    User user = new User(firstName, lastName, personalId);

                    try {
                        System.out.println(cassetteRentalApp.rentCassette(user, cassetteName));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("\n" + e.getMessage());
                    }

                }
                case 3 -> {
                    System.out.println("\n\nYou want to return cassette");
                    System.out.println("Give your data:");
                    System.out.print("First name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Personal ID: ");
                    Integer personalId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Cassette name: ");
                    String cassetteName = scanner.nextLine();

                    User user = new User(firstName, lastName, personalId);

                    System.out.println(cassetteRentalApp.returnCassette(user, cassetteName));
                }
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println(":C");
                }
            }
        }
    }

    private void configure() {

        CassetteRepository cassetteRepository = new CassetteRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();

        cassetteRepository.save(new Cassette("1", false));
        cassetteRepository.save(new Cassette("1", false));
        cassetteRepository.save(new Cassette("1", false));
        cassetteRepository.save(new Cassette("2", false));
        cassetteRepository.save(new Cassette("3", false));
        cassetteRepository.save(new Cassette("4", false));
        cassetteRepository.save(new Cassette("5", false));
        cassetteRepository.save(new Cassette("5", false));
        cassetteRepository.save(new Cassette("6", false));


        UcReturnCassetteImpl ucReturnCassette = new UcReturnCassetteImpl();
        ucReturnCassette.setCassetteRepository(cassetteRepository);
        ucReturnCassette.setUserRepository(userRepository);

        UcCreateUserAccountImpl ucCreateUserAccount = new UcCreateUserAccountImpl();
        ucCreateUserAccount.setUserRepository(userRepository);
        ucCreateUserAccount.setCassetteRepository(cassetteRepository);

        UcRentCassetteImpl ucRentCassette = new UcRentCassetteImpl();
        ucRentCassette.setCassetteRepository(cassetteRepository);
        ucRentCassette.setUserRepository(userRepository);

        ucRentCassette.setUcCreateUserAccount(ucCreateUserAccount);

        CassetteRentalAppImpl cassetteRentalApp = new CassetteRentalAppImpl();
        cassetteRentalApp.setUcRentCassette(ucRentCassette);
        cassetteRentalApp.setUcReturnCassette(ucReturnCassette);
        cassetteRentalApp.setUcCreateUserAccount(ucCreateUserAccount);
        this.cassetteRentalApp = cassetteRentalApp;
    }
}
