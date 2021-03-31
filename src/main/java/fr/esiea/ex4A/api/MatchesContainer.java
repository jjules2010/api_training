package fr.esiea.ex4A.api;

import fr.esiea.ex4A.Agify.ServiceAgify;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
class MatchesContainer {

    private final ServiceAgify serviceAgify;
    private final MatchesRepository matchesRepository;

    public MatchesContainer(ServiceAgify serviceAgify, MatchesRepository matchesRepository) {
        this.serviceAgify = serviceAgify;
        this.matchesRepository = matchesRepository;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MatchesData> responseMatches(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        final List<MatchesData> matches = serviceAgify.getMatches(name, country);
        return matches;
    }
}
