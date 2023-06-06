package FileTransmit;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // 创建客户端Socket，连接到服务器
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("已连接到服务器");

            Scanner scanner = new Scanner(System.in);
            System.out.println("输入想要传输的文件的地址");
            // 获取文件名
            String fileName = scanner.nextLine();

            // 获取文件输入流，用于读取文件
            FileInputStream fis = new FileInputStream(fileName);

            // 获取输出流，用于发送文件
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            // 发送文件名
            dos.writeUTF(fileName);

            // 发送文件内容
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, length);
            }

            // 关闭流和连接
            fis.close();
            dos.close();
            socket.close();

            System.out.println("文件发送完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
