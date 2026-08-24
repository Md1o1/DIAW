package com.example.clima.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClimaService {

    private final RestClient restClient;

    @Value("${clima.api.url}")
    private String apiUrl;

    @Value("${clima.api.latitude}")
    private String latitude;

    @Value("${clima.api.longitude}")
    private String longitude;

    @Value("${clima.api.timezone}")
    private String timezone;

    public ClimaService(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

    public Map<String, Object> obterClima() {

        String url = apiUrl
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current=temperature_2m"
                + ",relative_humidity_2m"
                + ",wind_speed_10m"
                + ",wind_direction_10m"
                + ",weather_code"
                + "&daily=temperature_2m_max"
                + ",temperature_2m_min"
                + "&timezone=" + timezone;

        Map<String, Object> dados = restClient.get()
                .uri(url)
                .retrieve()
                .body(Map.class);

        Map<String, Object> current =
                (Map<String, Object>) dados.get("current");

        Map<String, Object> daily =
                (Map<String, Object>) dados.get("daily");

        Map<String, Object> resposta = new HashMap<>();

        // Localização
        resposta.put("cidade", "Belo Horizonte");
        resposta.put("estado", "MG");

        // Temperatura atual
        resposta.put(
                "temperaturaAtual",
                current.get("temperature_2m")
        );

        // Umidade do ar
        resposta.put(
                "umidade",
                current.get("relative_humidity_2m")
        );

        // Velocidade do vento
        resposta.put(
                "velocidadeVento",
                current.get("wind_speed_10m")
        );

        // Direção do vento
        resposta.put(
                "direcaoVento",
                current.get("wind_direction_10m")
        );

        // Código da condição climática
        int weatherCode =
                ((Number) current.get("weather_code")).intValue();

        String descricao =
                obterDescricaoClima(weatherCode);

        resposta.put(
                "condicaoClimatica",
                descricao
        );

        resposta.put(
                "descricao",
                descricao
        );

        // Temperatura máxima
        List<?> temperaturasMaximas =
                (List<?>) daily.get("temperature_2m_max");

        resposta.put(
                "temperaturaMaxima",
                temperaturasMaximas.get(0)
        );

        // Temperatura mínima
        List<?> temperaturasMinimas =
                (List<?>) daily.get("temperature_2m_min");

        resposta.put(
                "temperaturaMinima",
                temperaturasMinimas.get(0)
        );

        // Data e hora da consulta
        resposta.put(
                "dataHoraConsulta",
                OffsetDateTime.now().toString()
        );

        return resposta;
    }

    private String obterDescricaoClima(int codigo) {

        return switch (codigo) {

            case 0 ->
                    "Céu limpo";

            case 1 ->
                    "Principalmente limpo";

            case 2 ->
                    "Parcialmente nublado";

            case 3 ->
                    "Nublado";

            case 45, 48 ->
                    "Neblina";

            case 51, 53, 55 ->
                    "Garoa";

            case 56, 57 ->
                    "Garoa congelante";

            case 61, 63, 65 ->
                    "Chuva";

            case 66, 67 ->
                    "Chuva congelante";

            case 71, 73, 75, 77 ->
                    "Neve";

            case 80, 81, 82 ->
                    "Pancadas de chuva";

            case 85, 86 ->
                    "Pancadas de neve";

            case 95 ->
                    "Trovoada";

            case 96, 99 ->
                    "Trovoada com granizo";

            default ->
                    "Condição desconhecida";
        };
    }
}