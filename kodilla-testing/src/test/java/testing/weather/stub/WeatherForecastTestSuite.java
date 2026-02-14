package testing.weather.stub;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {

    Temperatures temperatures = new TemperaturesStub();
    WeatherForecast weatherForecast = new WeatherForecast(temperatures);

    @Test
    void testCalculateForecastWithStub() {

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverage() {

        double testAverageTemp = weatherForecast.averageTemp();

        Assertions.assertEquals(25.56, testAverageTemp);
    }

    @Test
    void testCalculateMedian() {

        double testMedianTemp = weatherForecast.medianTemp();

        Assertions.assertEquals(25.5, testMedianTemp);
    }
}
