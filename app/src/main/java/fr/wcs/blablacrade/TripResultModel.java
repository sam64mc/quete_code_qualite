package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {
    private String firstName;
    private Date depart;
    private int prix;

    public TripResultModel(String firstName, Date depart, int prix) {
        this.firstName = firstName;
        this.depart = depart;
        this.prix = prix;
    }

    public Date getDepart() {
        return depart;
    }

    public int getPrix() {
        return prix;
    }

    public String getFirstName() {
        return firstName;
    }
}
