package exercicio;

public class Curso {

    private int id;
    private  String nome;
    private int duracaoHoras;

    public Curso(int id, String nome, int horas) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = horas;
    }

    public Curso(String nome, int horas) {
        this.nome = nome;
        this.duracaoHoras = horas;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracaoHoras=").append(duracaoHoras);
        sb.append('}');
        return sb.toString();
    }

}
