package Singelton.synchronizedkey;

public class Main {
  public static void main(String[]args){
   judgeanalytics obj1=judgeanalytics.getinstance();
    System.out.println(obj1);
    judgeanalytics obj2=judgeanalytics.getinstance();
    System.out.println(obj2);
  }
  
}
