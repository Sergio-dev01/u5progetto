package sergiomaselli.u5progetto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    private String nomeCompleto;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;

    }
}
