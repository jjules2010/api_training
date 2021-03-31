package fr.esiea.ex4A.Agify;

import fr.esiea.ex4A.api.InscriptionData;
import fr.esiea.ex4A.api.MatchesData;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ServiceAgify{

    public final AgifyClient agifyClient;
    public final HashMap<String, ServiceData> inscrits;
    
    public ServiceAgify(AgifyClient agifyClient){
        this.agifyClient = agifyClient;
        this.inscrits = new HashMap<String, ServiceData>();
    }
    
    public void nouveauInscrit(InscriptionData inscriptionData){
        final String key = inscriptionData.userName + ";"+ inscriptionData.userCountry;
        if(inscrits.containsKey(key)){
            return;
        }
        Call<AgifyResponse> call = agifyClient.getAge(inscriptionData.userName, inscriptionData.userCountry);
        call.enqueue(new Callback<AgifyResponse>() {
            @Override
            public void onResponse(Call<AgifyResponse> call, Response<AgifyResponse> response) {
                if(response.isSuccessful()){
                    AgifyResponse agifyResponse = response.body();
                    inscrits.put(inscriptionData.userName + ";"+ inscriptionData.userCountry, new ServiceData(inscriptionData.userEmail, inscriptionData.userName, inscriptionData.userTweeter, inscriptionData.userCountry, inscriptionData.userSex, inscriptionData.userSexPref, agifyResponse.age));
                }
            }
            @Override
            public void onFailure(Call<AgifyResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
    
    public List<MatchesData> getMatches(String userName, String userCountry){
        final String key = userName + ";" + userCountry;
        final ServiceData data = this.inscrits.get(key);
        if(data == null){
            return null;
        }
        final List<MatchesData> matchesDatas = new ArrayList<MatchesData>();
        inscrits.forEach((k, v) -> {
            if(data.userSex.equals(v.userSexPref) && data.userSexPref.equals(v.userSex) && (Math.abs(data.age - v.age)) < 5)
            {
                matchesDatas.add(new MatchesData(v.userName,v.userTweeter));
            }
        });
        return matchesDatas;
    }
}
