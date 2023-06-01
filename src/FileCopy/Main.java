package FileCopy;

public class Main {
    public static void main(String[] args){
        CopyThread[] threads = new CopyThread[3];
        String[] src = new String[3];
        String[] dest = new String[3];

        src[0]="D:\\测试用数据\\one.txt";
        src[1]="D:\\测试用数据\\two.txt";
        src[2]="D:\\测试用数据\\three.txt";

        dest[0]="D:\\测试用数据\\one_copy.txt";
        dest[1]="D:\\测试用数据\\two_copy.txt";
        dest[2]="D:\\测试用数据\\three_copy.txt";

        for(int i = 0; i < 3; i++){
            threads[i] = new CopyThread(src[i], dest[i]);
            threads[i].start();
        }
    }
}
