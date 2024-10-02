public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancias de Estudiante y Curso
            Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-05-15", Estudiante.Estado.MATRICULADO);
            Curso curso1 = new Curso(101, "Programación en Java", "Curso de introducción a Java", 3, "1.0");

            // Instanciar GestorAcademico
            GestorAcademico gestor = new GestorAcademico();
            
            // Matricular estudiante
            gestor.matricularEstudiante(estudiante1);
            // Agregar curso
            gestor.agregarCurso(curso1);
            // Inscribir estudiante en curso
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());

            // Desinscribir estudiante del curso
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
