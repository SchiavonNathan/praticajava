package eliel.prova.praticajava.dto;

public class PessoaDTO {

    private int id;
    private String nome;
    private String cpf;
    private String trabalhoNome; 

    public PessoaDTO(int id, String nome, String cpf, String trabalhoNome) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.trabalhoNome = trabalhoNome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTrabalhoNome() {
        return trabalhoNome;
    }

    public void setTrabalhoNome(String trabalhoNome) {
        this.trabalhoNome = trabalhoNome;
    }
}
