package fr.esiea.ex4A.repositories;

import fr.esiea.ex4A.models.AgifyResponse;
import fr.esiea.ex4A.models.InscriptionData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MatchesRepository {
    private final List<AgifyResponse> responses = new ArrayList<>();
    public AgifyResponse add(AgifyResponse response) {
        return this.responses.add(response) ? response : null;
    }
    public AgifyResponse remove(AgifyResponse response) {
        return this.responses.remove(response) ? response : null;
    }
    public List<AgifyResponse> get() {
        return this.responses;
    }
    public AgifyResponse get(InscriptionData user) {
        return this.responses.stream().filter(x -> x.getName().equalsIgnoreCase(user.getUserName())).filter(x -> x.getCountry().equalsIgnoreCase(user.getUserCountry())).findFirst().get();
    }
    public Boolean contains(InscriptionData user) {
        return  this.responses.stream().filter(x -> x.getName().equalsIgnoreCase(user.getUserName())).filter(x -> x.getCountry().equalsIgnoreCase(user.getUserCountry())).findFirst().isPresent();
    }
}
