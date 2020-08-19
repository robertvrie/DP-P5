package domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

public class Reiziger {
    private int reizigerId;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date gbdatum;
    private Set<OvChipkaart> kaarten;


    public Reiziger(){}
    public Reiziger(int reizigerId, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
        this.reizigerId = reizigerId;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.gbdatum = gbdatum;
    }

    public int getReizigerId() {
        return reizigerId;
    }

    public void setReizigerId(int reizigerId) {
        this.reizigerId = reizigerId;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public Set<OvChipkaart> getKaarten() { return kaarten; }

    public void setKaarten(Set<OvChipkaart> kaarten) { this.kaarten = kaarten; }


    //De if statements zijn bedoeld voor als een reiziger geen, 1 of meerdere chipkaarten heeft
    public String toString(){
        if(tussenvoegsel == null){
            tussenvoegsel = "";
        }
        else {
            tussenvoegsel = tussenvoegsel + " ";
        }
        String s = "\n" + voorletters + " " + tussenvoegsel + achternaam + " heeft reizigersId van: " + reizigerId + " en is geboren op " + gbdatum + ".";
        if(kaarten == null){
            s += " Geen kaarten in de lijst!";
        }
        else if(kaarten.isEmpty()){
            s += " Deze reiziger heeft geen kaarten.";
        }
        else{
            s = s + " Heeft de volgende kaarten: ";
            for(OvChipkaart o : kaarten){
                s = s + o.getKaartnummer() + ", ";
            }
        }
        return s;
    }
}
