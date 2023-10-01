package ru.second;

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
    public double lapTime(double distance) {
        return distance / (tiresRating * tiresRating * teamRating);
    }
}
