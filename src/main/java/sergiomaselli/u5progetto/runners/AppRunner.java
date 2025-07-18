package sergiomaselli.u5progetto.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sergiomaselli.u5progetto.entities.Postazione;
import sergiomaselli.u5progetto.entities.Prenotazione;
import sergiomaselli.u5progetto.entities.Utente;
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

//        //Creazione Edificio
//        Edificio edificio = new Edificio("Edificio Beta", "Via Sassi 3", "Bari");
//        edificio = edificioService.save(edificio);
//
//        //Creazione Postazione
//        Postazione postazione = new Postazione("Postazione privata", TipoPostazione.PRIVATO, 10L, edificio);
//        postazione = postazioneService.save(postazione);
//
//        //Creazione Utente
//        Utente utente = new Utente("Sergio-dev", "Sergio Maselli", "sergio.maselli@example.com");
//        utente = utenteService.save(utente);
//
//        //Creazione Prenotazione
//        Prenotazione prenotazione = new Prenotazione(LocalDate.now(), utente, postazione);
//        prenotazioneService.save(prenotazione);
//
//        System.out.println("Dati caricati correttamente.");
        System.out.println("****Test Prenotazione****");
        testPrenotazione();

    }

    void testPrenotazione() {
        try {
            Postazione postazione = postazioneService.findById(2L);
            Utente utente = utenteService.findById("Marione");

            Prenotazione p = new Prenotazione();
            p.setPostazione(postazione);
            p.setUtente(utente);
            p.setDataPrenotazione(LocalDate.of(2025, 8, 8));

            Prenotazione saved = prenotazioneService.save(p);
            System.out.println("Prenotazione salvata con successo");

            Prenotazione conferma = prenotazioneService.findById(saved.getId());
            System.out.println("Conferma: Prenotazione ID = " + conferma.getId() +
                    ", Data = " + conferma.getDataPrenotazione() +
                    ", Utente = " + conferma.getUtente().getUsername() +
                    ", Postazione = " + conferma.getPostazione().getDescrizione());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}



