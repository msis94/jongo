public class Attendance
{
    String date;
    int emp_num;
    String time_in;
    String time_out;

//    Default constructor : to take 0 or null etc
    public Attendance()
    {

    }

    public Attendance(String date, int emp_num, String time_in, String time_out) {
        this.date = date;
        this.emp_num = emp_num;
        this.time_in = time_in;
        this.time_out = time_out;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(int emp_num) {
        this.emp_num = emp_num;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    @Override
    public String toString() {
//        return "Attendance{" +
//                "date='" + date + '\'' +
//                ", emp_num=" + emp_num +
//                ", time_in='" + time_in + '\'' +
//                ", time_out='" + time_out + '\'' +
//                '}';
        return date+" "+time_in+" "+time_out;
    }
}
