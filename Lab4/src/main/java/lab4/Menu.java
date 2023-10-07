package lab4;

import lab4.entity.Bicycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

class Menu {
    private static final int CREATE = 1;
    private static final int READ = 2;
    private static final int UPDATE = 3;
    private static final int DELETE = 4;
    private static final int FIND = 5;
    private static final int EXIT = 6;

    private static int getNumInRange(int min, int max) {
        int userInput;
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                userInput = in.nextInt();
                if (userInput < min || userInput > max) {
                    System.out.println("Enter an integer number in range from " + min + " to " + max + ":: ");
                    continue;
                }
                break;
            }
            System.out.println("Enter an integer number in range from " + min + " to " + max + ":: ");
        }
        return userInput;
    }

    private static String getString() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    private static String inputManufacturer()
    {
        System.out.println("Enter manufacturer of the bicycle: ");
        return getString();
    }

    private static String inputModel()
    {
        System.out.println("Enter the model of the bicycle: ");
        return getString();
    }

    private static String inputType(){
        System.out.println("Enter type: ");
        return getString();
    }

    private static int inputWheelSize(){
        System.out.println("Enter wheel size (12-29 inches): ");
        return getNumInRange(12, 29);
    }

    private static int inputPrice(){
        System.out.println("Enter price: ");
        return getNumInRange(1, 10000000);
    }

    public static void menuLoop() {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        var dao = context.getBean("bicycleDao", BicycleDao.class);
        while (true) {
            System.out.println(
                    """
                            1. Create new object
                            2. Print all objects
                            3. Update an object
                            4. Delete an object
                            5. Search for bicycles with wheel size lower than entered inches
                            6. Quit
                            """
            );
            int userInput = getNumInRange(1, 6);
            switch (userInput) {
                case CREATE -> {
                    dao.create(new Bicycle(inputManufacturer(), inputModel(),
                            inputType(), inputWheelSize(), inputPrice()));
                    break;
                }
                case READ -> {
                    var bicycles = dao.read();
                    System.out.println(bicycles.size());
                    bicycles.forEach(bicycle -> {
                        System.out.println(bicycle + "\n");
                    });
                    break;
                }
                case UPDATE -> {
                    int max = dao.read().size();
                    long id = 0;
                    if (max > 0) {
                        System.out.println("Enter object ID to update: ");
                        Scanner in = new Scanner(System.in);
                        if (in.hasNextLong()) {
                            id = in.nextLong();
                        }
                        if (dao.update(new Bicycle(id, inputManufacturer(), inputModel(), inputType(),
                                inputWheelSize(), inputPrice())) != 0) {
                            continue;
                        } else {
                            System.out.println("ID not found");
                        }
                    } else {
                        System.out.println("Database is empty");
                        break;
                    }
                    break;
                }
                case DELETE -> {
                    int max = dao.read().size();
                    long id = 0;
                    if (max > 0) {
                        System.out.println("Enter object ID to delete: ");
                        Scanner in = new Scanner(System.in);
                        if (in.hasNextLong()) {
                            id = in.nextLong();
                        }
                        if (dao.delete(id) != 0) {
                            continue;
                        } else {
                            System.out.println("ID not found");
                        }
                    } else {
                        System.out.println("Database is empty");
                        break;
                    }
                    break;
                }
                case FIND -> {
                    System.out.println("Enter max wheel size (in inches from 12 to 29)");
                    int max = getNumInRange(12, 29);
                    dao.findByWheelSize(max).forEach(System.out::println);
                    break;
                }
                case EXIT -> {
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
