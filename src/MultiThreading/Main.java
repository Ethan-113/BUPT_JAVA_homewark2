package MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        AddThread[] treads = new AddThread[10];

        int start = 1;
        int end = 10;

        for(int i = 0; i < 10; i++){
            treads[i] = new AddThread(start+i*10, end+i*10);
            treads[i].start();
        }

        for(int i = 0; i < 10; i++){
            //加入主线程，以便后续的getRes函数获得的是最后的结果
            treads[i].join();
        }

        int total = 0;
        for(int i = 0; i < 10; i++){
            total = total + treads[i].getRes();
        }

        System.out.println("最终答案："+total);
    }
}
