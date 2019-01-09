/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stroescu Andrei
 */
public class Masini {
    private int ID;
    private String marca;
    private String model;
    private int anFabricatie;
    private String culoare;
    private String descriere;
    private float pretZi;
    private String tractiune;
    private String consum;
    private byte[] poza;
 
    public Masini(int pID,String pmarca,String pmodel,int panFabricatie,String pculoare, String pdescriere,float ppretZi,String ptractiune,String pconsum,byte[] ppoza)
    {
        this.ID=pID;
        this.marca=pmarca;
        this.model=pmodel;
        this.anFabricatie=panFabricatie;
        this.culoare=pculoare;
        this.descriere=pdescriere;
        this.pretZi=ppretZi;
        this.tractiune=ptractiune;
        this.consum=pconsum;
        this.poza=ppoza;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getmarca(){
        return marca;
    }
    
    public String getmodel(){
        return model;
    }
    
    public int getanFabricatie(){
        return anFabricatie;
    }
    
    public String getculoare(){
        return culoare;
    }
    
    public String getdescriere(){
        return descriere;
    }
    
    public float getpretZi(){
        return pretZi;
    }
    
    public String gettractiune(){
        return tractiune;
    }
    
    public String getconsum(){
        return consum;
    }
    
    public byte[] getimagine(){
        return poza;
    }
    
   
}
    