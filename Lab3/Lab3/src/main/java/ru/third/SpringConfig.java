package ru.third;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.third")
@PropertySource("classpath:race.properties")
public class SpringConfig {
    @Value("${lapDistance}")
    private double distance;

    @Bean(name = "race")
    public Race race() {
        Race race = new Race(nascar(), formulaOne());
        race.setLapDistance(distance);
        return race;
    }

    @Bean(name = "nascar", initMethod = "startEngine", destroyMethod = "stopEngine")
    public Nascar nascar() {
        return (Nascar) RacingParticipantFactory.createParticipant("nascar", 4, 10);
    }

    @Bean(name = "formulaOne", initMethod = "startEngine", destroyMethod = "stopEngine")
    public FormulaOne formulaOne(){
        return (FormulaOne) RacingParticipantFactory.createParticipant("formulaOne", 5, 3);
    }
}
