package pao.application;


import pao.exception.NotUUID;
import pao.model.Car;
import pao.model.Client;
import pao.model.Dealer;
import pao.model.Reservation;
import pao.model.enums.Car_Type;
import pao.repository.impl.CarRepositoryImpl;
import pao.service.CarService;
import pao.service.SubscriptionService;
import pao.service.PremiumClientService;
import pao.service.ClientService;
import pao.service.DealerService;
import pao.service.RentCenterService;
import pao.service.ReservationService;
import pao.service.impl.*;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Menu {
    private static Menu INSTANCE;
//    private final CarService carService = new CarServiceImpl(new CarRepositoryImpl());
    Scanner console = new Scanner(System.in);
    private final CarService carService = new CarServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();
    private final DealerService dealerService = new DealerServiceImpl();
    private final PremiumClientService premiumClientService = new PremiumClientServiceImpl();
    private final RentCenterService rentCenterService = new RentCenterServiceImpl();
    private final ReservationService reservationService = new ReservationServiceImpl();
    private final SubscriptionService subscriptionService = new SubscriptionServiceImpl();
    private final static Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {

//        String intro = """
//                Intro example
//                """;
//
//        System.out.println(intro);
//
//        Car car1 = Car.builder()
//                .id(UUID.randomUUID())
//                .type(Car_Type.VOLVO)
//                .color("blue")
//                .year(2023)
//                .seatsNumber(4)
//                .build();
//
//        carService.addCar(car1);
        String intro = """
            Welcome to CarRent PAO! Please choose one of the following action:\n
            (Insert the number that correspond to the action you need to do)
            1. Add a new Dealer in the system.
            2. Add a new Client in the system.
            3. Add a new Car to a certain Dealer.
            4. Create a Reservation for a certain Client
            5. Create a Reservation for a new Client.
            6. Modify the end date for the first Reservation made.
            7. Delete a Car.
            8. Delete a Client.
            9. Sort the Reservations by price for the first client registered.
            10. Print all the Cars from the first Dealer registered ordered in descending order by their year of fabrication.
                            """;
        System.out.println(intro);
        Car c1 = new Car(UUID.randomUUID(), Car_Type.AUDI, "red", 2019, 4);
        Car c2 = new Car(UUID.randomUUID(), Car_Type.MERCEDES, "black", 2020, 2);
        Car c3 = new Car(UUID.randomUUID(), Car_Type.BMW, "white", 2016, 4);
        Car c4 = new Car(UUID.randomUUID(), Car_Type.SKODA, "red", 2018, 4);
        Car c5 = new Car(UUID.randomUUID(), Car_Type.VOLKSWAGEN, "white", 2017, 4);
        List<Car> lc = new ArrayList<>();
        lc.add(c1);
        lc.add(c2);
        lc.add(c3);
        lc.add(c4);
        lc.add(c5);
        carService.addCar(c1);
        carService.addCar(c2);
        carService.addCar(c3);
        carService.addCar(c4);
        carService.addCar(c5);

        System.out.println("Car");
        System.out.println(c1.getId());

        Reservation r1 = new Reservation(UUID.randomUUID(), 4000, c1, LocalDate.of(2020, 12, 20), LocalDate.of(2021, 1, 4));
        Reservation r2 = new Reservation(UUID.randomUUID(), 2000, c2, LocalDate.of(2021, 3, 15), LocalDate.of(2021, 6, 15));
        Reservation r3 = new Reservation(UUID.randomUUID(), 3000, c3, LocalDate.of(2022, 11, 10), LocalDate.of(2023, 3, 10));

        reservationService.addReservation(r1);
        reservationService.addReservation(r2);
        reservationService.addReservation(r3);

        System.out.println("Reservation: ");
        System.out.println(r1.getId());

        List<Reservation> lr = new ArrayList<>();
        lr.add(r1);
        lr.add(r2);
        lr.add(r3);

        Client c11 = Client.builder()
                .id(UUID.randomUUID())
                .first_name("Ana")
                .last_name("Balan")
                .email("anca.sorana@gmail.com")
                .phone_number("074351723")
                .history(lr)
                .type("persoana fizica")
                .build();
        clientService.addClient(c11);
        System.out.println("Client: ");
        System.out.println(c11.getId());

        Dealer dealer1 = Dealer.builder()
                .id(UUID.randomUUID())
                .first_name("Robert")
                .last_name("Popescu")
                .email("robertpopescu@gmail.com")
                .phone_number("075332739")
                .dealerCars(lc)
                .salary(4000)
                .hireDate(LocalDate.of(2007, 10, 1))
                .build();
        dealerService.addDealer(dealer1);
        System.out.println("Dealer");
        System.out.println(dealer1.getId());

        Integer option = Integer.valueOf(console.next());

        if (option == 1) {

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

            LocalDate date;
            if (ans == 0) {
                System.out.println("Year of the hire date:");
                Integer year = Integer.valueOf(console.next());

                System.out.println("Month of the hire date:");
                Integer month = Integer.valueOf(console.next());

                System.out.println("Day of the hire date:");
                Integer day = Integer.valueOf(console.next());

                date = LocalDate.of(year, month, day);
            } else {
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
        }
            if(option == 2) {

                String intro2 = """
                        We will need you to introduce some infos about this new Client:
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
                if (op == 1)
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
                clientService.addClient(client);
                clientService.printClient(client);
            }

                if(option == 3) {

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
                    carService.addCar(car);

                    System.out.println("Please insert the Dealer's ID");

                    //UUID dealerId = UUID.fromString(console.next());
                    String dealerIDtest = console.next();
                    UUID dealerId = UUID.randomUUID();

                    if(!UUID_REGEX_PATTERN.matcher(dealerIDtest).matches()) try {
                        throw new NotUUID("Invalid number");
                    } catch (NotUUID e) {
                        throw new RuntimeException(e);
                    }
                    else dealerId = UUID.fromString(dealerIDtest);
//                UUID dealerId = d;
//                System.out.println(dealerId);

                    if (dealerService.getById(dealerId).isPresent()) {
                        dealerService.addCar(dealerId, car);
                        System.out.println("OK!");
                        dealerService.printDealerById(dealerId);
                    } else System.out.println("This Dealer does not exist!"); //edd48d32-d0d1-11ed-afa1-0242ac120002
            }
            if(option == 4) {

                System.out.println("Insert the Client's ID: ");
                String clientIDtest = console.next();
                UUID clientID1 = UUID.randomUUID();

                if(!UUID_REGEX_PATTERN.matcher(clientIDtest).matches()) try {
                    throw new NotUUID("Invalid number");
                } catch (NotUUID e) {
                    throw new RuntimeException(e);
                }
                else clientID1 = UUID.fromString(clientIDtest);


                if (clientService.getById(clientID1).isPresent()) {

                    System.out.println("Price: ");
                    Integer price = Integer.valueOf(console.next());

                    System.out.println("End Date: ");

                    System.out.println("Year of the end date:");
                    Integer year1 = Integer.valueOf(console.next());

                    System.out.println("Month of the end date:");
                    Integer month1 = Integer.valueOf(console.next());

                    System.out.println("Day of the end date:");
                    Integer day1 = Integer.valueOf(console.next());

                    LocalDate date1;
                    date1 = LocalDate.of(year1, month1, day1);

                    Car car1 = new Car(UUID.randomUUID(), Car_Type.AUDI, "red", 2008, 4);

                    Reservation res1 = new Reservation(UUID.randomUUID(), price, car1, LocalDate.now(), date1);
                    reservationService.addReservation(res1);
                    clientService.addReservation(clientID1, res1);
                    clientService.printClientById(clientID1);

                } else System.out.println("This Dealer does not exist!");

            }
            if(option == 5) {
                System.out.println("Infos about the client: ");

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
                if (op == 1)
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
                UUID clientID1 = client.getId();
                clientService.addClient(client);

                System.out.println("Infos about the reservation: ");

                System.out.println("Price: ");
                Integer price = Integer.valueOf(console.next());

                System.out.println("End Date: ");

                System.out.println("Year of the end date:");
                Integer year1 = Integer.valueOf(console.next());

                System.out.println("Month of the end date:");
                Integer month1 = Integer.valueOf(console.next());

                System.out.println("Day of the end date:");
                Integer day1 = Integer.valueOf(console.next());

                LocalDate date1;
                date1 = LocalDate.of(year1, month1, day1);

                Car car1 = new Car(UUID.randomUUID(), Car_Type.AUDI, "red", 2008, 4);

                Reservation res1 = new Reservation(UUID.randomUUID(), price, car1, LocalDate.now(), date1);
                reservationService.addReservation(res1);
                clientService.addReservation(clientID1, res1);
                clientService.printClientById(clientID1);
            }
            if(option == 6) {
                System.out.println("ID for the Reservation you wnat to modify: ");
                UUID Id = UUID.fromString(console.next());



                if (reservationService.getById(Id).isPresent()) {
                    System.out.println("Year of the end date:");
                    Integer year1 = Integer.valueOf(console.next());

                    System.out.println("Month of the end date:");
                    Integer month1 = Integer.valueOf(console.next());

                    System.out.println("Day of the end date:");
                    Integer day1 = Integer.valueOf(console.next());

                    LocalDate date = LocalDate.of(year1, month1, day1);
                    Reservation resNew = new Reservation(reservationService.getById(Id).get().getId(), reservationService.getById(Id).get().getPrice(), reservationService.getById(Id).get().getCar(), reservationService.getById(Id).get().getStartDate(), date);
                    reservationService.modifyReservation(Id, resNew);
                    reservationService.printAllReservations();
                    System.out.println("OK!");
                } else {
                    System.out.println("This Reservation does not exist!");
                }

            }
            if(option == 7) {
                System.out.println("Insert the ID for the Car you want to delete:");
                //UUID carID = UUID.fromString(console.next());
                String carIDtest = console.next();
                UUID carID = UUID.randomUUID();

                if(!UUID_REGEX_PATTERN.matcher(carIDtest).matches()) try {
                    throw new NotUUID("Invalid number");
                } catch (NotUUID e) {
                    throw new RuntimeException(e);
                }
                else carID = UUID.fromString(carIDtest);
                if (carService.getById(carID).isPresent()) {
                    carService.removeCar(carID);
                    carService.printCarList();
                    System.out.println("OK!");
                } else {
                    System.out.println("This car does not exist!");
                }
            }
            if(option == 8) {

                System.out.println("Insert the ID for the Client you want to delete:");
//                UUID clientID = UUID.fromString(console.next());
                String clientIDtest = console.next();
                UUID clientID = UUID.randomUUID();

                if(!UUID_REGEX_PATTERN.matcher(clientIDtest).matches()) try {
                    throw new NotUUID("Invalid number");
                } catch (NotUUID e) {
                    throw new RuntimeException(e);
                }
                else clientID = UUID.fromString(clientIDtest);

                if (clientService.getById(clientID).isPresent()) {
                    clientService.removeClient(clientID);
                    clientService.printClientList();
                    System.out.println("OK!");
                } else {
                    System.out.println("This client does not exist!");
                }
            }
            if(option == 9) {
                List<Reservation> reservations = c11.getHistory();
                List <Reservation> reservationsSort = reservations.stream()
                        .sorted(Comparator.comparingInt(Reservation::getPrice))
                        .collect(Collectors.toList());
                reservationsSort.forEach((elem) -> reservationService.printReservation(elem));
            }
            if(option == 10) {

                List <Car> cars= dealer1.getDealerCars();
                List <Car> carSort = cars.stream()
                        .sorted(Comparator.comparingInt(Car::getYear).reversed())
                        .collect(Collectors.toList());
                carSort.forEach((elem) -> carService.printCar(elem));

            }

    }
}
