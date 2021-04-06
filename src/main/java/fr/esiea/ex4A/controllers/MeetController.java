package fr.esiea.ex4A.controllers;

import fr.esiea.ex4A.models.InscriptionData;
import fr.esiea.ex4A.services.AgifyService;
import fr.esiea.ex4A.services.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class MeetController {

    private final InscriptionService userService;
    private final AgifyService agifyService;

    public MeetController(InscriptionService userService, AgifyService agifyService) {
        this.userService = userService;
        this.agifyService = agifyService;
    }

    @PostMapping(value = "/inscription", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> register(@RequestBody InscriptionData user) {
        return new ResponseEntity<>(this.userService.register(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/matches", produces = "application/json")
    public ResponseEntity<?> findMatches(@RequestParam(value = "userName") String username, @RequestParam(value = "userCountry") String country) {
        return new ResponseEntity<>(this.agifyService.getMatches(this.userService.get(username, country)), HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.userService.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/responses", produces = "application/json")
    public ResponseEntity<?> getAllAgifyResponses() {
        return new ResponseEntity<>(this.agifyService.getMatches(), HttpStatus.OK);
    }

}
