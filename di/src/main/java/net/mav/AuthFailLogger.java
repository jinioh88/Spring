package net.mav;

public class AuthFailLogger {
    private int threshold;
    private int failCounts;

    public void insertBdPw(String userId, String inputPw){
        failCounts++;
        if(threshold>0&&failCounts>threshold){
            notifyTooManyFail();
            failCounts=0;
        }
    }

    private void notifyTooManyFail(){
        System.out.println("로그인 너무 많이 실패");
    }

    public void setThreshold(int threshold){
        this.threshold = threshold;
    }
}
