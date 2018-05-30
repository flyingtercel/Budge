package us.mifeng.budgedemo.budge;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 黑夜之火 on 2018/5/30.
 */

public class MySever {
    public static void main(String[]args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        while(true){
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("你好，你收到服务器的祝福");
            ps.close();
            s.close();
        }
    }
}
