package ru.second;

import java.util.List;

public class Race {
    private final RacingParticipant participant1;
    private final RacingParticipant participant2;
    private double lapDistance;

    public Race(RacingParticipant participant1, RacingParticipant participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public void setLapDistance(double lapDistance) {
        this.lapDistance = lapDistance;
    }

    public void CompleteRace(int laps) {
        System.out.println("Время заезда первого участника: " + participant1.lapTime(lapDistance) * laps);
        System.out.println("Время заезда второго участника: " + participant2.lapTime(lapDistance) * laps);
    }
}
