package com.kodilla.testing.weather.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {

    private Temperatures temperatures;


    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature:
            temperatures.getTemperatures().entrySet()) {
                resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemp() {
        Map<String, Double> temps = temperatures.getTemperatures();

        double sum = 0.0;
        for (double t : temps.values()) {
            sum += t;
        }
        return sum / temps.size();
    }

    public double medianTemp() {
        Map<String, Double> temps = temperatures.getTemperatures();

        List<Double> values = new ArrayList<>(temps.values());
        values.sort(Double::compareTo);

        int mid = values.size() / 2;

        if (values.size() % 2 == 0 ) {
            return (values.get(mid - 1) + values.get(mid + 1)) / 2.0;
        }
        return values.get(mid);
    }
}
