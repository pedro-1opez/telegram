import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Telegram {

    public static void sendToTelegram() {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        // Add Telegram token (given Token is fake)
        String apiToken = "6218106530:AAH3aVYx9xHkCFWtj6NzDHZ22G0_rQLvP_w";

        // Add chatId (given chatId is fake)
        String chatId = "6686652319";
        String text = "Este es un mensaje enviado desde el bot de telegram";

        urlString = String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            StringBuilder sb = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            String response = sb.toString();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}