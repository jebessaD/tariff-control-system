package com.imala.imala.crossCountry;

import com.imala.imala.crosscountry.CrossCountry;
import com.imala.imala.crosscountry.CrossRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DataJpaTest
class CrossRepositoryTest {


    @Autowired
    private CrossRepository underTest;

    @Test
    void findTariff() {
//        given
        String departure = "Finfinne";
        String destination = "Yabello";
        String bus = "ODA";

        CrossCountry cross = new CrossCountry(

                1L,
                departure,
                destination,
                500,
                bus
        );
        underTest.save(cross);

//        when

         CrossCountry expected = underTest.findTariff(departure, destination, bus);

//        then
        assertThat(expected.getDeparture()).isEqualTo(cross.getDeparture());
        assertThat(expected.getTariff()).isEqualTo(cross.getTariff());
        assertThat(expected.getDestination()).isEqualTo(cross.getDestination());
        assertThat(expected.getBus()).isEqualTo(cross.getBus());
    }
}