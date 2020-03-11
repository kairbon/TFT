package me.tft.server;

public class ExampleTFTServer {
  public final static int PORT = 9999;

  public final static String STORE_PATH = "F:\\output";

  public static void main(String[] args) {
    AbstractServer server = null;
    if (args.length == 0) {
      System.out.println("Please select IO mode(BIO/NIO) and file path");
    }
    if (args[0].equals("BIO")) {
      server = new NIOTFTServer();
    } else if (args[0].equals("NIO")) {
      server = new IOTFTServer();
    }
    server.setPort(PORT);
    server.setStorePath(args[1]);
    server.run();
  }
}
