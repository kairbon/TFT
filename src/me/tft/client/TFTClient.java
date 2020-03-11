package me.tft.client;

import me.tft.common.Encoder;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;

public class TFTClient {

  public static void main(String[] args) {
    try {
      String fp;
      if(args.length == 0) {
        System.out.println("Please enter file path");
        return;
      }
      fp = args[0];
      Socket socket = new Socket("127.0.0.1", 9999);
      OutputStream ops = socket.getOutputStream();
      File file = Paths.get("fp").toFile();
      byte[] content = Encoder.fileEncode(file);
      ops.write(content);
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      int result = dis.readUnsignedShort();
      if (result == 1) {
        System.out.println("OK");
      }
      socket.shutdownOutput();
      socket.shutdownInput();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
