package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends  Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response =  connection.receive();
                String name = response.getData();
                if(response.getType() == MessageType.USER_NAME){
                    if (!name.equals("")){
                        if(!connectionMap.containsKey(name)){
                            connectionMap.put(name, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return name;
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started!");
            while (true){
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> connection : connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Unable to send message to " + connection.getKey());
            }
        }
    }

}
