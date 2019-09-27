/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexample;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "alumno_asignatura")
@XmlRootElement
public class AlumnoAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoAsignaturaPK alumnoAsignaturaPK;
    
    @Column(name = "cursada")
    private Character cursada;
    
    //Asociaciones entre clases correspondientes a las relaciones entre tablas
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public AlumnoAsignatura() {}

    public AlumnoAsignatura(AlumnoAsignaturaPK alumnoAsignaturaPK, Character cursada, Alumno alumno, Asignatura asignatura) {
        this.alumnoAsignaturaPK = alumnoAsignaturaPK;
        this.cursada = cursada;
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

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

    public Character getCursada() {
        return cursada;
    }

    public void setCursada(Character cursada) {
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
}
