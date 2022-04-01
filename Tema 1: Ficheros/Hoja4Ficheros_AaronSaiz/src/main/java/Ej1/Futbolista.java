package Ej1;

/**
 *
 * @author usuario
 */


public class Futbolista {
    
public enum Puesto{PORTERO, CENTROCAMPISTA, DEFENSA, DELANTERO}
    private int id;
    
    private String alias;
    private String codEquipo;
    private Puesto puesto;
    private float altura;

    public Futbolista()
    {
    }

    public Futbolista(int id, String alias, String codEquipo, Puesto puesto, float altura)
    {
        this.id = id;
        this.alias = alias;
        this.codEquipo = codEquipo;
        this.puesto = puesto;
        this.altura = altura;
    }

    public int getId()
    {
        return id;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getCodEquipo()
    {
        return codEquipo;
    }

    public Puesto getPuesto()
    {
        return puesto;
    }

    public float getAltura()
    {
        return altura;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public void setCodEquipo(String codEquipo)
    {
        this.codEquipo = codEquipo;
    }

    public void setPuesto(Puesto puesto)
    {
        this.puesto = puesto;
    }

    public void setAltura(float altura)
    {
        this.altura = altura;
    }

    @Override
    public String toString()
    {
        return "Futbolista{" + "id=" + id + ", alias=" + alias + ", codEquipo=" + codEquipo + ", puesto=" + puesto + ", altura=" + altura + '}';
    }
    
    
    
    
}
