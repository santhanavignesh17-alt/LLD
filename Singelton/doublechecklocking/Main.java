package Singelton.doublechecklocking;

public class Main {
    public static void main(String[] args) {
        judgeanalytics analytics1 = judgeanalytics.getInstance();
        judgeanalytics analytics2 = judgeanalytics.getInstance();
        System.out.println(analytics1 == analytics2);
    }
}
