import java.util.List;

public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante) throws Exception;
    void agregarCurso(Curso curso) throws Exception;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
