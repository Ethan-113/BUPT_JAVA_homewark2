package FileTransmit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建服务器端Socket，监听指定端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动，等待连接...");

            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接");

            // 获取输入流，用于接收文件
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // 读取文件名
            String fileName = dis.readUTF();
            System.out.println("接收到文件：" + fileName);

            Scanner scanner = new Scanner(System.in);
            System.out.println("输入想存储到的地址");
            fileName = scanner.nextLine();

            // 创建文件输出流，用于保存文件
            FileOutputStream fos = new FileOutputStream(fileName);

            // 接收文件内容并写入文件
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            // 关闭流和连接
            fos.close();
            dis.close();
            socket.close();
            serverSocket.close();

            System.out.println("文件接收完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
