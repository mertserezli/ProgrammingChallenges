package com.company;

import java.util.Random;

public class RandomSentenceGenerator {
    private static String[] properNoun = {"Fred","Jane","Richard Nixon","Miss America"};
    private static String[] determiner = {"a","the","every","some"};
    private static String[] adjective = {"big","tiny","pretty","bald"};
    private static String[] commonNoun = {"man","woman","fish","elephant","unicorn"};
    private static String[] transitiveVerb = {"loves","hates","sees","knows","looks for", "finds"};

    public static String getRandomSentence(){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append( properNoun[r.nextInt(properNoun.length)] );
        sb.append(" ");
        sb.append( transitiveVerb[r.nextInt(transitiveVerb.length)] );
        sb.append(" ");
        sb.append( determiner[r.nextInt(determiner.length)] );
        sb.append(" ");
        sb.append( adjective[r.nextInt(adjective.length)] );
        sb.append(" ");
        sb.append( commonNoun[r.nextInt(commonNoun.length)] );
        sb.append(".");
        return sb.toString();
    }
}
