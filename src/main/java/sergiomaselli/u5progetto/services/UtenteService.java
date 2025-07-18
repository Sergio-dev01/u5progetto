package sergiomaselli.u5progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u5progetto.entities.Utente;
import sergiomaselli.u5progetto.exceptions.NotFoundException;
import sergiomaselli.u5progetto.repositories.UtenteRepository;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Utente findById(String username) {
        return utenteRepository.findById(username).orElseThrow(() -> new NotFoundException(username));
    }

    public Utente save(Utente u) {
        return utenteRepository.save(u);
    }
}

