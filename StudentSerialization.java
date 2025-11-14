import java.io.*;
class Student implements Serializable{
  String name;
  int id;
  Student(String n,int i){name=n;id=i;}
  public String toString(){return "Student[name="+name+",id="+id+"]";}
}
public class StudentSerialization{
  public static void main(String[] args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter name: "); String name=br.readLine();
    System.out.print("Enter id: "); int id=Integer.parseInt(br.readLine());
    Student s=new Student(name,id);
    try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("student.ser"))){
      oos.writeObject(s);
    }
    Student r;
    try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("student.ser"))){
      r=(Student)ois.readObject();
    }
    System.out.println("Deserialized: " + r);
  }
}
