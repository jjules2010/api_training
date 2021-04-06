package fr.esiea.ex4A.repositories;

import fr.esiea.ex4A.models.AgifyResponse;
import fr.esiea.ex4A.models.InscriptionData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<InscriptionData> users = new ArrayList<>();

    public InscriptionData add(InscriptionData user) {
        return this.users.add(user) ? user : null;
    }

    public InscriptionData remove(InscriptionData user) {
        return this.users.remove(user) ? user : null;
    }

    public List<InscriptionData> getAll() {
        return this.users;
    }

    public InscriptionData get(AgifyResponse response) {
        return this.users.stream().filter(x -> x.getUserName().equalsIgnoreCase(response.getName())).findFirst().get();
    }
}
