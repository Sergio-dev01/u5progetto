package sergiomaselli.u5progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u5progetto.entities.Prenotazione;
import sergiomaselli.u5progetto.exceptions.NotFoundException;
import sergiomaselli.u5progetto.exceptions.ReservationNotAvailable;
import sergiomaselli.u5progetto.repositories.PrenotazioneRepository;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Prenotazione save(Prenotazione p) throws Exception {
        boolean postazioneOccupata = prenotazioneRepository
                .existsByPostazioneIdAndDataPrenotazione(p.getPostazione().getId(), p.getDataPrenotazione());

        if (postazioneOccupata) {
            throw new ReservationNotAvailable("La postazione è già prenotata per questa data.");
        }

        return prenotazioneRepository.save(p);
    }

}

