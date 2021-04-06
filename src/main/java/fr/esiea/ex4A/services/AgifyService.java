package fr.esiea.ex4A.services;

import fr.esiea.ex4A.agify.AgifyClient;
import fr.esiea.ex4A.models.AgifyResponse;
import fr.esiea.ex4A.models.InscriptionData;
import fr.esiea.ex4A.models.MatchesData;
import fr.esiea.ex4A.repositories.MatchesRepository;
import fr.esiea.ex4A.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AgifyService {

    private final AgifyClient agifyClient;
    private final MatchesRepository repository;
    private final UserRepository userRepository;

    public AgifyService(AgifyClient agifyClient, MatchesRepository repository, UserRepository userRepository){
        this.agifyClient = agifyClient;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public AgifyResponse getAge(InscriptionData user) throws Exception {
        return this.repository.contains(user) ? this.repository.get(user) : this.repository.add(this.agifyClient.getAge(user.getUserName(), user.getUserCountry()).execute().body());
    }

    public List<AgifyResponse> getMatches() {
        return this.repository.get();
    }

    public List<MatchesData> getMatches(InscriptionData user){
        return this.repository.get().stream().filter(x -> {
            try { return Math.abs(x.getAge() - this.getAge(user).getAge()) <= 4; } catch (Exception e) { return false; }})
            .filter(x -> x.getCountry().equalsIgnoreCase(user.getUserCountry()))
            .filter(x -> !x.getName().equalsIgnoreCase(user.getUserName()))
            .filter(x -> this.userRepository.get(x).getUserSex().equalsIgnoreCase(user.getUserSexPref()))
            .filter(x -> this.userRepository.get(x).getUserSexPref().equalsIgnoreCase(user.getUserSex()))
            .collect(Collectors.toList())
            .stream().map(response -> new MatchesData(this.userRepository.get(response))).collect(Collectors.toList());
    }
}
