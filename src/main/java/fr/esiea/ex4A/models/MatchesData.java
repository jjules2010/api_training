package fr.esiea.ex4A.models;

public class MatchesData {

    private final String name;
    private final String twitter;

    public MatchesData(String name, String twitter) {
        this.name = name;
        this.twitter = twitter;
    }

    public MatchesData(InscriptionData user) {
        this.name = user.getUserName();
        this.twitter = user.getUserTweeter();
    }

    public String getName() { return name; }
    public String getTwitter() { return twitter; }
}
