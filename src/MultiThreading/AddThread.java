package MultiThreading;

public class AddThread extends Thread{
    private int start;
    private int end;
    private int res = 0;

    public AddThread(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run(){
        for(int i = start; i < end + 1; i++){
            res = res + i;
        }
    }

    public int getRes(){
        return res;
    }
}
