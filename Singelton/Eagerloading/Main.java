package Singelton.Eagerloading;
public class Main{
  public static void main (String[]args){
    judgeanlyticts obj1=judgeanlyticts.getInstance();
     System.out.println(obj1);
    judgeanlyticts obj2=judgeanlyticts.getInstance();
    System.out.println(obj2);
  }
}
