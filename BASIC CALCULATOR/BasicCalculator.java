import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Simple Basic Calcluator");
        System.out.println("Supported Operations like Addition, Substraction, Mutliplication, Division ");
        
        //Input First Number
        System.out.println("/n Enter the First Number: ");
        double num1 = scan.nextDouble();
        
        //Input Second Number
        System.out.println("/n Enter the Second Number:");
        double num2 = scan.nextDouble();

        //Input Operations
        System.out.println("Enter the Operation (+, -, *, /): ");
        char operator = scan.next().charAt(0);

        //Perform Calculation Based on the Operator
        double result = 0;
        switch (operator) {
            //Addition Operator
            case '+':
                result = num1 + num2;
                break;

            //SubStraction Operator
            case '-':
                result = num1 - num2;
                break;
            //Mutlipilcation Operator
            case '*':
                result = num1 * num2;
                break;
            //Division Operator
            case '/':
                if (num2 != 0) {
                    result = num1/num2;
                } 
                else {
                    System.out.println("Error :/t Divisible by is not allowed...");
                    System.exit(1); //Exit the Program due to an Error
                }
                break;
            default:
                System.out.println("Error: Invalid Operator");
                System.exit(1);//Exit the Program due to an Error
        }
        //Display the Result
        System.out.println("Result: " + result);

        scan.close();
    }
}