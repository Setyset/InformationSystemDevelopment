package ru.third;

public class Nascar implements RacingParticipant {
    private int racerRating;
    private final int engineRating;

    public Nascar(int racerRating, int engineRating){
        this.engineRating = engineRating;
        this.racerRating = racerRating;
    }

    @Override
    public void startEngine() {
        System.out.println("NASCAR car engine is on");
    }

    @Override
    public void stopEngine() {
        System.out.println("NASCAR car engine is off");
    }

    @Override
    public double lapTime(double distance){
        return distance / (racerRating * engineRating);
    }
}
