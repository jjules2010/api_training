package fr.esiea.ex4A.services;

import fr.esiea.ex4A.models.InscriptionData;
import fr.esiea.ex4A.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscriptionService {

    private final UserRepository userRepository;
    private final AgifyService agifyService;

    public InscriptionService(UserRepository userRepository, AgifyService agifyService) {
        this.userRepository = userRepository;
        this.agifyService = agifyService;
    }
    public InscriptionData register(InscriptionData user){
        try { this.agifyService.getAge(user); } catch (Exception e) {}
        return this.userRepository.add(user);
    }
    public InscriptionData get(String username, String country) { return this.userRepository.getAll().stream().filter(x -> x.getUserName().equalsIgnoreCase(username)).filter(x -> x.getUserCountry().equalsIgnoreCase(country)).findFirst().get();}
    public List<InscriptionData> get() { return this.userRepository.getAll(); }
}
