package exercicio;

import part3.Aluno;
import part3.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // 1 - Consulta
    public List<Curso> list() {
        //Preparar lista que irá retornar alunos após consultar o banco de dados;
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL.
            String sql = "SELECT * FROM curso";

            //Preparar statement com os parâmetros recebidos (nesta função não tem parâmetros, pois irá retornar todos os valores da tabela aluno)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Criar um objeto aluno e guardar na lista de alunos.
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");


                cursos.add(new Curso(
                        id,
                        nome,
                        duracaoHoras
                ));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        //Retornar todos os alunos encontrados no banco de dados.
        return cursos;
    }

    // 1.1 - Consulta com filtro
    public Curso getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL
            String sql = "SELECT * FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guardar valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));

            }

        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return curso;
    }

    // 2 - Inserção
    public void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());


            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}
