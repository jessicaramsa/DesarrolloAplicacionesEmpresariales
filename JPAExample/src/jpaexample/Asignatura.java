/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "asignatura")
@XmlRootElement
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "creditos")
    private Float creditos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;

    public Asignatura() {}

    public Asignatura(Integer idAsignatura, String tipo, String nombre, Float creditos) {
        this.idAsignatura = idAsignatura;
        this.tipo = tipo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Asignatura(Integer idAsignatura, String tipo, String nombre) {
        this.idAsignatura = idAsignatura;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCreditos() {
        return creditos;
    }

    public void setCreditos(Float creditos) {
        this.creditos = creditos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaexample.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }

    public Collection<AlumnoAsignatura> getAlumnoAsignaturaCollection() {
        return alumnoAsignaturaCollection;
    }

    public void setAlumnoAsignaturaCollection(Collection<AlumnoAsignatura> alumnoAsignaturaCollection) {
        this.alumnoAsignaturaCollection = alumnoAsignaturaCollection;
    }
}
