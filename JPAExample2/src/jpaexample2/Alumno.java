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
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno")
    , @NamedQuery(name = "Alumno.findByApellidos", query = "SELECT a FROM Alumno a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByCurso", query = "SELECT a FROM Alumno a WHERE a.curso = :curso")
    , @NamedQuery(name = "Alumno.findByTitulacion", query = "SELECT a FROM Alumno a WHERE a.titulacion = :titulacion")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_alumno")
    private Integer idAlumno;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "curso")
    private Integer curso;
    @Column(name = "titulacion")
    private Integer titulacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;

    public Alumno() {}

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    // CONSTRUCTOR CREAR UN ALUMNO
    public Alumno(Integer idAlumno, String apellidos, String nombre, Integer curso, Integer titulacion) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.curso = curso;
        this.titulacion = titulacion;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Integer titulacion) {
        this.titulacion = titulacion;
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
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaexample2.Alumno[ idAlumno=" + idAlumno + ", "
                + "apellidos= " + apellidos + ", "
                + "nombre=" + nombre + ", "
                + "curso=" + curso + ", "
                + "titulacion=" + titulacion
                + " ]";
    }
}
