import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
            File inputFile = new File("employees.txt");


            Scanner readFile = new Scanner(inputFile);
            String headerline = readFile.nextLine();
            String[] header = {"EMPLOYEE_ID", "NAME", "PHONE_NUMBER", "HIRE_DATE", "DESIGNATION"};

            int headerLength = header.length;

            Employee[] obj = new Employee[55] ;


            int i=0;

            while(readFile.hasNextLine()){
                String line = readFile.nextLine();
                String[] details = line.split(",");
                String[] empDetails = new String[5];
                empDetails[0] = details[0];
                empDetails[1] = details[1]+details[2];
                empDetails[2] = details[3];
                empDetails[3] = details[4];
                empDetails[4] = details[5].replaceAll("[^a-zA-Z]+", "") ;
                obj[i] = new Employee(empDetails[0],empDetails[1], empDetails[2], empDetails[3], empDetails[4]);
                i++;
            }


            int k=0;
            while (k< 50){
//                System.out.println(k);
                String[] det = obj[k].writeandappend();
                System.out.println(det[0]);

                File myFile = new File("employees/" + det[4] + ".txt");

                if (myFile.createNewFile()){
                    FileWriter writeObj = new FileWriter("employees/" + det[4] + ".txt");

                    int j=0;
                    while(j<headerLength){
                        writeObj.write(header[j]+", ");
                        j++;

                    }
                    writeObj.write("\n");
//                    j=0;
//                    while(i<empDetails.length){
//                        writeObj.write(empDetails[i]+", ");
//                        i++;
//                    }
                    writeObj.close();

                    System.out.println("file created successfully");
                }
                else{
                    System.out.println("File already exists");
                }

                k++;
            }

//






//            if (myFile.createNewFile()){
//             System.out.println("file created successfully");
//            }
//            else{
//                System.out.println("File already exists");
//            }

//            try{
//
//                FileWriter writeObj = new FileWriter("test.txt");
//                writeObj.write("hi i am ruthsan i am from coimbatore institute of technology");
//                writeObj.close();
//
//
//            }catch (IOException e){
//                System.out.println(e);
//            }

//            try{
//                Scanner readFile = new Scanner(myFile);
//                System.out.println(readFile.nextLine());
//            }catch (IOException e){
//                System.out.println(e);
//            }




        }
        catch (IOException e){
            System.out.print(e);
        }


    }

    public static class Employee
    {
        String emp_id;
        String emp_name;
        String phone;
        String hire_date;
        String designation;


        Employee(String empid, String empname, String phoneno ,String hiredate, String design )
        {
            emp_id = empid;
            emp_name = empname;
            phone = phoneno;
            hire_date = hiredate;
            designation = design;
        }
        public String[] writeandappend()
        {
            String[] empDetail = new String[5];
            System.out.print("Emp Id = "+emp_id + "  " + " Emp Name = "+emp_name);
            empDetail[0] = emp_id;
            empDetail[1] = emp_name;
            empDetail[2] = phone;
            empDetail[3] = hire_date;
            empDetail[4] = designation;


            return empDetail;
        }
    }
}
