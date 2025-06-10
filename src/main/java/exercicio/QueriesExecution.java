package exercicio;

import part3.Aluno;
import part3.AlunoDAO;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {

    CursoDAO cursoDAO = new CursoDAO();

    // =========================== 1 - Consulta =================================================
    List<Curso> cursos = cursoDAO.list();

    cursos.stream().forEach(System.out::println);


    // ======================= 1.1 - Consulta com filtro ========================================
    Curso cursoParaConsulta = cursoDAO.getById(1);

    System.out.println(cursoParaConsulta);


    // =========================== 2 - Inserção =================================================
    Curso cursoParaInsercao = new Curso(

            "Java Avançado",
            40
    );

    cursoDAO.create(cursoParaInsercao);


    // =========================== 3 - Delete ===================================================
    cursoDAO.delete(1);


    // =========================== 4 - Atualizar ================================================
    Curso cursoParaAtualizar = cursoDAO.getById(4);
    cursoParaAtualizar.setNome("Formação Java Completa");
    cursoParaAtualizar.setDuracaoHoras(120);
    cursoDAO.update(cursoParaAtualizar);

    }

}
