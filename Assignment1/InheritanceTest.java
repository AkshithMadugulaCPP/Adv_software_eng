package Assignment1;

class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

class HourlyEmployee extends Employee {
    private double wage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

class CommissionEmployee extends Employee {
    private double commissionRate;
    private double grossSales;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }
}

class BaseEmployee extends Employee {
    private double baseSalary;

    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        SalariedEmployee employee1 = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500);
        HourlyEmployee employee2 = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25, 32);
        HourlyEmployee employee3 = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19, 47);
        CommissionEmployee employee4 = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000);
        SalariedEmployee employee5 = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700);
        BaseEmployee employee6 = new BaseEmployee("Mike", "Davenport", "666-66-6666",  95000);
        CommissionEmployee employee7 = new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 22, 40000);

        // Printing information
        System.out.println("First name | Last name | Social Sec No | Weekly Salary | Wage | Hours worked | Com rate | Gross salary | Base salary");
        System.out.println(employee1.getFirstName() + " | " + employee1.getLastName() + " | " + employee1.getSocialSecurityNumber() + " | " + employee1.getWeeklySalary() + " |  |  |  | ");
        System.out.println(employee2.getFirstName() + " | " + employee2.getLastName() + " | " + employee2.getSocialSecurityNumber() + " |  |  | " + employee2.getWage() + " | " + employee2.getHoursWorked() + " |  |  | ");
        System.out.println(employee3.getFirstName() + " | " + employee3.getLastName() + " | " + employee3.getSocialSecurityNumber() + " |  |  | " + employee3.getWage() + " | " + employee3.getHoursWorked() + " |  |  | ");
        System.out.println(employee4.getFirstName() + " | " + employee4.getLastName() + " | " + employee4.getSocialSecurityNumber() + " |  |  |  |  | " + employee4.getCommissionRate() + " | $" + employee4.getGrossSales() + " | ");
        System.out.println(employee5.getFirstName() + " | " + employee5.getLastName() + " | " + employee5.getSocialSecurityNumber() + " | " + employee5.getWeeklySalary() + " |  |  |  | ");
        System.out.println(employee6.getFirstName() + " | " + employee6.getLastName() + " | " + employee6.getSocialSecurityNumber() + " |  |  |  |  | "  + " | $" + employee6.getBaseSalary());
        System.out.println(employee7.getFirstName() + " | " + employee7.getLastName() + " | " + employee7.getSocialSecurityNumber() + " |  |  |  |  | " + employee7.getCommissionRate() + " | $" + employee7.getGrossSales() + " | ");
    }
}
