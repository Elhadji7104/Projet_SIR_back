package metier;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class ReponsesSondage {

    private long idReponse;
    private Sondage sondage;
    private String mail;
    public ReponsesSondage(long idReponse) {
        this.idReponse = idReponse;
    }
    @Id
    @GeneratedValue
    public long getIdReponse() {
        return idReponse;
    }
    public void setIdReponse(long idReponse) {
        this.idReponse = idReponse;
    }
    public ReponsesSondage() {}


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @ManyToOne
    @JsonBackReference(value = "sondage_reponse")
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

}
