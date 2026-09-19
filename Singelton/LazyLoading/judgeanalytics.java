package Singelton.LazyLoading;

public class judgeanalytics {
  private static judgeanalytics judgeanalytics;

  private judgeanalytics(){

  }
  public static judgeanalytics getInstance(){
    if(judgeanalytics==null){
      judgeanalytics=new judgeanalytics();

    }
    return judgeanalytics;
  }
}
