package sergiomaselli.u5progetto.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sergiomaselli.u5progetto.entities.Edificio;
import sergiomaselli.u5progetto.entities.Postazione;
import sergiomaselli.u5progetto.entities.Prenotazione;
import sergiomaselli.u5progetto.entities.Utente;
import sergiomaselli.u5progetto.enums.TipoPostazione;
import sergiomaselli.u5progetto.services.EdificioService;
import sergiomaselli.u5progetto.services.PostazioneService;
import sergiomaselli.u5progetto.services.PrenotazioneService;
import sergiomaselli.u5progetto.services.UtenteService;

import java.time.LocalDate;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        //Creazione Edificio
        Edificio edificio = new Edificio("Edificio Alpha", "Via Roma 1", "Milano");
        edificio = edificioService.save(edificio);

        //Creazione Postazione
        Postazione postazione = new Postazione("Postazione open space", TipoPostazione.OPENSPACE, 5L, edificio);
        postazione = postazioneService.save(postazione);

        //Creazione Utente
        Utente utente = new Utente("Mario Rossi", "Marione", "mario.rossi@example.com");
        utente = utenteService.save(utente);

        //Creazione Prenotazione
        Prenotazione prenotazione = new Prenotazione(LocalDate.now(), utente, postazione);
        prenotazioneService.save(prenotazione);

        System.out.println("Dati caricati correttamente.");
    }

}
