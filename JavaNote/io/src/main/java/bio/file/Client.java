package bio.file;

/**
 * @author 刘佳俊
 */

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 目标：实现客户端上传任意类型的文件数据给服务端保存起来
 * @author asus
 */
public class Client {
    public static void main(String[] args) {
        try (InputStream is = new
                        FileInputStream("E:\\data\\手机文件\\图片\\01.jpg");) {
            //1.请求与服务端的Socket连接
            Socket socket = new Socket("127.0.0.1", 8888);
            //2.把字节输出流包装成一个数据输出流(DataOutputStream可以做分段数据发送)
            DataOutputStream dos = new
                    DataOutputStream(socket.getOutputStream());
            //3.先发送上传文件的后缀给服务器
            dos.writeUTF(".jpg");
            //4.把文件数据发送给服务端进行接收
            //InputStream is = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\1.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer, 0, len);
            }
            dos.flush();
            socket.shutdownOutput();//通知服务端，我客户端这边的数据已经发送完毕了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
