package sergiomaselli.u5progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u5progetto.entities.Edificio;
import sergiomaselli.u5progetto.exceptions.NotFoundException;
import sergiomaselli.u5progetto.repositories.EdificioRepository;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> findAll() {
        return edificioRepository.findAll();
    }

    public Edificio findById(Long id) {
        return edificioRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Edificio save(Edificio e) {
        return edificioRepository.save(e);
    }
}
