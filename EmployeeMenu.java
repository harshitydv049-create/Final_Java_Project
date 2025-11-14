import java.io.*;
import java.nio.file.*;
import java.util.*;
class Employee{
  String name,id,designation;
  double salary;
  Employee(String n,String i,String d,double s){name=n;id=i;designation=d;salary=s;}
  String toCSV(){return name+","+id+","+designation+","+salary;}
  static Employee fromCSV(String line){
    String[] p=line.split(",",4); return new Employee(p[0],p[1],p[2],Double.parseDouble(p[3]));
  }
  public String toString(){return "Name:"+name+" Id:"+id+" Desig:"+designation+" Salary:"+salary;}
}
public class EmployeeMenu{
  public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(System.in);
    Path path=Paths.get("employees.txt");
    while(true){
      System.out.println("1.Add an Employee 2.Display All 3.Exit");
      String ch=sc.nextLine().trim();
      if(ch.equals("1")){
        System.out.print("Name: "); String name=sc.nextLine();
        System.out.print("ID: "); String id=sc.nextLine();
        System.out.print("Designation: "); String des=sc.nextLine();
        System.out.print("Salary: "); double sal=Double.parseDouble(sc.nextLine());
        String line=new Employee(name,id,des,sal).toCSV();
        Files.write(path,(line+System.lineSeparator()).getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
      } else if(ch.equals("2")){
        if(!Files.exists(path)){ System.out.println("No records"); continue; }
        List<String> lines=Files.readAllLines(path);
        for(String l:lines) System.out.println(Employee.fromCSV(l));
      } else if(ch.equals("3")) break;
    }
    sc.close();
  }
}

