package com.croct;

import com.croct.event.InputEvent;
import com.croct.event.OutputEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class IpLocationService {

    private static final String ACESS_KEY = "0a7406d812570ffc698df71850867682";
    private static final String ENDPOINT_IPSTACK = "http://api.ipstack.com";


    public static OutputEvent consumeIpStack(InputEvent inputEvent) {
        OkHttpClient client = new OkHttpClient();
        OutputEvent outputEvent = null;
        ObjectMapper objectMapper = new ObjectMapper();


        Request request = new Request.Builder()
                .url(String.format("%s/%s?access_key=%s", ENDPOINT_IPSTACK, inputEvent.getIp(), ACESS_KEY))
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            JsonNode jsonNode = objectMapper.readTree(response.body().toString());

            outputEvent = new OutputEvent(inputEvent.getClienteId(),
                    System.currentTimeMillis(),
                    inputEvent.getIp(),
                    Double.valueOf(String.valueOf(jsonNode.get("latitude"))),
                    Double.valueOf(String.valueOf(jsonNode.get("longitude"))),
                    String.valueOf(jsonNode.get("country")),
                    String.valueOf(jsonNode.get("region")),
                    String.valueOf(jsonNode.get("city"))
                    );

        } catch (IOException e) {
            System.out.println("Excecao gerada ao consumir o servico do IPSTACK. "+e.getMessage());
            System.out.println("*****************");
            e.printStackTrace();
        }
        return outputEvent;
    }
}
