/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample2;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "alumnos_asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoAsignatura.findAll", query = "SELECT a FROM AlumnoAsignatura a")
    , @NamedQuery(name = "AlumnoAsignatura.findByIdAlumno", query = "SELECT a FROM AlumnoAsignatura a WHERE a.alumnoAsignaturaPK.idAlumno = :idAlumno")
    , @NamedQuery(name = "AlumnoAsignatura.findByIdAsignatura", query = "SELECT a FROM AlumnoAsignatura a WHERE a.alumnoAsignaturaPK.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "AlumnoAsignatura.findByCursada", query = "SELECT a FROM AlumnoAsignatura a WHERE a.cursada = :cursada")})
public class AlumnoAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoAsignaturaPK alumnoAsignaturaPK;
    @Column(name = "cursada")
    private String cursada;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public AlumnoAsignatura() {}

    public AlumnoAsignatura(AlumnoAsignaturaPK alumnoAsignaturaPK) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
    }

    public AlumnoAsignatura(int idAlumno, int idAsignatura) {
        this.alumnoAsignaturaPK = new AlumnoAsignaturaPK(idAlumno, idAsignatura);
    }

    public AlumnoAsignaturaPK getAlumnoAsignaturaPK() {
        return alumnoAsignaturaPK;
    }

    public void setAlumnoAsignaturaPK(AlumnoAsignaturaPK alumnoAsignaturaPK) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
    }

    public String getCursada() {
        return cursada;
    }

    public void setCursada(String cursada) {
        this.cursada = cursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnoAsignaturaPK != null ? alumnoAsignaturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoAsignatura)) {
            return false;
        }
        AlumnoAsignatura other = (AlumnoAsignatura) object;
        if ((this.alumnoAsignaturaPK == null && other.alumnoAsignaturaPK != null) || (this.alumnoAsignaturaPK != null && !this.alumnoAsignaturaPK.equals(other.alumnoAsignaturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaexample2.AlumnoAsignatura[ alumnoAsignaturaPK=" + alumnoAsignaturaPK + " ]";
    }
}
