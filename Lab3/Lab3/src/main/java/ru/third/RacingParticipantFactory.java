package ru.third;

public class RacingParticipantFactory {
    public static RacingParticipant createParticipant (String carType, int varRating, int finalRating) {
        if ("FormulaOne".equalsIgnoreCase(carType)) {
            return new FormulaOne(varRating, finalRating);
        }
        if ("Nascar".equalsIgnoreCase(carType)){
            return new Nascar(varRating, finalRating);
        }
        throw new RuntimeException("Wrong car type!");
    }
}
