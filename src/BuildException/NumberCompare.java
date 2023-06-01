package BuildException;

import java.util.Scanner;

public class NumberCompare {
    private int a;
    private int b;
    public NumberCompare(){
        System.out.print("输入a和b，比较a是否大于b:");
        Scanner scanner = new Scanner(System.in);
        this.a = scanner.nextInt();
        this.b = scanner.nextInt();
    }
    public boolean compare() throws NumberUnderException {
        if(b < 0 | a < 0){
            //打印错误信息
            throw new NumberUnderException("比较的数字不能有负数");
        }
        return a>b;
    }
}
