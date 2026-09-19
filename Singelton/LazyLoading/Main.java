package Singelton.LazyLoading;

public class Main {
  public static void main(String[]args){
    judgeanalytics obj1=judgeanalytics.getInstance();
    System.out.println(obj1);
    judgeanalytics obj2=judgeanalytics.getInstance();
    System.out.println(obj2);
  }
  
}
