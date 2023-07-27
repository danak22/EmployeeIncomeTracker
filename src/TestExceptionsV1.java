import java.sql.SQLOutput;
import java.util.*;
public class TestExceptionsV1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of Employees: ");
        int num_employees = scan.nextInt();
        Hourly[] Hourly_Employees = new Hourly[num_employees];
        int count = 0;
        double total = 0;
        for (int i = 0; i < num_employees; i++){
            System.out.println("Enter Employee #" + (i+1) + "'s name: ");
            String Name = scan.nextLine();
            System.out.println("Enter Employee #" + (i+1) + "'s Address: ");
            String Address = scan.nextLine();
            System.out.println("Enter Employee #" + (i+1) + "'s phone number: ");
            String Phone_Number = scan.nextLine();
            System.out.println("Enter Employee #" + (i+1) + "'s Social Security Number: ");
            String Social_Security_Number = scan.nextLine();
            System.out.println("Enter Employee #" + (i+1) + "'s Pay Rate: ");
            double Pay_Rate = scan.nextDouble();
            System.out.println("Enter Employee #" + (i+1) + "'s Hours worked: ");
            int Hours_Worked = scan.nextInt();
            try {
                if (Hours_Worked > 40) {
                    throw new NoOvertimeException("Employee's number of hours worked are more then 40");
                }
                else {
                    Hourly_Employees[i] =  new Hourly(Name, Address, Phone_Number, Social_Security_Number, Pay_Rate);
                    Hourly_Employees[i].addHours(Hours_Worked);
                }
            }
            catch (NoOvertimeException a){
                System.out.println("Error: " + a.getMessage());
            }
        }
        for(Hourly Employee : Hourly_Employees){
            System.out.println(Hourly_Employees);
            System.out.println("Payment: " + Employee.pay());
        }
    }
}
