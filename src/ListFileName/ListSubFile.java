package ListFileName;

import java.io.File;

public class ListSubFile {
    File file;
    String space;

    //主要是正常调用
    public ListSubFile(File file){
        this.file = file;
        this.space = "";
        ListName(file);
    }

    //主要是迭代时调用，以便知道是第几次迭代，用于打印缩进
    public ListSubFile(File file, String space){
        this.file = file;
        this.space = space;
        ListName(file);
    }

    public void ListName(File f){

        if(f.isDirectory()){
            System.out.println(this.space+"└─"+f.getName());
            File[] fs = f.listFiles();
            for(int i = 0; i < fs.length; i++){
                //space后加两个空格，所有子目录中的往后缩进两个空格
                ListSubFile lsf = new ListSubFile(fs[i], this.space+"   ");
            }
        }else {
            System.out.println(this.space+"|"+f.getName());
        }
    }
}
