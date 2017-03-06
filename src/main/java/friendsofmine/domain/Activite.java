package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by valen on 27/02/2017.
 */
public class Activite {

    @NotEmpty
    @NotNull
    private String titre;

    private String description;

    public Activite(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }
}
