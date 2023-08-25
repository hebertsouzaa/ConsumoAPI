package projeto_sam;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class token {

    public static String generateToken(String username, String password) throws IOException {
        String apiUrl = "https://apis.ons.org.br/aneel/v1/Autenticar";

        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonInputString = "{\"usuario\": \"" + username + "\", \"senha\": \"" + password + "\"}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        System.out.println("Status Code: " + connection.getResponseCode());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            JSONObject jsonResponse = new JSONObject();
            String token = jsonResponse.getString("access_token");
            System.out.println("Token: " + token);
            return token;
        }
    }

    public static void main(String[] args) {
        String in_username = "seu_usuario";
        String in_password = "sua_senha";
        String out_token = "";

        try {
            out_token = generateToken(in_username, in_password);
            System.out.println("out_token: " + out_token);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar token: " + e.getMessage());
        }
    }
}
