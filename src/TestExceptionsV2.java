import java.sql.SQLOutput;
import java.util.*;
public class TestExceptionsV2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of Employees: ");
        int num_employees = scan.nextInt();
        scan.nextLine();
        Hourly[] Hourly_Employees = new Hourly[num_employees];
        int count = 0;
        double Total_pay = 0;
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
                    Total_pay += Hourly_Employees[i].pay();
                    count++;
                }
            }
            catch (NoOvertimeException a){
                System.out.println("Error: " + a.getMessage());
                System.out.println("This employee's hours worked are now set to 0");
                continue;
            }
        }
        for(int i = 0; i <count; i++){
            if (Hourly_Employees[i] != null){
                System.out.println(Hourly_Employees[i]);
                System.out.println("Payment: " + Hourly_Employees[i].pay());
            }
        }

        double averagePay = Total_pay / count;
        System.out.println("Number of employees with a correct number of hours worked: " + count);
        System.out.println("The average pay: " + averagePay);
    }
}
