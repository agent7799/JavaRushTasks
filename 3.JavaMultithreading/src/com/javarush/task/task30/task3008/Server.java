package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();
                String userName = response.getData();
                if (response.getType() == MessageType.USER_NAME) {
                    if (!userName.equals("")) {
                        if (!connectionMap.containsKey(userName)) {
                            connectionMap.put(userName, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return userName;
                        }
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String s : connectionMap.keySet()) {
                if (!s.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                message = connection.receive();
                if (message.getType() == (MessageType.TEXT)) {
                    String messageToAll = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageToAll));
                } else {
                    ConsoleHelper.writeMessage("ERROR! Message is not text!");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("New connection established with " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Remote server data exchange error!");
                ConsoleHelper.writeMessage("connection lost with " + socket.getRemoteSocketAddress());
            } finally {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Connection closed");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter server port: ");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started on port " + port);
            System.out.println("Server address: " +  serverSocket.getInetAddress().getHostName());
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connections : connectionMap.entrySet()) {
            try {
                connections.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Unable to send message to " + connections.getKey());
            }
        }
    }

}
