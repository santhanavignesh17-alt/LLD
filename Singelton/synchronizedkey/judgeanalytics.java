package Singelton.synchronizedkey;

public class judgeanalytics {
  private static judgeanalytics judgeanalytics;
  private judgeanalytics(){
    
  }
  public static synchronized judgeanalytics getinstance(){
    if(judgeanalytics==null){
      judgeanalytics=new judgeanalytics();
    }
    return judgeanalytics;
  }

}
