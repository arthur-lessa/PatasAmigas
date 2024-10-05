package model;

public class Adotante extends Pessoa {
    private String preferenciasDeAdocao;
    private String adocoes;
    private String status;

    public Adotante(){}

    public Adotante(String nome, String dataDeNascimento, String genero, String cpf,
                    String endereco, String telefone, String email, String senha,
                    int idAdotante, String preferenciasDeAdocao, String adocoes, String status) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha); // Passa os atributos da Pessoa
        this.addPapel("idAdotante", idAdotante); // Adiciona idAdotante ao mapa de papeis
        this.preferenciasDeAdocao = preferenciasDeAdocao;
        this.adocoes = adocoes;
        this.status = status;
    }

    // Getters e Setters para os atributos específicos de Adotante
    public String getPreferenciasDeAdocao() {
        return preferenciasDeAdocao;
    }

    public void setPreferenciasDeAdocao(String preferenciasDeAdocao) {
        this.preferenciasDeAdocao = preferenciasDeAdocao;
    }

    public String getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(String adocoes) {
        this.adocoes = adocoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Adotante{" +
                "nome='" + getNome() + '\'' +
                ", dataDeNascimento='" + getDataDeNascimento() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", papeis=" + getPapeis() +
                ", preferenciasDeAdocao='" + preferenciasDeAdocao + '\'' +
                ", adocoes='" + adocoes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
