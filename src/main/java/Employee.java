public class Employee
{
    String emp_name;
    int  emp_num;

    public Employee() {}

    public Employee(String emp_name, int emp_num)
    {
        this.emp_name = emp_name;
        this.emp_num = emp_num;
    }

    public String getEmp_name()
    {
        return emp_name;
    }

    public void setEmp_name(String emp_name)
    {
        this.emp_name = emp_name;
    }

    public int getEmp_num()
    {
        return emp_num;
    }

    public void setEmp_num(int emp_num)
    {
        this.emp_num = emp_num;
    }

    @Override
    public String toString()
    {
//        return "Test{" +
//                "emp_name='" + emp_name + '\'' +
//                ", emp_num=" + emp_num +
//                '}';
        return emp_name+" "+emp_num;
    }
}