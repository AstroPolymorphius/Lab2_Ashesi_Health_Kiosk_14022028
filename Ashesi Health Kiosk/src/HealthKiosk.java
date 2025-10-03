import java.util.Scanner;
import java.util.Random;
public class HealthKiosk{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random myRandomizer = new Random();

        char serviceCode;
        char triageMetricNumber;
        System.out.println("Enter your service code: ");
        serviceCode = input.next().charAt(0);
        serviceCode = Character.toUpperCase(serviceCode);
        boolean locationIsTriage = false;
        double bmi;
        int roundedBmi = 0;
        String targetLocation = "";

        switch(serviceCode){
            case 'C':
                targetLocation = "COUNSELLING";
                System.out.println("Go to: Counselling Desk ");
                break;
            case 'L':
                targetLocation = "LAB";
                System.out.println("Go to: Lab Desk ");
                break;
            case 'P':
                targetLocation = "PHARMACY";
                System.out.println("Go to: Pharmacy Desk ");
                break;
            case 'T':
                targetLocation = "TRIAGE";
                System.out.println("Go to: Triage Desk ");
                locationIsTriage = true;
                break;
                
        }

        if (locationIsTriage == true){
            System.out.println("Welcome to Triage \n 1. BMI \n 2. Dosage \n 3. Simple trig \n");
            triageMetricNumber = input.next().charAt(0);

            switch (triageMetricNumber) {
                case '1':
                System.out.println("Enter your weight (kg): ");
                double weight = input.nextDouble();
                System.out.println("Enter your height (m): ");
                double height = input.nextDouble();
                bmi = Math.round((weight/ Math.pow(height, 2))*10)/10;
                roundedBmi = (int) bmi;
                String bmiCategory = "";
                if (bmi >= 30.0){
                    bmiCategory = "Obese";
                    System.out.println("BMI: " + roundedBmi + "  Category: " + bmiCategory);
                }
                else if (bmi <= 29.9 && bmi >= 25.0){
                    bmiCategory = "Overweight";
                    System.out.println("BMI: " + roundedBmi + "  Category: " + bmiCategory);
                }
                else if (bmi <= 24.9 && bmi >= 18.5){
                    bmiCategory = "Normal";
                    System.out.println("BMI: " + roundedBmi + "   Category: " + bmiCategory);
                }
                else{
                    bmiCategory = "Underweight";
                    System.out.println(" BMI: " + roundedBmi + "  Category: " + bmiCategory);
                }

                char idLetter = (char) ('A' + myRandomizer.nextInt(26));
                int firstRandomNumber = myRandomizer.nextInt(9 - 3 + 1) + 3;
                int secondRandomNumber = myRandomizer.nextInt(9 - 3 + 1) + 3;
                int thirdRandomNumber = myRandomizer.nextInt(9 - 3 + 1) + 3;
                int fourthRandomNumber = myRandomizer.nextInt(9 - 3 + 1) + 3;

                String firstRandomNumberString = Integer.toString(firstRandomNumber);
                String secondRandomNumberString = Integer.toString(secondRandomNumber);
                String thirdRandomNumberString = Integer.toString(thirdRandomNumber);
                String fourthRandomNumberString = Integer.toString(fourthRandomNumber);

                String myId = idLetter + firstRandomNumberString + secondRandomNumberString + thirdRandomNumberString + fourthRandomNumberString;
                System.out.println(myId.length());
                System.out.println(myId);

                if (myId.length() != 5){
                System.out.println("Invalid length");
                 }
                if (!Character.isLetter(idLetter)){
                System.out.println("Invalid: first char must be a letter");
                }
                char firstRandomNumberChar = myId.charAt(1);
                char secondRandomNumberChar = myId.charAt(2);
                char thirdRandomNumberChar = myId.charAt(3);
                char fourthRandomNumberChar = myId.charAt(4);

                if (!Character.isDigit(firstRandomNumberChar) || !Character.isDigit(secondRandomNumberChar) || !Character.isDigit(thirdRandomNumberChar) || !Character.isDigit(fourthRandomNumberChar)){
                    System.out.println("Invalid: last 4 must be digits");
                }
                else{
                    System.out.println("ID OK");
                    System.out.println("What's your first name: ");
                    input.nextLine();
                    String studentName = input.nextLine();
                    char secureDisplayCodeLetter = studentName.toUpperCase().charAt(0);
                    char shiftedLetterChar = (char) ('A' + (secureDisplayCodeLetter - 'A' + 2) % 26);
                    String shiftedLetter = Character.toString(shiftedLetterChar);
                    String idLastTwoChar = myId.substring(3);
                    String bmiString = Integer.toString(roundedBmi);
                    String finalsecureDisplayCode = shiftedLetter + idLastTwoChar + "-" + bmiString;
                    System.out.println("Display Code: " + finalsecureDisplayCode);
                    System.out.println("Summary: " + targetLocation + " | ID = " + myId + " | Code = " + finalsecureDisplayCode);
                }
                break;
                case '2':
                System.out.println("Enter the required dosage in mg: ");
                double requiredDosage = input.nextDouble();
                final double DOSAGE_PER_TABLET = 250;
                int tabletsQuantity = (int) Math.ceil(requiredDosage / DOSAGE_PER_TABLET);
                System.out.println("With " + requiredDosage + " mg, you need " + tabletsQuantity + " tablets");
                break;
                case '3':
                    System.out.println("Enter an angle in degrees");
                    double angleInDegrees = input.nextDouble();
                    double sineAngleInRadians = Math.round(((Math.sin(angleInDegrees))*1000)/1000);
                    double cosineAngleInRadians = Math.round(((Math.sin(angleInDegrees))*1000)/1000);

                    System.out.println("The sine of " + angleInDegrees + " degrees is " + sineAngleInRadians + " radians");
                    System.out.println("The cosine of " + angleInDegrees + " degrees is " + cosineAngleInRadians + " radians");
                break;
                default:
                    System.out.println("Invalid input!!");
                    break;
            }

        }
        input.close();

        


    }
}