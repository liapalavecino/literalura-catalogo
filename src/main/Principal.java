package view;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bienvenido al catálogo LiterAlura! Elija una opción:\n" +
                "1. Buscar libro por título\n" +
                "2. Buscar libro por autor\n" +
                "3. Listar autores registrados\n" +
                "4. Guardar un libro en la base de datos\n" +
                "5. Salir\n");
    }

    // Construimos el cliente con HttpClient
    HttpClient client = HttpClient.newHttpClient();

    // Construimos la solicitud con HttpRequest
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://gutendex.com/books"))
            .GET()
            .build();

    // Manejamos la respuesta del HttpResponse
        try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Respuesta de la API:");
        System.out.println(response.body());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

