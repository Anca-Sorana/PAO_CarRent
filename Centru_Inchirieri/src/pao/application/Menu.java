package pao.application;

import pao.model.Car;
import pao.model.Client;
import pao.model.Dealer;
import pao.model.Reservation;
import pao.model.enums.Car_Type;
import pao.service.*;
import pao.service.impl.*;

import java.time.LocalDate;
import java.util.*;

public class Menu {
    private static Menu INSTANCE;
    Scanner console = new Scanner(System.in);
    private CarService carService = new CarServiceImpl();
    private ClientService clientService = new ClientServiceImpl();
    private DealerService dealerService = new DealerServiceImpl();
    private PremiumClientService premiumClientService = new PremiumClientServiceImpl();
    private RentCenterService rentCenterService = new RentCenterServiceImpl();
    private ReservationService reservationService = new ReservationServiceImpl();
    private SubscriptionService subscriptionService = new SubscriptionServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
            Welcome to CarRent PAO! Please choose one of the following action:\n
            (Insert the number that correspond to the action you need to do)
            1. Add a new Dealer in the system.
            2. Add a new Client in the system.
            3. Add a new Car to a certain Dealer.
            4. Create a Reservation for a certain Client
            5. Create a Reservation for a new Client.
            6. Modify the end date for a Reservation
            7. Delete a Car.
            8. Delete a Client.
            9. Sort the Reservations by price.
            10. Print all the Reservations made by a Client in a certain order.
                            """;
        System.out.println(intro);

        Integer option = Integer.valueOf(console.next());

        switch (option) {
            case 1:
                String intro1 = """
                        We will need you to introduce some infos about this new Dealer:
                        """;
                System.out.println(intro1);

                System.out.println("First Name:");
                String firstName = console.next();

                System.out.println("Last Name:");
                String lastName = console.next();

                System.out.println("Email:");
                String email = console.next();

                System.out.println("Phone Number: ");
                String phone = console.next();

                System.out.println("Next we need the hire date. Is it today or not? (1 - Yes, 0 - No)");
                int ans = console.nextInt();

                LocalDate date = null;
                if(ans == 0){
                    System.out.println("Year of the hire date:");
                    Integer year = Integer.valueOf(console.next());

                    System.out.println("Month of the hire date:");
                    Integer month = Integer.valueOf(console.next());

                    System.out.println("Day of the hire date:");
                    Integer day = Integer.valueOf(console.next());

                    date = LocalDate.of(year, month, day);
                }
                else {
                    date = LocalDate.now();
                }
                System.out.println("Salary: ");
                Integer salary = Integer.valueOf(console.next());
                List<Car> carList = new ArrayList<>();

                Dealer dealer = Dealer.builder()
                        .id(UUID.randomUUID())
                        .first_name(firstName)
                        .last_name(lastName)
                        .email(email)
                        .phone_number(phone)
                        .dealerCars(carList)
                        .salary(salary)
                        .hireDate(date)
                        .build();

                dealerService.addDealer(dealer);
                dealerService.printDealer(dealer);


//                Car car = new Car(UUID.randomUUID(), Car_Type.AUDI, "red", 1879, 4);
//
//                carService.addCar(car);
//                carService.allCars()
//                        .forEach(element -> carService.printCar(element));
            case 2:
                String intro2 = """
                        We will need you to introduce some infos about this new Dealer:
                        """;
                System.out.println(intro2);
                System.out.println("First Name:");
                String firstName1 = console.next();

                System.out.println("Last Name:");
                String lastName1 = console.next();

                System.out.println("Email:");
                String email1 = console.next();

                System.out.println("Phone Number: ");
                String phone1 = console.next();

                System.out.println("Is this Client representing himself or a firm? (1 - Himself, 2 - Firm): ");
                Integer op = Integer.valueOf(console.next());
                String type;
                if(op == 1)
                    type = "persoana fizica";
                else type = "persoana juridica";

                List<Reservation> history = new ArrayList<>();

                Client client = Client.builder()
                        .id(UUID.randomUUID())
                        .first_name(firstName1)
                        .last_name(lastName1)
                        .email(email1)
                        .phone_number(phone1)
                        .history(history)
                        .type(type)
                        .build();
                clientService.printClient(client);

            case 3:
                String intro3 = """
                        We will need you to introduce some infos about this new Car:
                        """;
                System.out.println(intro3);

                List<Car> carList1 = new ArrayList<>();
//                Dealer dealer1 = Dealer.builder()
//                        .id(UUID.randomUUID())
//                        .first_name("firstName")
//                        .last_name("lastName")
//                        .email("email")
//                        .phone_number("phone")
//                        .dealerCars(carList1)
//                        .salary(1234)
//                        .hireDate(LocalDate.now())
//                        .build();
//                dealerService.addDealer(dealer1);
//                UUID d = dealer1.getId();

                //System.out.println("Car Type: ");
                System.out.println("Color: ");
                String color = console.next();

                System.out.println("Year: ");
                Integer year = Integer.valueOf(console.next());

                System.out.println("Seats Number: ");
                Integer seats = Integer.valueOf(console.next());

                Car car = new Car(UUID.randomUUID(), Car_Type.AUDI, color, year, seats);

                System.out.println("Please insert the Dealer's ID");

                UUID dealerId = UUID.fromString(console.next());
//                UUID dealerId = d;
//                System.out.println(dealerId);

                if(dealerService.getById(dealerId).isPresent()) {
                    dealerService.addCar(dealerId, car);
                    System.out.println("OK!");
                    //dealerService.printList();
                }
                else System.out.println("This Dealer does not exist!"); //edd48d32-d0d1-11ed-afa1-0242ac120002
            case 7:
                System.out.println("Insert the ID for the Car you want to delete:");
                UUID carID = UUID.fromString(console.next());
                if(carService.getById(carID).isPresent()) {
                    carService.removeCar(carID);
                    System.out.println("OK!");
                }
                else {
                    System.out.println("This car does not exist!");
                }
            case 8:
                System.out.println("Insert the ID for the Client you want to delete:");
                UUID clientID = UUID.fromString(console.next());
                if(clientService.getById(clientID).isPresent()) {
                    clientService.removeClient(clientID);
                    System.out.println("OK!");
                }
                else {
                    System.out.println("This client does not exist!");
                }
            case 9:

            case 10:
                System.out.println("The Reservations will be sorted after their start date");
                System.out.println("We need the Client id: ");
                UUID clientId = UUID.fromString(console.next());

                List<Reservation> reservations = new ArrayList<>();

                if(clientService.getById(clientId).isPresent()) {
                    System.out.println("OK!");
                    Optional<Client> client2 = clientService.getById(clientId);
                    reservations = client2.get().getHistory();
                    //reservations =
                }
                else {
                    System.out.println("This client does not exist!");
                }

        }

    }
}
