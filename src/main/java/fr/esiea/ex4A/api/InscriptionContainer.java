package fr.esiea.ex4A.api;

import fr.esiea.ex4A.Agify.ServiceAgify;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class InscriptionContainer {

    private final ServiceAgify serviceAgify;

    public InscriptionContainer(ServiceAgify serviceAgify) {
        this.serviceAgify = serviceAgify;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    void inscription(@RequestBody InscriptionData inscriptionData) {
        serviceAgify.nouveauInscrit(inscriptionData);
    }
}
