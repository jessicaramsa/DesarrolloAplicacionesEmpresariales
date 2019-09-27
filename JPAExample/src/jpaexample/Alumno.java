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
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_alumno")
    private Integer idAlumno;
    
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "curso")
    private Integer curso;
    
    @Column(name = "titulacion")
    private Integer titulacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;
    
    public Alumno() {
    }

    public Alumno(Integer idAlumno, String apellidos, String nombre, Integer curso, Integer titulacion) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.curso = curso;
        this.titulacion = titulacion;
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String apellidos, String nombre) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.nombre = nombre;
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
        return "jpaexample.Alumno[ idAlumno=" + idAlumno + " ]";
    }

    public Collection<AlumnoAsignatura> getAlumnoAsignaturaCollection() {
        return alumnoAsignaturaCollection;
    }

    public void setAlumnoAsignaturaCollection(Collection<AlumnoAsignatura> alumnoAsignaturaCollection) {
        this.alumnoAsignaturaCollection = alumnoAsignaturaCollection;
    }
    
    @PrePersist
    @PreUpdate
    private void validarNomApe() {
        if (nombre == null || "".equals(nombre))
            throw new IllegalArgumentException("Nombre no válido");
        
        if (apellidos == null || "".equals(apellidos))
            throw new IllegalArgumentException("Apellidos no válidos");
    }
    
    @Transient
    private String alumInfo;
    
    @PostUpdate
    @PostPersist
    @PostLoad
    public void info() {
        alumInfo =idAlumno + ", " +
                apellidos + ",, " +
                nombre + ", " +
                curso + ", " +
                titulacion + "\n";
        System.out.println(alumInfo);
    }
}
