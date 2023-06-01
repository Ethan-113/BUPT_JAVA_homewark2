package FileCopy;

import java.io.*;

public class CopyThread extends Thread{
    private String srcFile;
    private String destFile;

    public CopyThread(String srcFile, String destFile){
        this.srcFile = srcFile;
        this.destFile = destFile;
    }

    public void run(){
        File src = new File(srcFile);
        File dest = new File(destFile);

        //在try内部声明，结束后自动关闭流
        try (FileReader fr = new FileReader(src);
             FileWriter fw = new FileWriter(dest)){

            char[] all = new char[(int)src.length()];
            double totalLength = all.length;
            fr.read(all);

            for(int i = 0; i < all.length; i++){
                fw.write(all[i]);
                //打印进度
                double progress = (i + 1) / totalLength * 100;
                System.out.println(srcFile + "已复制" + (int) progress + "%");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
