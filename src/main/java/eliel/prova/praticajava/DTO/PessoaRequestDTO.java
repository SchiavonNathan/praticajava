package eliel.prova.praticajava.dto;

public class PessoaRequestDTO {

    private String nome;
    private String cpf;
    private Integer trabalhoId;

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

    public Integer getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(Integer trabalhoId) {
        this.trabalhoId = trabalhoId;
    }
}
