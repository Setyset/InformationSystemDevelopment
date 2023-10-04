package ru.third;

public class FormulaOne implements RacingParticipant {
    private int teamRating;
    private final int tiresRating;

    public FormulaOne(int teamRating, int tiresRating) {
        this.teamRating = teamRating;
        this.tiresRating = tiresRating;
    }

    public void setTeamRating(int teamRating) {
        this.teamRating = teamRating;
    }

    @Override
    public void startEngine() {
        System.out.println("F1 car engine is on");
    }

    @Override
    public void stopEngine() {
        System.out.println("F1 car engine is off");
    }

    @Override
    public double lapTime(double distance) {
        return distance / (tiresRating * tiresRating * teamRating);
    }
}
