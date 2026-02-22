package world;

import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.World;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {

        Country papuaNowaGwinea = new Country("Papua-Nowa Gwinea", new BigDecimal("54297024"));
        Country indonezja = new Country("Indonezja", new BigDecimal("84762040"));

        Country sriLanka = new Country("Sri Lanka", new BigDecimal("7503487506"));
        Country malezja = new Country("Malezja", new BigDecimal("38575730065"));

        Continent niewiadomo = new Continent("Niewiadomo");
        niewiadomo.addCountry(papuaNowaGwinea);
        niewiadomo.addCountry(indonezja);

        Continent chybaAzja = new Continent("Chyba Azja");
        chybaAzja.addCountry(sriLanka);
        chybaAzja.addCountry(malezja);

        World world = new World();
        world.addContinents(niewiadomo);
        world.addContinents(chybaAzja);

        BigDecimal expected = new BigDecimal("54297024")
                .add(new BigDecimal("84762040"))
                .add(new BigDecimal("7503487506"))
                .add(new BigDecimal("38575730065"));

        // when
        BigDecimal result = world.getPeopleQuantity();

        // then
        assertEquals(0, expected.compareTo(result));
    }
}
