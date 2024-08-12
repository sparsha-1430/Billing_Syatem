import java.util.ArrayList;
import java.util.Scanner;

public class FastFoodBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String UserName = "user123";
        String Password = "pass";
        int numOfAttempts = 10;

        System.out.print("Enter [start or quit]: ");
        String check = sc.nextLine();

        if (check.equals("start")) {
            while (numOfAttempts > 0) {
                System.out.print("Enter your Username: ");
                String enteredUsername = sc.nextLine();
                System.out.print("Enter your Password: ");
                String enteredPassword = sc.nextLine();

                if (enteredUsername.equals(UserName) && enteredPassword.equals(Password)) {
                    System.out.println("You are verified user.");

                    int totalSumOfItems = 0;
                    System.out.print("Enter number of items: ");
                    int noOfItems = sc.nextInt();

                    ArrayList<Integer> Price = new ArrayList<>();


                    for (int i = 0; i < noOfItems; i++) {
                        System.out.print("Enter price of Item " + (i + 1) + ": ");
                        Price.add(sc.nextInt());
                        totalSumOfItems = Price.get(i);
                    }

                    int vatPercentage = 0;
                    System.out.print("Is VAT charged (Yes/No): ");
                    String isVat = sc.next().trim().toLowerCase();

                    if (isVat.equals("Yes")) {
                        vatPercentage = 13;
                    }

                    int discountPercentage = 0;
                    System.out.print("Input a discount percentage : ");
                    discountPercentage = sc.nextInt();

                    double totalWithVAT = totalSumOfItems * (1 + vatPercentage / 100.0);
                    double totalWithDiscountAndVat = totalWithVAT * (1 - discountPercentage / 100.0);



                    long roundedTotal = Math.round(totalWithDiscountAndVat);
                    System.out.println(totalWithDiscountAndVat);


                    System.out.print("Enter Amount of money paid: ");
                    int paidAmount = sc.nextInt();

                    int returnAmount = (int) (paidAmount - roundedTotal);
                    if (returnAmount >= 0) {
                        System.out.println("Change returned: " + returnAmount);
                        if (returnAmount > 0) {
                            if (returnAmount >= 1000) {
                                System.out.println("1000 - " + returnAmount / 1000);
                                returnAmount %= 1000;
                            }
                            if (returnAmount >= 500) {
                                System.out.println("500 - " + returnAmount / 500);
                                returnAmount %= 500;
                            }
                            if (returnAmount >= 100) {
                                System.out.println("100 - " + returnAmount / 100);
                                returnAmount %= 100;
                            }
                            if (returnAmount >= 50) {
                                System.out.println("50 - " + returnAmount / 50);
                                returnAmount %= 50;
                            }
                            if (returnAmount >= 20) {
                                System.out.println("20 - " + returnAmount / 20);
                                returnAmount %= 20;
                            }
                            if (returnAmount >= 10) {
                                System.out.println("10 - " + returnAmount / 10);
                                returnAmount %= 10;
                            }
                            if (returnAmount >= 5) {
                                System.out.println("5 - " + returnAmount / 5);
                                returnAmount %= 5;
                            }
                            if (returnAmount > 0) {
                                System.out.println("Remaining change - " + returnAmount);
                            }
                        }
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                } else {
                    numOfAttempts--;
                    System.out.println("Incorrect Username or password.");
                }
            }

            if (numOfAttempts <= 0) {
                System.out.println("You are not verified user");
            }
        } else if (check.equals("quit")) {
            System.out.println("The System is Logging off");
        } else {
            System.out.println("Invalid Input.");
        }


    }
}

