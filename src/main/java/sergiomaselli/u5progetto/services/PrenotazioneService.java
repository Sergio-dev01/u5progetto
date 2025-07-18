package sergiomaselli.u5progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import sergiomaselli.u5progetto.entities.Prenotazione;
import sergiomaselli.u5progetto.exceptions.NotFoundException;
import sergiomaselli.u5progetto.repositories.PrenotazioneRepository;

import java.util.List;

public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Prenotazione save(Prenotazione p) {
        return prenotazioneRepository.save(p);
    }
}
