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
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
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
            ConsoleHelper.writeMessage("New connection established with " + String.valueOf(socket.getRemoteSocketAddress()));
            String currentUserName = null;
            try (Connection connection = new Connection(socket)) {
                currentUserName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, currentUserName));
                notifyUsers(connection, currentUserName);
                serverMainLoop(connection, currentUserName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, currentUserName));
                connectionMap.remove(currentUserName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Remote server data exchange error!");
            } finally {
                ConsoleHelper.writeMessage("Connection closed");
            }

        }


    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started!");
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
