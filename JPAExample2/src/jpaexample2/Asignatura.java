/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByIdAsignatura", query = "SELECT a FROM Asignatura a WHERE a.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Asignatura.findByTipo", query = "SELECT a FROM Asignatura a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignatura.findByCreditos", query = "SELECT a FROM Asignatura a WHERE a.creditos = :creditos")})
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "creditos")
    private Float creditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;

    public Asignatura() {}

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
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

    @XmlTransient
    public Collection<AlumnoAsignatura> getAlumnoAsignaturaCollection() {
        return alumnoAsignaturaCollection;
    }

    public void setAlumnoAsignaturaCollection(Collection<AlumnoAsignatura> alumnoAsignaturaCollection) {
        this.alumnoAsignaturaCollection = alumnoAsignaturaCollection;
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
        return "jpaexample2.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }
}
