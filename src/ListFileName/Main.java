package ListFileName;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("输入预览的文件夹地址");
        Scanner scanner = new Scanner(System.in);
        File f = new File(scanner.next());
        if(f.isDirectory()) {
            ListSubFile lsf = new ListSubFile(f);
        }else {
            System.out.println("该路径不是文件夹或不存在");
        }
    }
}
