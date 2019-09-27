/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jessi
 */
public class ExpertoEnMaterias {
    public List getMaterias(String semestre) {
        List materias = new ArrayList();
        switch(semestre) {
            case "primero":
                materias.add("Calculo diferencial");
                materias.add("Etica");
                materias.add("Matematicas discretas");
                materias.add("Fundamentos de investigacion");
                break;
            case "segundo":
                materias.add("Calculo integral");
                materias.add("Programacion orientada a objetos");
                materias.add("Materia segundo");
                break;
            case "tercero":
                materias.add("Desarrollo sustentable");
                materias.add("Cultura empresarial");
                materias.add("Investigacion de operaciones");
                break;
            case "cuarto":
                materias.add("Topicos avanzados de programacion");
                materias.add("Ecuaciones diferenciales");
                break;
            case "quinto":
                materias.add("Arquitectura de computadoras");
                materias.add("Fundamentos de ingenieria de software");
                break;
            case "sexto":
                materias.add("Lenguajes de interfaz");
                materias.add("Ingenieria de software");
                break;
            case "septimo":
                materias.add("Gestion de proyectos");
                materias.add("Taller de investigacion I");
                break;
            case "octavo":
                materias.add("Taller de investigacion II");
                materias.add("Programacion Logica y Funcional");
                break;
            case "noveno":
                materias.add("Inteligencia artificial");
                materias.add("Residencias");
                break;
        }
        return materias;
    }
}