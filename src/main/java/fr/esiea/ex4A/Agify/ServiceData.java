package fr.esiea.ex4A.Agify;


public class ServiceData {

    public final String userEmail;
    public final String userName;
    public final String userTweeter;
    public final String userCountry;
    public final String userSex;
    public final String userSexPref;
    public final int age;


    public ServiceData(String userEmail, String userName, String userTweeter, String userCountry, String userSex, String userSexPref, int age) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.age = age;
    }
}

