/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kp215
 */
@Entity
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
    , @NamedQuery(name = "Materias.findById", query = "SELECT m FROM Materias m WHERE m.id = :id")
    , @NamedQuery(name = "Materias.findByNombre", query = "SELECT m FROM Materias m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Materias.findBySemestre", query = "SELECT m FROM Materias m WHERE m.semestre = :semestre")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "semestre")
    private int semestre;

    public Materias() {
    }

    public Materias(Integer id) {
        this.id = id;
    }

    public Materias(Integer id, String nombre, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlador.Materias[ id=" + id + " ]";
    }
    
    public String toJson() {
        return "{\n"
                + "\"id\":" + this.id + ",\n"
                + "\"nombre\":" + this.nombre + ",\n"
                + "\"semestre\":" + this.semestre + "\n"
                + 
                "}";
    }
    
    
    public static String collectionToJson(Collection<Materias> materias) {
        String s = "[";
        int i = 0, c = materias.size();
        for(Materias m : materias) {
            s += m.toJson();
            s += (i < c - 1) ? "0" : ", ";
        }
        return s + "]";
    }
    
}
