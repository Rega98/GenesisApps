/*
 * MODELO: Ruta
 * Crear el objeto de Ruta para crear instancias
 */
package Model;

/**
 *
  * @author Jeanny and Teresita
 */
public class Ruta {
    
  protected int idRuta;
  protected String descripcionRuta;
  protected int rutas; 
  //protected int contratofolio;
  
  
  public Ruta(){}

    public Ruta(int idRuta, String descripcionRuta, int rutas) {
        this.idRuta = idRuta;
        this.descripcionRuta = descripcionRuta;
        this.rutas = rutas;
        //this.contratofolio = contratofolio;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getDescripcionRuta() {
        return descripcionRuta;
    }

    public void setDescripcionRuta(String descripcionRuta) {
        this.descripcionRuta = descripcionRuta;
    }

    public int getRutas() {
        return rutas;
    }

    public void setRutas(int rutas) {
        this.rutas = rutas;
    }

    /*public int getContratofolio() {
        return contratofolio;
    }

    public void setContratofolio(int contratofolio) {
        this.contratofolio = contratofolio;
    }*/
  
    
}//llave que cierra
