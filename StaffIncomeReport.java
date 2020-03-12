import java.util.Scanner;
public class StaffIncomeReport
{
   public static void main(String[]args)
   {
      Scanner scan=new Scanner (System.in);
      System.out.print("Please input Staff Name : ");
      String name=scan.nextLine();
      System.out.print("Please input Staff ID   : ");
      String id=scan.nextLine();
      System.out.print("Please input Income Type (Active/Passive/Portfolio) : ");
      String incomeType=scan.nextLine();
      System.out.print("Please input Income Amount (RM)        : ");
      double amount=scan.nextDouble();
      System.out.print("Please input Income Tax Percentage (%) : ");
      double tax=scan.nextDouble();
      
      Income income = new Income(incomeType,amount,tax);
      Staff details = new Staff(name,id,income);
       
      details.displayStaffInfo();
      details.displayIncomeInfo();
            
    }
}

class Income
{
   private String incomeType;
   private double amount;
   private double tax;
   private double totalTax;
   
   public Income(String incomeType,double amount,double tax)
   {
       this.incomeType = incomeType;
       this.amount = amount;
       this.tax = tax;
    }
        
      public String getIncomeType()
      {
         return incomeType;
      }
      public double getAmount()
      {
         return amount;
      }
      public double getTax()
      {
         return tax;
      } 
      public double getTotalTax()
      {
         return (tax/100)*this.amount;
      }
}
class Staff
{
   private String name;
   private String id;
   private Income income;
   
   public Staff(String name, String id, Income income)
   {
      this.name = name;
      this.id = id;
      this.income = income;
   }
            
      public String getName()
      {
         return name;
      }
      
      public String getId()
      {
         return id;
      }
      
      public double calculateNetIncome()
      {
        return income.getAmount() - income.getTotalTax(); 
      }  
      public void displayStaffInfo()
      {
        System.out.println();
        System.out.println("   Staff Info    ");
        System.out.println("=================");
        System.out.println("Staff Name : "+getName());
        System.out.println("Staff ID   : "+getId());
      }
      public void displayIncomeInfo()
      {
         System.out.println();
         System.out.println("  Staff Income Report   ");
         System.out.println("========================");
         System.out.printf("Income Type            : %s%n",income.getIncomeType());
         System.out.printf("Income Amount          : RM %.2f%n",income.getAmount());
         System.out.printf("Income Tax Percentage  : %.2f%s%n",income.getTax(),"%");
         System.out.printf("Total Tax Paid         : RM %.2f%n",income.getTotalTax());
         System.out.printf("Total Net Income       : RM %.2f%n",calculateNetIncome());
      }
 }