import java.util.*;
public class SumAutoboxing {
  static int sumList(List<Integer> list){
    int sum=0;
    for(Integer n:list) sum+=n;
    return sum;
  }
  public static void main(String[] args){
    String[] arr = {"10","20","30","40"};
    List<Integer> list = new ArrayList<>();
    for(String s: arr) list.add(Integer.parseInt(s));
    System.out.println("Sum: " + sumList(list));
  }
}
