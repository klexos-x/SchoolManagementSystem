import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicos {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones = new HashMap<>();

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws Exception {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        } else {
            throw new Exception("Estudiante ya matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) throws Exception {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        } else {
            throw new Exception("Curso ya existente.");
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (inscripciones.containsKey(idCurso)) {
            if (inscripciones.get(idCurso).contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
            } else {
                inscripciones.get(idCurso).add(estudiante);
            }
        } else {
            ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
            listaEstudiantes.add(estudiante);
            inscripciones.put(idCurso, listaEstudiantes);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (inscripciones.containsKey(idCurso) && inscripciones.get(idCurso).removeIf(e -> e.getId() == idEstudiante)) {
            return;
        }
        throw new EstudianteNoInscritoEnCursoException("Estudiante no está inscrito en este curso.");
    }
}
