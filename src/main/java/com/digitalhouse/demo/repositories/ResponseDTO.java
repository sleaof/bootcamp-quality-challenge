package com.digitalhouse.demo.repositories;

import java.util.HashMap;

public class ResponseDTO {
    private Double totalMetrosQuadrados;
    private Double valorPropriedade;
    private String maiorQuarto;
    private HashMap<String, Double> metroQuadradoPorQuarto;

    public Double getTotalMetrosQuadrados() {
        return totalMetrosQuadrados;
    }

    public void setTotalMetrosQuadrados(Double totalMetrosQuadrados) {
        this.totalMetrosQuadrados = totalMetrosQuadrados;
    }

    public Double getValorPropriedade() {
        return valorPropriedade;
    }

    public void setValorPropriedade(Double valorPropriedade) {
        this.valorPropriedade = valorPropriedade;
    }

    public String getMaiorQuarto() {
        return maiorQuarto;
    }

    public void setMaiorQuarto(String maiorQuarto) {
        this.maiorQuarto = maiorQuarto;
    }

    public HashMap<String, Double> getMetroQuadradoPorQuarto() {
        return metroQuadradoPorQuarto;
    }

    public void setMetroQuadradoPorQuarto(HashMap<String, Double> metroQuadradoPorQuarto) {
        this.metroQuadradoPorQuarto = metroQuadradoPorQuarto;
    }
}
