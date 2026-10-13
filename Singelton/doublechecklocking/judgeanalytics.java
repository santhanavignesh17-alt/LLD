package Singelton.doublechecklocking;

public class judgeanalytics {
     private static volatile judgeanalytics judgeanalytics;
     private judgeanalytics(){
     }
      public static judgeanalytics  getInstance(){
          if(judgeanalytics==null){
              synchronized (judgeanalytics.class){
                  if(judgeanalytics==null){
                      judgeanalytics=new judgeanalytics();
                  }
              }
          }
          return judgeanalytics;
      }
}
