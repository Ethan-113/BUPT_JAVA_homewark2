package BuildException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean restart = true;

        while (restart){
            try{
                NumberCompare nc = new NumberCompare();
                System.out.print(nc.compare());
                restart = false;
                }catch (NumberUnderException e){
//                e.printStackTrace();
                System.out.println("程序将重新启动");
            }
        }
    }
}