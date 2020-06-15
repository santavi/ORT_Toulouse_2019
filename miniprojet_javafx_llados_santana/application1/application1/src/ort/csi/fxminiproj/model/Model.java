package ort.csi.fxminiproj.model;

public class Model {
    
   int iddevis;
   int idproduit;
   int idclient;
   String Date;
   int Quantite;

    public Model(int iddevis, int idproduit, int idclient, String Date, int Quantite) {
        this.iddevis = iddevis;
        this.idproduit = idproduit;
        this.idclient = idclient;
        this.Date = Date;
        this.Quantite = Quantite;
    }

    public int getiddevis() {
        return iddevis;
    }

    public void setiddevis(int iddevis) {
        this.iddevis = iddevis;
    }

    public int getidproduit() {
        return idproduit;
    }

    public void setidproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getidclient() {
        return idclient;
    }

    public void setidclient(int idclient) {
        this.idclient = idclient;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    
    
}
