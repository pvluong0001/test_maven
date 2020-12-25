package lit;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Result {
    public Integer id = 0;
    public String company_certificate_type = "";
    public String certificate_num = "";
}

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://ac-dev.legal-script.com/api/v1/sikulix/first-data-for-sikulix"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body();

        Gson gson = new Gson();
        Result result = gson.fromJson(responseString, Result.class);
        System.out.println(result.id);
        System.out.println(result.company_certificate_type);
        System.out.println(result.certificate_num);

        System.out.println(responseString);
    }
}
