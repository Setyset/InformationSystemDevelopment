package ru.second;

public class Nascar implements RacingParticipant {
    private int racerRating;
    private final int engineRating;

    public Nascar(int engineRating, int racerRating){
        this.engineRating = engineRating;
        this.racerRating = racerRating;
    }

    @Override
    public double lapTime(double distance){
        return distance / (racerRating * engineRating);
    }
}
