import com.mongodb.MongoClient;
import com.mongodb.DB;
import jdk.swing.interop.SwingInterOpUtils;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.Scanner;

public class Main
{
    static MongoCollection employeeCollection;
    static MongoCollection attendanceCollection;


    public static void main(String[] args)
    {
        //Initialize the connection to the database
        DB db = new MongoClient().getDB("skymind");

        Jongo jongo = new Jongo(db);


//      Establish the connection to the employee collection
        employeeCollection = jongo.getCollection("employee");
        attendanceCollection = jongo.getCollection("attendance");
//        Employee e = new Employee("wish",3);
//        employeeCollection.save(e);

        String emp_name;
        int emp_num;
        String time_in;
        String time_out;
        String date;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice : ");
        int choice = input.nextInt();


//        Create 4 choice
        if(choice == 1)
        {
            System.out.println("Please Enter Employee Name : ");
            emp_name = input.next();
            System.out.println("Please Enter Employee Number");
            emp_num = input.nextInt();
            createEmployee(emp_name, emp_num);

        }
        else if(choice==2)
        {
            System.out.println("Please Enter Employee Number : ");
            emp_num = input.nextInt();
            System.out.println("Please Enter The Date : ");
            date = input.next();
            System.out.println("Please Enter Emloyeee Time In : ");
            time_in = input.next();
            System.out.println("Please Enter Emloyeee Time Out : ");
            time_out = input.next();

            createAttendance(date, emp_num, time_in, time_out);


        }

        else if(choice==3)
        {
//            updateEmployee()

        }

        else if(choice==4)
        {
//            updateAttendance()
        }

        else if(choice==5)
        {
//            readEmployee();
        }

        else if(choice==6)
        {
            System.out.println("Please Enter Employee Number : ");
            emp_num = input.nextInt();
            readAttendance(emp_num);
        }

        else if(choice==7)
        {
//            deleteEmployee()
        }

        else if(choice==8)
        {
//            deleteAttendance()
        }

//        else if(choice==9)
//        {
//            timeAttendance()
//        }

        else
        {
            System.out.println("There is no choice");
        }

//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the employee number : ");
//        int emp_num = input.nextInt();

//        System.out.println(getEmployee(emp_num));
//        System.out.println(getAttendance(emp_num));

//        MongoCursor<Attendance> allAttendance = attendanceCollection.find("{emp_num: "+emp_num+"}").as(Attendance.class);
//        while (allAttendance.hasNext()) {
//            System.out.println(allAttendance.next());
//        }

//        System.out.println(getAllattendance(emp_num));


//        ----------------------------------------------------


    }

//    static void timeAttendance()
//    {
//        Date
//    }

    static void createEmployee(String emp_name, int emp_num)
    {
        DB db = new MongoClient().getDB("skymind");
        Jongo jongo = new Jongo(db);
        employeeCollection = jongo.getCollection("employee");

        employeeCollection.save(new Employee(emp_name, emp_num));
    }

    static void createAttendance(String date, int emp_num, String time_in, String time_out)
    {
        DB db = new MongoClient().getDB("skymind");
        Jongo jongo = new Jongo(db);
        attendanceCollection = jongo.getCollection("attendance");

        attendanceCollection.save(new Attendance(date, emp_num, time_in, time_out));
    }

    static void readAttendance(int emp_num)
    {
        MongoCursor<Attendance> allAttendance = attendanceCollection.find("{emp_num: "+emp_num+"}").as(Attendance.class);
        while (allAttendance.hasNext())
        {
            System.out.println(allAttendance.next());
        }
    }

    static void searchAttendance()
    {
        MongoCursor<Attendance> allAttendance = attendanceCollection.find().as(Attendance.class);
        while (allAttendance.hasNext())
        {
            System.out.println(allAttendance.next());
        }
    }

    static void readEmployee()
    {
        MongoCursor<Employee> readAll = employeeCollection.find().as(Employee.class);
        while (readAll.hasNext())
        {
            System.out.println(readAll.next());
        }
    }

    static void searchEmployee()
    {
        MongoCursor<Employee> searchEmployee = employeeCollection.find().as(Employee.class);
        while (searchEmployee.hasNext())
        {
            System.out.println(searchEmployee.next());
        }
    }

    static Employee getEmployee(int emp_num)
    {
//        return employeeCollection.findOne("{emp_name: '"+emp_name+"'}").as(Employee.class);
        return employeeCollection.findOne("{emp_num: "+emp_num+"}").as(Employee.class);
    }

    static Attendance getAttendance(int emp_num)
    {
        return attendanceCollection.findOne("{emp_num: "+emp_num+"}").as(Attendance.class);
    }

    static MongoCursor<Attendance> getAllattendance(int emp_num)
    {
        MongoCursor<Attendance> allAttendance = attendanceCollection.find("{emp_num: "+emp_num+"}").as(Attendance.class);
        while (allAttendance.hasNext())
        {
            System.out.println(allAttendance.next());
        }
        return null;
    }
}

