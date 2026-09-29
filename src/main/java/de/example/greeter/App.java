package de.example.greeter;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    static String greet(String name) {
        return (name == null || name.isBlank()) ? "Hallo, Welt!" : "Hallo, " + name.strip() + "!";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            String query = exchange.getRequestURI().getQuery();
            String name = (query != null && query.startsWith("name=")) ? query.substring(5) : null;
            byte[] body = greet(name).getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, body.length);
            exchange.getResponseBody().write(body);
            exchange.close();
        });
        server.start();
        System.out.println("Greeter läuft auf Port 8080");
    }
}
